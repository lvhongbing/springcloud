package com.lynn.blog.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
/**
 * RSA算法
 * @author Administrator
 *
 */
public class RSAutils {

	public static final String CHARSET="UTF-8";
	public static final String RSA_ALGORITHM = "RSA";
	/**
	 * 定义了对称加密算法的具体加解密实现
	 * RSA表示该算法为RSA算法
	 * ECB为加密模式
	 * PKCS5Padding为具体的填充方式
	 */
	private static final String ALGORITHMSTR="RSA/ECB/PKCS1Padding";
	/**
	 * 创建公共钥匙，私密钥匙
	 * @param keySize
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static Map<String,String> createKeys(int keySize){
		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("no such algorithm-->"+RSA_ALGORITHM);
		}
		kpg.initialize(keySize);
		KeyPair keyPair = kpg.generateKeyPair();
		Key publicKey = keyPair.getPublic();
		String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
		Key privateKey = keyPair.getPrivate();
		String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
		Map<String,String> keyPairMap = new HashMap<>(2);
		keyPairMap.put("publicKey", publicKeyStr);
		keyPairMap.put("privateKey", privateKeyStr);
		return keyPairMap;
	}
	/**
	 * 获取publicKey
	 * @param publicKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static RSAPublicKey getPublicKey(String publicKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		//RSA算法
		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
		//Base64 解码publicKey
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
		RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
		return key;
	}
	/**
	 * 获取 privateKey
	 * @param privateKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static RSAPrivateKey getprivateKey(String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
		PKCS8EncodedKeySpec  pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
		RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
		return key;
	}
	
	public static String publicEncrypt(String data,RSAPublicKey publicKey) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			return Base64.encodeBase64String(rsaSplitCodec(cipher,
				Cipher.ENCRYPT_MODE, data.getBytes(CHARSET), publicKey.getModulus().bitLength()));
		} catch (Exception e) {
			throw new RuntimeException("加密字符串"+data+"时遇到异常",e);
		}
	}
	@SuppressWarnings({ "deprecation", "resource" })
	private static byte[] rsaSplitCodec(Cipher cipher,int opmode,byte[] datas,int keySize) {
		int maxBlock = 0;
		if(opmode == Cipher.DECRYPT_MODE) {
			maxBlock = keySize/8;
		}else {
			maxBlock = keySize/8 -11;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] buff;
		int i = 0;
		try {
			while(datas.length>offSet) {
				if(datas.length-offSet>maxBlock) {
					buff= cipher.doFinal(datas, offSet, maxBlock);
				}else {
					buff = cipher.doFinal(datas, offSet, datas.length-offSet);
				}
				out.write(buff, 0, buff.length);
				i++;
				offSet = i*maxBlock;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加解密阈值为【"+maxBlock+"】的数据时发生异常",e);
		}
		byte[] resultDatas = out.toByteArray();
		IOUtils.closeQuietly(out);
		return resultDatas;
	}
}
