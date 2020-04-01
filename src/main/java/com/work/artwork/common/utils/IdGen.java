package com.work.artwork.common.utils;

import java.util.UUID;

/**
 * 功能描述: 封装各种生成唯一性ID算法的工具类.
 *
 * @author wj
 */
public class IdGen {

    /**
     * 功能描述: 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     *
     * @author wj
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
