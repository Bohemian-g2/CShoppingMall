package com.wsfzsc.pojo;

import java.util.Date;

public class Collect {
    private Integer collectId;

    private Integer collectCommodityId;

    private Integer collectUserId;

    private Date collectTime;

    /**
     * 外键 商品和用户
     * @return
     */

    private Commodity commodity;

    private UserInf userInf;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public UserInf getUserInf() {
        return userInf;
    }

    public void setUserInf(UserInf userInf) {
        this.userInf = userInf;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectCommodityId() {
        return collectCommodityId;
    }

    public void setCollectCommodityId(Integer collectCommodityId) {
        this.collectCommodityId = collectCommodityId;
    }

    public Integer getCollectUserId() {
        return collectUserId;
    }

    public void setCollectUserId(Integer collectUserId) {
        this.collectUserId = collectUserId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public Collect() {
    }

    public Collect(Integer collectId, Integer collectCommodityId, Integer collectUserId, Date collectTime) {
        this.collectId = collectId;
        this.collectCommodityId = collectCommodityId;
        this.collectUserId = collectUserId;
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectId=" + collectId +
                ", collectCommodityId=" + collectCommodityId +
                ", collectUserId=" + collectUserId +
                ", collectTime=" + collectTime +
                '}';
    }
}