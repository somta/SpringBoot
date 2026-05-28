package net.somta.springboot.sql.service.impl;

import com.zaxxer.hikari.HikariDataSource;
import net.somta.springboot.sql.service.ISqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class SqlServiceImpl implements ISqlService {

    @Override
    public Map<String, Object> querySingleDataBySql(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Map<String, Object> rst = jdbcTemplate.queryForMap(sql);

        return rst;
    }

    @Override
    public List<Map<String, Object>> queryListDataBySql(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<Map<String, Object>> rst = jdbcTemplate.queryForList(sql);
        return rst;
    }

    @Override
    public Object queryDataBySql(String sql) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());


        // 使用queryForRowSet方法获取结果集
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        // 遍历结果集
        while (rowSet.next()) {
            //int id = rowSet.getInt("id");
            //String name = rowSet.getString("name");
            // 其他字段的获取...

            // 处理每条结果...
        }



        Object o = jdbcTemplate.query(sql,new ColumnMapRowMapper());
        System.out.println(o);

        return null;
    }

    private HikariDataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://rm-bp129qaj9mr99z9848o.mysql.rds.aliyuncs.com:3306/juggle?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false");
        dataSource.setUsername("juggle");
        dataSource.setPassword("juggle#123");
        return dataSource;
    }
}
