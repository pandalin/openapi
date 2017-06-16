/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.utils;

import com.google.common.reflect.TypeToken;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.util.GenericsUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 专用工具
 *
 * @author zhangpu
 */
public class ApiDocPrivateUtils {
    private static final Logger logger = LoggerFactory
            .getLogger(ApiDocPrivateUtils.class);

    /**
     * 获取集合对象的泛型参数类型
     *
     * @param clazz
     * @param field
     * @return
     */
    public static Class<?> getParameterGenericType(Class<?> clazz, Field field) {
        TypeToken<?> t = TypeToken.of(field.getGenericType());
        if (t.getType() instanceof ParameterizedType) {
            Type type = ((ParameterizedType) t.getType())
                    .getActualTypeArguments()[0];
            if (type.toString().length() > 1) {
                return ((Class<?>) type);
            }

            // 获取基础POJO的泛型
            Class<?> cc = clazz;
            Class<?> tt = null;
            do {
                tt = GenericsUtils.getSuperClassGenricType(cc);
                if (tt != Object.class) {
                    break;
                }
                cc = cc.getSuperclass();
            } while (cc != ApiRequest.class && cc != ApiResponse.class
                     && cc != Object.class);
            return tt;

        }
        return null;
    }

    /*public static String readSource(Class<?> clazz) throws Exception {
        URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
        String sourceFile = getClassSourcePath(clazz);
        if (StringUtils.endsWith(url.getFile(), "jar")) {
			//从class文件所在的jar包中寻找源码
			JarFile jarFile = new JarFile(url.getFile());
			JarEntry entry = jarFile.getJarEntry(sourceFile);
			//class所在jar包中未找到
			if (entry == null) {
				jarFile.close();
				// jar文件中,尝试寻找对应的源代码jar文件。
				String jarFilePath = StringUtils.substringBeforeLast(url.getFile(),
						".") + "-sources.jar";
				jarFile = new JarFile(jarFilePath);
			}
			Reader reader = new InputStreamReader(
					jarFile.getInputStream(entry), "UTF-8");
			StringWriter writer = new StringWriter();
			IOUtils.copy(reader, writer);
			IOUtils.closeQuietly(reader);
			jarFile.close();
			return writer.toString();
        } else {
            String classesRoot = url.getFile();
            // 注意，这里为简单，只支持maven工程结构
            String sourcePath = StringUtils.substringBeforeLast(classesRoot,
                    "target")
                    + File.separator
                    + "src"
                    + File.separator
                    + "main"
                    + File.separator
                    + "java"
                    + File.separator
                    + sourceFile;
            return FileUtils.readFileToString(new File(sourcePath), "UTF-8");
        }
    }

    public static String readJavaDoc(Class<?> clazz, String doclet) {
        String source = null;
        try {
            source = readSource(clazz);
            if (StringUtils.isBlank(source)) {
                return null;
            }
        } catch (Exception e) {
            logger.warn("read javadoc fail, class:{},exception:{}", clazz, e.getMessage());
            return null;
        }

        try {
            Matcher matcher = Pattern.compile(
                    "(/\\*\\*)([\\s\\S]*)(\\*//*[\\s\\S]*class)").matcher(source);
            String javadoc = null;
            if (matcher.find()) {
                javadoc = matcher.group(2);
            }
            if (javadoc == null) {
                return null;
            }
            javadoc = StringUtils.substringAfter(javadoc, "@" + doclet);
            javadoc = StringUtils.substringBefore(javadoc, "@");
            javadoc = StringUtils.trimToEmpty(StringUtils.remove(javadoc, "*"));

            return javadoc;
        } catch (Exception e) {
            logger.warn("parse javadoc fail, class:{},exception:{}", clazz, e.getMessage());
            return null;
        }
    }*/

    private static String getClassSourcePath(Class<?> clazz) {
        return StringUtils.replace(clazz.getName(), ".", "/") + ".java";
    }

}
