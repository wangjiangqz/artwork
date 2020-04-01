package com.work.artwork.common.utils;

import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {
    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String MD5(String str){
        try {
            return DigestUtils.md5DigestAsHex(str.getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
