package com.wsfzsc.pojo;

public class UserInf {
    private Integer userId;

    private String loginName;

    private String password;

    private String userName;

    private Integer identityType;

    private String identityNumber;

    private String userEmail;

    private Integer userPhone;

    private Integer sex;

    private String userTitle;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle == null ? null : userTitle.trim();
    }

    public UserInf() {
    }

    public UserInf(Integer userId, String loginName, String password, String userName, Integer identityType, String identityNumber, String userEmail, Integer userPhone, Integer sex, String userTitle) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.sex = sex;
        this.userTitle = userTitle;
    }

    @Override
    public String toString() {
        return "UserInf{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", identityType=" + identityType +
                ", identityNumber='" + identityNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone=" + userPhone +
                ", sex=" + sex +
                ", userTitle='" + userTitle + '\'' +
                '}';
    }
}