package com.somta.springboot.pojo;

/**
 * @Description:
 * @Date: 2019/9/5
 * @Author: 明天的地平线
 * @Blog: https://somta.com.cn/index
 * @Version: 1.0.0
 */
public class User {
    private String id;
    private String userName;
    private Integer sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
