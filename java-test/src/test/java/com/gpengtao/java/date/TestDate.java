package com.gpengtao.java.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by pengtao.geng on 2017/7/13.
 */
public class TestDate {

    @Test
    public void test_week() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = format.parse("2016-01-01");

        System.out.println(new SimpleDateFormat("yyyy-MM-dd EEEE").format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);

        System.out.println("查看第一周最少几天: " + calendar.getMinimalDaysInFirstWeek());
        System.out.println("getFirstDayOfWeek是：" + calendar.getFirstDayOfWeek());
        System.out.println("DAY_OF_WEEK是：" + calendar.get(Calendar.DAY_OF_WEEK));

        System.out.println("一年的第几周：" + calendar.get(Calendar.WEEK_OF_YEAR));

    }
}
