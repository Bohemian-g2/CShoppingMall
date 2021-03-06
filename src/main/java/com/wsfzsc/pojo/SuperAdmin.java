package com.wsfzsc.pojo;

public class SuperAdmin {
    private Integer superadminId;

    private String superadminUsername;

    private String superadminPassword;

    private String superadminName;

    public Integer getSuperadminId() {
        return superadminId;
    }

    public void setSuperadminId(Integer superadminId) {
        this.superadminId = superadminId;
    }

    public String getSuperadminUsername() {
        return superadminUsername;
    }

    public void setSuperadminUsername(String superadminUsername) {
        this.superadminUsername = superadminUsername == null ? null : superadminUsername.trim();
    }

    public String getSuperadminPassword() {
        return superadminPassword;
    }

    public void setSuperadminPassword(String superadminPassword) {
        this.superadminPassword = superadminPassword == null ? null : superadminPassword.trim();
    }

    public String getSuperadminName() {
        return superadminName;
    }

    public void setSuperadminName(String superadminName) {
        this.superadminName = superadminName == null ? null : superadminName.trim();
    }

    public SuperAdmin() {
    }

    public SuperAdmin(Integer superadminId, String superadminUsername, String superadminPassword, String superadminName) {
        this.superadminId = superadminId;
        this.superadminUsername = superadminUsername;
        this.superadminPassword = superadminPassword;
        this.superadminName = superadminName;
    }

    @Override
    public String toString() {
        return "SuperAdmin{" +
                "superadminId=" + superadminId +
                ", superadminUsername='" + superadminUsername + '\'' +
                ", superadminPassword='" + superadminPassword + '\'' +
                ", superadminName='" + superadminName + '\'' +
                '}';
    }
}