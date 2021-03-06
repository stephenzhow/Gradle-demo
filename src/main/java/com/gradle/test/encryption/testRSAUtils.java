package com.gradle.test.encryption;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import com.gradle.java.encryption.BytesToHex;
import com.gradle.java.encryption.RSAUtil;



public class testRSAUtils {

	//待加密原文
	public static final String DATA = "hi, welcome to my git area!";
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> keyMap = RSAUtil.initKey();
		
		RSAPublicKey rsaPublicKey = RSAUtil.getpublicKey(keyMap);
		RSAPrivateKey rsaPrivateKey = RSAUtil.getPrivateKey(keyMap);
		System.out.println("RSA PublicKey: " + rsaPublicKey);
		System.out.println("RSA PrivateKey: " + rsaPrivateKey);
		//公钥加密
		byte[] rsaResult = RSAUtil.encrypt(DATA.getBytes(), rsaPublicKey);
		System.out.println(DATA + "====>>>> RSA 加密>>>>====" + BytesToHex.fromBytesToHex(rsaResult));
		//System.out.println(DATA + "====>>>> RSA 加密>>>>====" + new String(rsaResult, "utf-8"));
		//私钥解密
		byte[] plainResult = RSAUtil.decrypt(rsaResult, rsaPrivateKey);
		System.out.println(DATA + "====>>>> RSA 解密>>>>====" + BytesToHex.fromBytesToHex(plainResult));
		System.out.println(DATA + "====>>>> RSA 解密>>>>====" + new String(plainResult,"utf-8"));
	}
}
