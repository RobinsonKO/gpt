package com.gpengtao.utils;

import java.util.Date;

/**
 * Created by pengtao.geng on 2016/9/29.
 */
public class DateUtil {

    private static final int dayLong = 1000 * 60 * 60 * 24;
    private static final int hourLong = 1000 * 60 * 60;
    private static final int minuteLong = 1000 * 60;
    private static final int secondLong = 1000;

    public static String diffTimeDesc(Date left, Date right) {
        long diff = left.getTime() - right.getTime();

        long day = diff / dayLong;
        long hour = diff % dayLong / hourLong;
        long minute = diff % dayLong % hourLong / minuteLong;
        long second = diff % dayLong % hourLong % minuteLong / secondLong;

        String result = "";
        if (second > 0) {
            result = second + "秒" + result;
        }
        if (minute > 0) {
            result = minute + "分" + result;
        }
        if (hour > 0) {
            result = hour + "小时" + result;
        }
        if (day > 0) {
            result = day + "天" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Date left = new Date(1, 2, 2, 11, 11, 11);
        Date right = new Date(1, 1, 1, 10, 10, 10);
        System.out.println(diffTimeDesc(left, right));
    }
}
