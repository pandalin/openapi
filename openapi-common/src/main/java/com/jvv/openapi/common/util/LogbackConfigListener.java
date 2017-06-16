/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 13:16 创建
 *
 */
package com.jvv.openapi.common.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import com.jvv.openapi.common.exception.CommonException;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;

/**
 * @author turalyon@jinvovo.com
 */
public class LogbackConfigListener implements ServletContextListener {

	private static final String CONFIG_LOCATION = "logbackConfigLocation";

	public static final String PLACEHOLDER_PREFIX = "${";

	public static final String PLACEHOLDER_SUFFIX = "}";

	public static final String CLASSPATH_URL_PREFIX = "classpath:";

	public static final String DEFAULT_LOCATION = "WEB-INF/logback.xml";

	@Override
	public void contextInitialized (ServletContextEvent event) {
		//1.从web.xml中加载指定文件名的日志配置文件
		String logbackConfigLocation = event.getServletContext ().getInitParameter (CONFIG_LOCATION);
		//2.如果为空，使用默认配置文件
		if (logbackConfigLocation == null || "".endsWith (logbackConfigLocation.trim ())) {
			logbackConfigLocation = DEFAULT_LOCATION;
		}
		try {
			logbackConfigLocation = resolveSystemPropertyPlaceholder (logbackConfigLocation);
			if (isClassPath (logbackConfigLocation)) {
				logbackConfigLocation = resolveClasspath (logbackConfigLocation);
			} else if (!isUrl (logbackConfigLocation)) {
				logbackConfigLocation = getRealPath (event.getServletContext (),
						logbackConfigLocation);
			}
			LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory ();
			loggerContext.reset ();
			JoranConfigurator joranConfigurator = new JoranConfigurator ();
			joranConfigurator.setContext (loggerContext);
			//加载日志文件
			joranConfigurator.doConfigure (logbackConfigLocation);
			event.getServletContext ().log ("加载logback日志文件：" + logbackConfigLocation);
			adjustJDKLog ();
			event.getServletContext ().log ("jul日志输出到logback");
			event.getServletContext ().log ("*********************");
		} catch (Exception e) {
			event.getServletContext ().log ("加载logback配置文件[" + logbackConfigLocation + "]失败", e);
			throw new RuntimeException ("加载logback配置文件[" + logbackConfigLocation + "]失败", e);
		}
		Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread
				.getDefaultUncaughtExceptionHandler ();
		UncaughtExceptionHandlerWrapper uncaughtExceptionHandlerWrapper = new UncaughtExceptionHandlerWrapper (
				uncaughtExceptionHandler);
		Thread.setDefaultUncaughtExceptionHandler (uncaughtExceptionHandlerWrapper);
		event.getServletContext ().log ("设置默认线程未捕获异常处理器:" + uncaughtExceptionHandlerWrapper);

	}

	/**
	 * 1.jdk日志没有加上SLF4JBridgeHandler时才去新增 2.删除ConsoleHandler
	 */
	private void adjustJDKLog () {
		Handler[] handlers = LogManager.getLogManager ().getLogger ("").getHandlers ();
		boolean existSLF4JBridgeHandler = false;
		if (handlers != null) {
			for (Handler handler : handlers) {
				if (handler instanceof SLF4JBridgeHandler) {
					existSLF4JBridgeHandler = true;
				}
				if (handler instanceof ConsoleHandler) {
					LogManager.getLogManager ().getLogger ("").removeHandler (handler);
				}
			}
		}
		if (!existSLF4JBridgeHandler) {
			SLF4JBridgeHandler.install ();
		}
	}

	@Override
	public void contextDestroyed (ServletContextEvent event) {
		ShutdownHooks.shutdownAll ();
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory ();
		loggerContext.stop ();
	}

	private static String resolveClasspath (String resourceLocation) {
		String path = resourceLocation.substring (CLASSPATH_URL_PREFIX.length ());
		URL url = getDefaultClassLoader ().getResource (path);
		if (url == null) {
			throw new CommonException("没有找到logback配置文件:" + resourceLocation);
		}
		return url.getFile ();

	}

	private static ClassLoader getDefaultClassLoader () {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread ().getContextClassLoader ();
		} catch (Throwable ex) {
			//ignore
		}
		if (cl == null) {
			cl = LogbackConfigListener.class.getClassLoader ();
		}
		return cl;
	}

	/**
	 * 解析环境变量 ${evn.name}
	 *
	 * @param str
	 *
	 * @return
	 */
	private static String resolveSystemPropertyPlaceholder (String str) {
		StringBuilder buf = new StringBuilder (str);
		int begin = buf.indexOf (PLACEHOLDER_PREFIX);
		if (begin < 0) {
			return str;
		}
		int end = buf.indexOf (PLACEHOLDER_SUFFIX, begin);
		if (end < 0) {
			return str;
		}
		String placeholderName = buf.substring (begin + PLACEHOLDER_PREFIX.length (), end);
		String propVal = System.getProperty (placeholderName);
		if (propVal == null) {
			propVal = System.getenv (placeholderName);
		}
		if (propVal == null) {
			propVal = "";
		}
		buf.replace (begin, end + 1, propVal);
		//递归解析
		return resolveSystemPropertyPlaceholder (buf.toString ());
	}

	private static boolean isUrl (String resourceLocation) {
		if (resourceLocation == null) {
			return false;
		}
		try {
			new URL (resourceLocation);
			return true;
		} catch (MalformedURLException ex) {
			return false;
		}
	}

	private static boolean isClassPath (String logbackConfigLocation) {
		return logbackConfigLocation.startsWith (CLASSPATH_URL_PREFIX);
	}

	private static String getRealPath (ServletContext servletContext, String path)
			throws FileNotFoundException {
		if (!path.startsWith ("/")) {
			path = "/" + path;
		}
		String realPath = servletContext.getRealPath (path);
		if (realPath == null) {
			throw new FileNotFoundException ("ServletContext resource [" + path
											 + "] cannot be resolved to absolute file path - "
											 + "web application archive not expanded?");
		}
		return realPath;
	}

	/**
	 * 默认线程未捕获异常处理器,清理线程变量.
	 */
	private static class UncaughtExceptionHandlerWrapper implements Thread.UncaughtExceptionHandler {
		private static org.slf4j.Logger logger = LoggerFactory
				.getLogger (UncaughtExceptionHandlerWrapper.class);
		private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

		public UncaughtExceptionHandlerWrapper (Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler) {
			this.defaultUncaughtExceptionHandler = defaultUncaughtExceptionHandler;
		}

		@Override
		public void uncaughtException (Thread t, Throwable e) {
			logger.error ("线程[{}]遇到没有捕获的异常,清理线程变量...", t.getName (), e);
			if (defaultUncaughtExceptionHandler != null) {
				defaultUncaughtExceptionHandler.uncaughtException (t, e);
			}
		}
	}
}
