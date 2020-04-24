package com.wsfzsc.pojo;

public class Admin {
    private Integer adminId;

    private String adminUsername;

    private String adminPassword;

    private String adminName;

    private String adminPhone;

    private String adminRegisterDate;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername == null ? null : adminUsername.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminRegisterDate() {
        return adminRegisterDate;
    }

    public void setAdminRegisterDate(String adminRegisterDate) {
        this.adminRegisterDate = adminRegisterDate == null ? null : adminRegisterDate.trim();
    }

    public Admin() {
    }

    public Admin(Integer adminId, String adminUsername, String adminPassword, String adminName, String adminPhone, String adminRegisterDate) {
        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.adminPhone = adminPhone;
        this.adminRegisterDate = adminRegisterDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminRegisterDate='" + adminRegisterDate + '\'' +
                '}';
    }
}