package com.wsfzsc.pojo;

import java.util.Date;

public class Collect {
    private Integer collectId;

    private Integer collectCommodityId;

    private Integer collectUserId;

    private Date collectTime;

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
}