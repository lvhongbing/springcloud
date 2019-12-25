package com.lynn.blog.util;

import java.security.MessageDigest;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
public class MessageDigestUtils {

	public static String encrypt(String password,String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] b = md.digest(password.getBytes());
			return ByteUtils.toHexString(b);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
