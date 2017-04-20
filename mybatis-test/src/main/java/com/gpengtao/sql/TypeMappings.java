package com.gpengtao.sql;

/**
 * Created by pengtao.geng on 2017/3/15.
 */
public class TypeMappings {

    public static String findJaveType(String sqlType) {
        if (sqlType.contains("bigint")) {
            return "long";
        }
        if (sqlType.contains("date")) {
            return "Date";
        }
        if (sqlType.contains("varchar")) {
            return "String";
        }
        if (sqlType.contains("timestamp")) {
            return "Date";
        }

        throw new RuntimeException("不支持映射sqlType: " + sqlType);
    }
}
