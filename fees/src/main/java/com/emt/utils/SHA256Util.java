package com.emt.utils;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in20:35 2018/12/3.
 * @Modified By:
 */
public class SHA256Util {
    public static String create(String data, String key) throws Exception {

      return  WXPayUtil.HMACSHA256(data,key);

    }

}
