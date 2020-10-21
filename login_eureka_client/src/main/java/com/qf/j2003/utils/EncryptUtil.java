package com.qf.j2003.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Description AES加密工具
 *
 * @author sunQuanxi
 * @date 2020/10/14 16:56
 */
public class EncryptUtil {
    /**
     * Description: 加密
     * @param salt 盐  password 需要加密的密码
     * @return 加密后密码
     */
    public static String AESencode(String salt, String password) {
        try {
            //创建AES的key生产者
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            //利用手机号初始化128位key生产者
            instance.init(128, new SecureRandom(salt.getBytes()));
            //生成秘钥
            SecretKey secretKey = instance.generateKey();
            //返回基本编码格式密钥
            byte[] raw = secretKey.getEncoded();
            //转换为AES专用密钥
            SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
            //创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            //初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] byteEncode = password.getBytes("utf-8");
            byte[] result = cipher.doFinal(byteEncode);
            return new BASE64Encoder().encode(result);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description: 解密
     * @param password 加密内容
     * @return 明文
     */
    public static String AESDecode(String salt, String password) {
        try {
            // 创建AES的Key生产者
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(salt.getBytes()));
            // 根据用户密码，生成一个密钥
            SecretKey secretKey = kgen.generateKey();
            byte[] dencoded = secretKey.getEncoded();
            // 转换为AES专用密钥
            SecretKeySpec key = new SecretKeySpec(dencoded, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(password);
            byte[] content = cipher.doFinal(decodeBuffer);
            // 明文
            return new String(content,"utf-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
