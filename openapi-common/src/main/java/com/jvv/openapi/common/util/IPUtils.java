/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 12:20 创建
 *
 */
package com.jvv.openapi.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

/**
 * @author turalyon@jinvovo.com
 */
public class IPUtils {
	private static String macAddress = null;
	private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);
	private static final String LOOP_BACK = "127.0.0.1";
	private static String firstNoLoopbackAddress = null;
	private static String firstNoLoopbackIPV4Address = null;
	private static String firstNoLoopbackIPV6Address = null;
	private static Collection<InetAddress> allHostIPV4Address = null;

	/**
	 * 获取mac地址
	 *
	 * @return
	 * @throws Exception
	 */
	public static String getMACAddress() throws Exception {
		if (macAddress == null) {
			macAddress = getMacByNetworkInterface();
			if (macAddress == null) {
				macAddress = getMacByProcess();
			}
		}
		return macAddress;
	}

	private static String getMacByNetworkInterface() {
		String out = null;
		try {
			Enumeration<NetworkInterface> ifs = NetworkInterface.getNetworkInterfaces();
			if (ifs != null) {
				while (ifs.hasMoreElements()) {
					NetworkInterface iface = ifs.nextElement();
					byte[] hardware = iface.getHardwareAddress();
					if (hardware != null && hardware.length == 6 && hardware[1] != (byte) 0xff) {
						out = formatMac(hardware);
						break;
					}
				}
			}
		} catch (SocketException ex) {
			// Ignore it.
		}
		return out;
	}

	/**
	 * 获取ipv4地址，如果有多个网卡的情况，获取第一个非loopback ip地址
	 *
	 * @return
	 */
	public static String getFirstNoLoopbackIPV4Address() {
		if (firstNoLoopbackIPV4Address != null) {
			return firstNoLoopbackIPV4Address;
		}
		Collection<String> allNoLoopbackAddresses = null;
		try {
			allNoLoopbackAddresses = getAllNoLoopbackIPV4Addresses();
		} catch (Exception e) {
			logger.error("获取ip失败", e);
			return LOOP_BACK;
		}
		if (allNoLoopbackAddresses.isEmpty()) {
			return LOOP_BACK;
		}

		return firstNoLoopbackIPV4Address = allNoLoopbackAddresses.iterator().next();
	}

	/**
	 * 获取所有本机非loopback IPV4地址
	 *
	 * @return
	 */
	public static Collection<String> getAllNoLoopbackIPV4Addresses() {
		Collection<String> noLoopbackAddresses = new ArrayList<String>();
		Collection<InetAddress> allInetAddresses = getAllHostIPV4Address();

		for (InetAddress address : allInetAddresses) {
			if (!address.isLoopbackAddress()) {
				noLoopbackAddresses.add(address.getHostAddress());
			}
		}

		return noLoopbackAddresses;
	}

	/**
	 * 获取所有本机ipv4地址
	 *
	 * @return
	 */
	public static Collection<InetAddress> getAllHostIPV4Address() {
		if (allHostIPV4Address == null) {
			try {
				Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
				Collection<InetAddress> addresses = new ArrayList<InetAddress>();

				while (networkInterfaces.hasMoreElements()) {
					NetworkInterface networkInterface = networkInterfaces.nextElement();
					Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
					while (inetAddresses.hasMoreElements()) {
						InetAddress inetAddress = inetAddresses.nextElement();
						if (inetAddress instanceof Inet4Address) {
							addresses.add(inetAddress);
						}
					}
				}
				allHostIPV4Address = addresses;
			} catch (SocketException e) {
				logger.error("获取ip地址失败", e);
				throw new RuntimeException(e.getMessage(), e);
			}

		}
		return allHostIPV4Address;
	}

	private static String formatMac(byte[] mac) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		return sb.toString().toUpperCase();
	}

	private static String getMacByProcess() {
		String macA = null;
		Process p = null;
		BufferedReader in = null;

		try {
			String osname = System.getProperty("os.name", ""), osver = System.getProperty("os.version", "");

			if (osname.startsWith("Windows")) {
				p = Runtime.getRuntime().exec(new String[] { "ipconfig", "/all" }, null);
			}

			// Solaris code must appear before the generic code
			else if (osname.startsWith("Solaris") || osname.startsWith("SunOS")) {
				if (osver.startsWith("5.11")) {
					p = Runtime.getRuntime().exec(new String[] { "dladm", "show-phys", "-m" }, null);
				} else {
					String hostName = getFirstLineOfCommand("uname", "-n");
					if (hostName != null) {
						p = Runtime.getRuntime().exec(new String[] { "/usr/sbin/arp", hostName }, null);
					}
				}
			} else if (new File("/usr/sbin/lanscan").exists()) {
				p = Runtime.getRuntime().exec(new String[] { "/usr/sbin/lanscan" }, null);
			} else if (new File("/sbin/ifconfig").exists()) {
				p = Runtime.getRuntime().exec(new String[] { "/sbin/ifconfig", "-a" }, null);
			}

			if (p != null) {
				in = new BufferedReader(new InputStreamReader(p.getInputStream()), 128);
				String l = null;
				while ((l = in.readLine()) != null) {
					macA = parseMAC(l);
					if (macA != null && parseHex(macA) != 0xff) {
						break;
					}
				}
			}

		} catch (SecurityException ex) {
			// Ignore it.
		} catch (IOException ex) {
			// Ignore it.
		} finally {
			if (p != null) {
				if (in != null) {
					try {
						in.close();
					} catch (IOException ex) {
						// Ignore it.
					}
				}
				try {
					p.getErrorStream().close();
				} catch (IOException ex) {
					// Ignore it.
				}
				try {
					p.getOutputStream().close();
				} catch (IOException ex) {
					// Ignore it.
				}
				p.destroy();
			}
		}
		if (macA != null) {
			macA = macA.toUpperCase();
		}
		return macA;
	}

	static String getFirstLineOfCommand(String... commands) throws IOException {

		Process p = null;
		BufferedReader reader = null;

		try {
			p = Runtime.getRuntime().exec(commands);
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()), 128);

			return reader.readLine();
		} finally {
			if (p != null) {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ex) {
						// Ignore it.
					}
				}
				try {
					p.getErrorStream().close();
				} catch (IOException ex) {
					// Ignore it.
				}
				try {
					p.getOutputStream().close();
				} catch (IOException ex) {
					// Ignore it.
				}
				p.destroy();
			}
		}

	}

	/**
	 * 将long转换为十六进制表示
	 *
	 * @param num
	 * @return
	 */
	public static String toHex(long num) {
		return Long.toHexString(num).toUpperCase();
	}

	/**
	 * 将十六进制表示的数字转换为long
	 *
	 * @param hex
	 * @return
	 */
	public static long parseHex(String hex) {
		return Long.parseLong(hex, 16);
	}

	/**
	 * Attempts to find a pattern in the given String.
	 *
	 * @param in the String, may not be <code>null</code>
	 * @return the substring that matches this pattern or <code>null</code>
	 */
	private static String parseMAC(String in) {

		String out = in;

		// lanscan

		int hexStart = out.indexOf("0x");
		if (hexStart != -1 && out.indexOf("ETHER") != -1) {
			int hexEnd = out.indexOf(' ', hexStart);
			if (hexEnd > hexStart + 2) {
				out = out.substring(hexStart, hexEnd);
			}
		} else {

			int octets = 0;
			int lastIndex, old, end;

			if (out.indexOf(':') > -1) {
				out = out.replace(':', '-');
			}

			lastIndex = out.lastIndexOf('-');

			if (lastIndex > out.length() - 2) {
				out = null;
			} else {

				end = Math.min(out.length(), lastIndex + 3);

				++octets;
				old = lastIndex;
				while (octets != 5 && lastIndex != -1 && lastIndex > 1) {
					lastIndex = out.lastIndexOf('-', --lastIndex);
					if (old - lastIndex == 3 || old - lastIndex == 2) {
						++octets;
						old = lastIndex;
					}
				}

				if (octets == 5 && lastIndex > 1) {
					out = out.substring(lastIndex - 2, end).trim();
				} else {
					out = null;
				}

			}

		}

		if (out != null && out.startsWith("0x")) {
			out = out.substring(2);
		}

		return out;
	}

}
