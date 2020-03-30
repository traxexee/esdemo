package com.emt.utils;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in17:28 2018/7/5.
 * @Modified By:
 */
public class StringUtils {
    public static String addlen(String s) {
        Integer len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5 - len.toString().length(); i++) {
            sb.append("0");
        }
        return sb.toString() + len.toString() + "|" + s;
    }
}
