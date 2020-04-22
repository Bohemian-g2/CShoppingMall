package com.wsfzsc.pojo;

public class Admin {
    private Integer adminId;//用户id
    private String adminUsername;//用户账号
    private String adminPassword;//用户密码
    private String AdminName;//用户姓名
    private Integer adminPhone;//用户电话

    public Integer getAdminId() { return adminId;}

    public void setAdminId(Integer adminId) {this.adminId = adminId;}

    public String getAdminUsername() {return adminUsername;}

    public void setAdminUsername(String adminUsername) {this.adminUsername = adminUsername;}

    public String getAdminPassword() {return adminPassword;}

    public void setAdminPassword(String adminPassword) {this.adminPassword = adminPassword;}

    public String getAdminName() {return AdminName;}

    public void setAdminName(String adminName) {AdminName = adminName;}

    public Integer getAdminPhone() {return adminPhone;}

    public void setAdminPhone(Integer adminPhone) {this.adminPhone = adminPhone; }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", AdminName='" + AdminName + '\'' +
                ", adminPhone=" + adminPhone +
                '}';
    }
}
