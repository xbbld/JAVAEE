package com.homework.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 22:23
 */

public class StringUtils {
    // 加盐方法
    private static final String SALT = "hello_salt" ;
    public static String getSalt(String info) {
        return SALT + info ;
    }
    public static String md5Encoder(String pass, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            md.update(salt.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
