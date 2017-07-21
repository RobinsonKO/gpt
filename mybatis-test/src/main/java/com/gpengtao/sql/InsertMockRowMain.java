package com.gpengtao.sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.gpengtao.sql.model.ColumnDesc;
import com.gpengtao.sql.util.TableInfoUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by pengtao.geng on 2017/7/21.
 */
public class InsertMockRowMain {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("mybatis-test/target/db.properties"));

        System.out.println("数据配置信息：" + properties);

        String url = properties.getProperty("jdbc_url");
        String username = properties.getProperty("jdbc_username");
        String password = properties.getProperty("jdbc_password");
        String tableName = properties.getProperty("jdbc_table_name");

        SingleConnectionDataSource dataSource = new SingleConnectionDataSource(url, username, password, false);

        List<ColumnDesc> columnDescList = TableInfoUtil.findTableColumnInfo(dataSource, tableName);

        columnDescList.forEach(System.out::println);

        List<ColumnDesc> insertColumns = columnDescList.stream()
                .filter(columnDesc -> !columnDesc.getExtra().contains("auto_increment"))
                .collect(Collectors.toList());


        String columnForInsertString = Joiner.on(",").join(insertColumns.stream().map(ColumnDesc::getField).collect(Collectors.toList()));

        for (int i = 0; i < 20; i++) {
            List<String> valueStrings = Lists.newArrayList();
            for (int j = 0; j < 10; j++) {

                List<Object> values = Lists.newArrayList();
                for (ColumnDesc column : insertColumns) {
                    values.add(makeValue(column));
                }

                valueStrings.add("(" + Joiner.on(",").join(values) + ")");
            }

            String template = "insert into %s (%s) values %s";

            String sql = String.format(template, tableName, columnForInsertString, Joiner.on(",").join(valueStrings));

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.execute(sql);
        }

    }

    private static Object makeValue(ColumnDesc column) {
        String type = column.getType();
        String field = column.getField();
        if (type.startsWith("int") || type.startsWith("decimal") || type.startsWith("bigint")) {
            return makeAbsNumber(field);
        }
        if (type.contains("tinyint(1)")) {
            return makeOneOrZero(field);
        }
        if (type.contains("tinyint")) {
            return makeAbsNumber(field, 5);
        }
        if (type.contains("timestamp")) {
            return makeDateString(field);
        }
        if (type.contains("varchar")) {
            return makeString(field);
        }

        throw new RuntimeException("不支持" + type);
    }

    private static int makeOneOrZero(String filed) {
        return new Random(System.currentTimeMillis() + filed.hashCode()).nextInt(1);
    }

    private static String makeString(String field) {
        return "'" + field + "_" + makeAbsNumber(field) + "'";
    }

    private static Object makeDateString(String field) {
        Date date = DateUtils.addMilliseconds(new Date(), makeNumber(field));
        return "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "'";
    }

    private static int makeAbsNumber(String column) {
        int anInt = new Random(System.currentTimeMillis() + column.hashCode()).nextInt();
        return Math.abs(anInt) % 1000000;
    }

    private static int makeAbsNumber(String field, int bound) {
        return makeAbsNumber(field) % bound;
    }

    private static int makeNumber(String column) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random(System.currentTimeMillis() + column.hashCode()).nextInt() % 100000000;
    }
}
