package net.somta.springboot.sql.service.impl;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SqlServiceImplTest {

    @Test
    public void testQuerySingleDataBySql() {
        SqlServiceImpl sqlServiceImpl = new SqlServiceImpl();
        Map<String, Object> result = sqlServiceImpl.querySingleDataBySql("select * from t_api limit 1");
        System.out.println(result);
    }

    @Test
    public void testQueryListDataBySql() {
        SqlServiceImpl sqlServiceImpl = new SqlServiceImpl();
        List<Map<String, Object>> result = sqlServiceImpl.queryListDataBySql("select * from t_api");
        System.out.println(result);
    }

    @Test
    public void testQueryDataBySql() {
        SqlServiceImpl sqlServiceImpl = new SqlServiceImpl();
        //查询列表
        /*Object result = sqlServiceImpl.queryDataBySql("select * from t_api");
        System.out.println(result);*/


        //查询对象
        Object result2 = sqlServiceImpl.queryDataBySql("select * from t_api where id=1");
        System.out.println(result2);

    }

}