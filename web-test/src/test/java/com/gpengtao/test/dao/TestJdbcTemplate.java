package com.gpengtao.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by gpengtao on 4/1/15.
 */
@ContextConfiguration(locations = {"/dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJdbcTemplate {

    @Resource
    private DataSource dataSource;

    @Test
    public void testSelect() throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("use ota1");
        List<String> result = jdbcTemplate.queryForList("select name from user", String.class);
        System.out.println(result);

        try{
            jdbcTemplate.execute("use ota3");
        }catch (Exception e){
            e.printStackTrace();
        }

        List<String> ota3 = jdbcTemplate.queryForList("select name from user", String.class);
        System.out.println(ota3);
    }
}
