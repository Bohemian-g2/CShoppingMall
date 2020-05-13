package com.wsfzsc.pojo;

import java.util.Date;

public class Indent {
    private Integer indentId;

    private Integer indentUserId;

    private Integer indentRecId;

    private Integer indentStatus;

    private Integer indentDeleteStatus;

    private Float indentTotal;

    private Float indentCarriage;

    private Date indentCreateTime;

    private Integer indentWay;

    private Date indentPaidTime;

    private Date indentEndTime;

    private Date indentDrawbackTime;

    private Date indentDrawbackMoneyTime;

    /**
     * 添加外键
     * @return
     */

    private Address address;

    private UserInf userInf;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserInf getUserInf() {
        return userInf;
    }

    public void setUserInf(UserInf userInf) {
        this.userInf = userInf;
    }

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public Integer getIndentUserId() {
        return indentUserId;
    }

    public void setIndentUserId(Integer indentUserId) {
        this.indentUserId = indentUserId;
    }

    public Integer getIndentRecId() {
        return indentRecId;
    }

    public void setIndentRecId(Integer indentRecId) {
        this.indentRecId = indentRecId;
    }

    public Integer getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(Integer indentStatus) {
        this.indentStatus = indentStatus;
    }

    public Integer getIndentDeleteStatus() {
        return indentDeleteStatus;
    }

    public void setIndentDeleteStatus(Integer indentDeleteStatus) {
        this.indentDeleteStatus = indentDeleteStatus;
    }

    public Float getIndentTotal() {
        return indentTotal;
    }

    public void setIndentTotal(Float indentTotal) {
        this.indentTotal = indentTotal;
    }

    public Float getIndentCarriage() {
        return indentCarriage;
    }

    public void setIndentCarriage(Float indentCarriage) {
        this.indentCarriage = indentCarriage;
    }

    public Date getIndentCreateTime() {
        return indentCreateTime;
    }

    public void setIndentCreateTime(Date indentCreateTime) {
        this.indentCreateTime = indentCreateTime;
    }

    public Integer getIndentWay() {
        return indentWay;
    }

    public void setIndentWay(Integer indentWay) {
        this.indentWay = indentWay;
    }

    public Date getIndentPaidTime() {
        return indentPaidTime;
    }

    public void setIndentPaidTime(Date indentPaidTime) {
        this.indentPaidTime = indentPaidTime;
    }

    public Date getIndentEndTime() {
        return indentEndTime;
    }

    public void setIndentEndTime(Date indentEndTime) {
        this.indentEndTime = indentEndTime;
    }

    public Date getIndentDrawbackTime() {
        return indentDrawbackTime;
    }

    public void setIndentDrawbackTime(Date indentDrawbackTime) {
        this.indentDrawbackTime = indentDrawbackTime;
    }

    public Date getIndentDrawbackMoneyTime() {
        return indentDrawbackMoneyTime;
    }

    public void setIndentDrawbackMoneyTime(Date indentDrawbackMoneyTime) {
        this.indentDrawbackMoneyTime = indentDrawbackMoneyTime;
    }

    public Indent() {
    }

    public Indent(Integer indentId, Integer indentUserId, Integer indentRecId, Integer indentStatus, Integer indentDeleteStatus, Float indentTotal, Float indentCarriage, Date indentCreateTime, Integer indentWay, Date indentPaidTime, Date indentEndTime, Date indentDrawbackTime, Date indentDrawbackMoneyTime) {
        this.indentId = indentId;
        this.indentUserId = indentUserId;
        this.indentRecId = indentRecId;
        this.indentStatus = indentStatus;
        this.indentDeleteStatus = indentDeleteStatus;
        this.indentTotal = indentTotal;
        this.indentCarriage = indentCarriage;
        this.indentCreateTime = indentCreateTime;
        this.indentWay = indentWay;
        this.indentPaidTime = indentPaidTime;
        this.indentEndTime = indentEndTime;
        this.indentDrawbackTime = indentDrawbackTime;
        this.indentDrawbackMoneyTime = indentDrawbackMoneyTime;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "indentId=" + indentId +
                ", indentUserId=" + indentUserId +
                ", indentRecId=" + indentRecId +
                ", indentStatus=" + indentStatus +
                ", indentDeleteStatus=" + indentDeleteStatus +
                ", indentTotal=" + indentTotal +
                ", indentCarriage=" + indentCarriage +
                ", indentCreateTime=" + indentCreateTime +
                ", indentWay=" + indentWay +
                ", indentPaidTime=" + indentPaidTime +
                ", indentEndTime=" + indentEndTime +
                ", indentDrawbackTime=" + indentDrawbackTime +
                ", indentDrawbackMoneyTime=" + indentDrawbackMoneyTime +
                ", address=" + address +
                ", userInf=" + userInf +
                '}';
    }
}