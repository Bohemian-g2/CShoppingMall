package com.wsfzsc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*密码加密的算法类*/
public class Encryption {
    public static String Encrypt(String source) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            //加密算法部分
            String newsource=sb.toString().substring(8,24);
            return newsource.substring(12)+newsource.substring(8,12)+newsource.substring(4,8)+newsource.substring(0,4);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
