package com.lynn.blog.util;

import java.util.Random;
import java.util.UUID;

public final class StringUtils {

	private static final char[] CHARS= {'0','1','2','3','4','5','6','7','8','9'};
	private static int char_length = CHARS.length;
	/**
	 * Empty
	 * 长度为0则返回true，否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0;
	}
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	/**
	 * Blank
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if(null==str || (strLen = str.length())==0) {
			return true;
		}
		for(int i=0;i<strLen;i++) {
			if(!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	/**
	 * 生成随机数-可用于短信验证码
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
		StringBuilder builder = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			builder.append(random.nextInt(char_length));
		}
		return builder.toString();
	}
	/**
	 * uuid
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	private StringUtils() {
		throw new AssertionError();
	}
}
