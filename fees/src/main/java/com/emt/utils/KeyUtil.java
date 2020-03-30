package com.emt.utils;

import java.util.Random;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:29 2018/6/22.
 * @Modified By:
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数 有概率重复
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
