package com.wsfzsc.pojo;

public class SuperAdmin {
    private Integer superadminId;//超级管理员id
    private String superadminUsername;//超级管理员账号
    private Integer superadminPassword;//超级管理员密码

    public Integer getSuperadminId() {return superadminId;}

    public void setSuperadminId(Integer superadminId) {this.superadminId = superadminId;}

    public String getSuperadminUsername() {return superadminUsername;}

    public void setSuperadminUsername(String superadminUsername) {this.superadminUsername = superadminUsername;}

    public Integer getSuperadminPassword() {return superadminPassword;}

    public void setSuperadminPassword(Integer superadminPassword) {this.superadminPassword = superadminPassword;}

    @Override
    public String toString() {
        return "SuperAdmin{" +
                "superadminId=" + superadminId +
                ", superadminUsername='" + superadminUsername + '\'' +
                ", superadminPassword=" + superadminPassword +
                '}';
    }
}
