package net.somta.springboot.model;

public class Role {
    private Integer id;
    private String roleName;
    private Integer userId;

    public Role(Integer id, String roleName, Integer userId) {
        this.id = id;
        this.roleName = roleName;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
