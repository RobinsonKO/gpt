package com.gpengtao.utils;

import java.util.Date;

/**
 * Created by pengtao.geng on 2016/9/29.
 */
public class DateUtil {

    private static final int secondLong = 1000;
    private static final int minuteLong = secondLong * 60;
    private static final int hourLong = minuteLong * 60;
    private static final int dayLong = hourLong * 24;

    public static String diffTimeDesc(Date small, Date big) {
        long diff = big.getTime() - small.getTime();

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


}
