package com.emt.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:00 2018/3/30.
 * @Modified By:
 */
public class MyDateUtil {

    public static String pattern = "yyyyMMdd";

    public static SimpleDateFormat formatter = new SimpleDateFormat(pattern);


    /**
     * 返回昨天的时间
     *
     * @return yyyyMMdd
     */
    public static String getBeforeDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date = calendar.getTime();
        return formatter.format(date);

    }

    public static Date addHour(Date dt) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.HOUR_OF_DAY, 1);
        Date dt1 = rightNow.getTime();
        return dt1;
    }


}
