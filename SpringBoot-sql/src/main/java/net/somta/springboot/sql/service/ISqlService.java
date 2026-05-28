package net.somta.springboot.sql.service;

import java.util.List;
import java.util.Map;

public interface ISqlService {

    public Map<String, Object> querySingleDataBySql(String sql);

    public List<Map<String, Object>> queryListDataBySql(String sql);

    public Object queryDataBySql(String sql);

}
