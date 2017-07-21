package com.gpengtao.sql.util;

import com.gpengtao.sql.model.ColumnDesc;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by pengtao.geng on 2017/7/21.
 */
public class TableInfoUtil {

    public static List<ColumnDesc> findTableColumnInfo(DataSource dataSource, String tableName) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.query("show full columns from " + tableName, (resultSet, rowNum) -> {
            ColumnDesc columnDesc = new ColumnDesc();
            columnDesc.setField(resultSet.getString("Field"));
            columnDesc.setType(resultSet.getString("Type"));
            columnDesc.setCanNull(resultSet.getString("Null"));
            columnDesc.setKey(resultSet.getString("Key"));
            columnDesc.setDefaultValue(resultSet.getString("Default"));
            columnDesc.setExtra(resultSet.getString("Extra"));
            columnDesc.setComment(resultSet.getString("Comment"));
            return columnDesc;
        });

    }
}
