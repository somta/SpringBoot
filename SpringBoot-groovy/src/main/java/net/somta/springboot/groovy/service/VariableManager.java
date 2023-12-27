package net.somta.springboot.groovy.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author husong
 */
public class VariableManager {

    private Map<String,Object> map = new HashMap<>();

    public VariableManager() {
        this.map.put("name","明天的地平线");
        this.map.put("age",18);
        this.map.put("money",1000);
    }

    public Object getValue(String key){
        return map.get(key);
    }

    public Object setValue(String key,Object value){
        return map.put(key,value);
    }
}
