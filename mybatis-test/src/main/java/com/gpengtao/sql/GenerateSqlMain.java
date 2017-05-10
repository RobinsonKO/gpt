package com.gpengtao.sql;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gpengtao on 15/10/18.
 */
public class GenerateSqlMain {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://xx:3306/";
        String username = "xx";
        String password = "xx";

        String dbName = "xx";
        String tableName = "xx";

        final SingleConnectionDataSource dataSource = new SingleConnectionDataSource(url, username, password, false);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("use " + dbName);
        List<ColumnDesc> columnDescList = jdbcTemplate.query("DESC " + tableName, new RowMapper<ColumnDesc>() {
            @Override
            public ColumnDesc mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                ColumnDesc columnDesc = new ColumnDesc();
                columnDesc.setField(resultSet.getString("Field"));
                columnDesc.setType(resultSet.getString("Type"));
                columnDesc.setCanNull(resultSet.getString("Null"));
                columnDesc.setKey(resultSet.getString("Key"));
                columnDesc.setDefaultValue(resultSet.getString("Default"));
                columnDesc.setExtra(resultSet.getString("Extra"));
                return columnDesc;
            }
        });

        printInsertSql(columnDescList, tableName);

        printSelectSql(columnDescList);

        printModelFields(columnDescList);
    }

    private static void printModelFields(List<ColumnDesc> columnDescList) {
        for (ColumnDesc columnDesc : columnDescList) {
            String javaType = TypeMappings.findJaveType(columnDesc.getType());
            String propertyName = getJavaPropertyName(columnDesc.getField());
            System.out.println("private " + javaType + " " + propertyName + ";");
        }
    }

    private static void printSelectSql(List<ColumnDesc> columnDescList) {
        List<String> show = Lists.newArrayList();
        for (ColumnDesc column : columnDescList) {
            if (column.getField().contains("_")) {
                show.add(column.getField() + " as " + getJavaPropertyName(column.getField()));
            } else {
                show.add(column.getField());
            }
        }

        System.out.println(Joiner.on(",\r\n").join(show));
        System.out.println();
    }

    private static void printInsertSql(List<ColumnDesc> columnDescList, String tbaleName) {
        List<String> nameList = Lists.newArrayList();
        List<String> propertyNameList = Lists.newArrayList();
        for (ColumnDesc desc : columnDescList) {
            if ("auto_increment".equals(desc.getExtra()) || "on update CURRENT_TIMESTAMP".equals(desc.getExtra())) {
                continue;
            }
            String field = desc.getField();
            String propertyName = getJavaPropertyName(field);
            nameList.add(field);
            propertyNameList.add(propertyName);
        }

        nameList = addTab(nameList);
        List<String> propertyNameListItem = addBracketItem(propertyNameList);
        propertyNameList = addBracket(propertyNameList);
        propertyNameList = addTab(propertyNameList);
        propertyNameListItem = addTab(propertyNameListItem);

        String insertOne = "INSERT INTO %s(\r\n%s\r\n) values(\r\n%s\r\n)";
        String insertList = "INSERT INTO %s(\r\n%s\r\n) values \r\n<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">\n(\r\n%s\r\n)\n</foreach>\n";

        String show1 = String.format(insertOne,
                tbaleName,
                Joiner.on(",\r\n").join(nameList),
                Joiner.on(",\r\n").join(propertyNameList));

        String show2 = String.format(insertList,
                tbaleName,
                Joiner.on(",\r\n").join(nameList),
                Joiner.on(",\r\n").join(propertyNameListItem));

        System.out.println(show1);
        System.out.println(show2);
    }

    private static List<String> addBracketItem(List<String> nameList) {
        List<String> result = Lists.newArrayList();
        for (String name : nameList) {
            result.add("#{item." + name + "}");
        }
        return result;
    }

    private static List<String> addBracket(List<String> nameList) {
        List<String> result = Lists.newArrayList();
        for (String name : nameList) {
            result.add("#{" + name + "}");
        }
        return result;
    }

    private static List<String> addTab(List<String> nameList) {
        List<String> result = Lists.newArrayList();
        for (String name : nameList) {
            result.add("\t" + name);
        }
        return result;
    }

    private static String getJavaPropertyName(String field) {
        if (!field.contains("_")) {
            return field;
        }
        int position = field.indexOf("_");
        char at = field.charAt(position + 1);
        char upAt = at;
        if (at >= 'a' && at <= 'z') {
            upAt = (char) (at + ('A' - 'a'));
        }
        String atString = new String(new char[]{at});
        String upAtString = new String(new char[]{upAt});

        String replace = field.replace("_" + atString, upAtString);

        return getJavaPropertyName(replace);
    }
}