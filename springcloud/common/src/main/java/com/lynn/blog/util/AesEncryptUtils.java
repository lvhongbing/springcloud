package com.lynn.blog.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * AES算法
 * @author Administrator
 *
 */
public class AesEncryptUtils {
	/**
	 * 定义了对称加密算法的具体加解密实现
	 * AES表示该算法为AES算法
	 * ECB为加密模式
	 * PKCS5Padding为具体的填充方式
	 */
	private static final String ALGORITHMSTR="AES/ECB/PKCS5Padding";
	/**
	 * base64编码
	 * @param bytes
	 * @return
	 */
	public static String base64Encode(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}
	
	public static byte[] base64Decode(String base64Code) throws Exception{
		return Base64.decodeBase64(base64Code);
	}
	/**
	 * AES加密
	 * @param content
	 * @param encryptKey
	 * @return 返回byte[]
	 * @throws Exception
	 */
	public static byte[] aesEncryptToBytes(String content,String encryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");//初始化AES加密算法
		kgen.init(128);//长度为128
		//为加密和解密提供密码功能
		Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
		//自定义密码-加密
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(),"AES"));
		//结束多部分加密或解密操作
		return cipher.doFinal(content.getBytes("utf-8"));
	}
	/**
	 * AES加密
	 * @param content
	 * @param encryptkey
	 * @return 返回String
	 * @throws Exception
	 */
	public static String aesEncrypt(String content,String encryptkey) throws Exception {
		return base64Encode(aesEncryptToBytes(content, encryptkey));
	}
	
	/**
	 * AES解密
	 * @param encryptBytes
	 * @param decryptKey
	 * @return
	 * @throws Exception
	 */
	public static String aesDecryptByBytes(byte[] encryptBytes,String decryptKey) throws Exception {
		KeyGenerator kgn = KeyGenerator.getInstance("AES");
		kgn.init(128);
		Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
		byte[] decryptBytes=cipher.doFinal(encryptBytes);
		return new String(decryptBytes);
	}
	
	public static String aesDecrypt(String encryptStr,String decryptKey) throws Exception {
		return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
	}
}
