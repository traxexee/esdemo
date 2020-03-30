package com.emt.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in10:48 2018/7/20.
 * @Modified By:
 */
@Slf4j
public class DateUtil {


    public static Date add24Hours(Date start) {
        return new Date(start.getTime() + 1000 * 60 * 60 * 24);
    }

    public static Date getStartOfDay(String day) {
        Date start = null;
        try {
            start = new SimpleDateFormat("yyyyMMdd").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.info("时间start:{},day{}", start, day);
        return start;
    }

}
