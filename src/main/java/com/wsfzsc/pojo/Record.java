package com.wsfzsc.pojo;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Integer recordCommodityId;

    private Integer recordUserId;

    private Integer recordFrequency;

    private Date recordTime;

    //带商品信息
    private Commodity commodity;

    //带用户信息
    private UserInf userInf;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRecordCommodityId() {
        return recordCommodityId;
    }

    public void setRecordCommodityId(Integer recordCommodityId) {
        this.recordCommodityId = recordCommodityId;
    }

    public Integer getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }

    public Integer getRecordFrequency() {
        return recordFrequency;
    }

    public void setRecordFrequency(Integer recordFrequency) {
        this.recordFrequency = recordFrequency;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Record() {
    }

    public Record(Integer recordId, Integer recordCommodityId, Integer recordUserId, Integer recordFrequency, Date recordTime) {
        this.recordId = recordId;
        this.recordCommodityId = recordCommodityId;
        this.recordUserId = recordUserId;
        this.recordFrequency = recordFrequency;
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", recordCommodityId=" + recordCommodityId +
                ", recordUserId=" + recordUserId +
                ", recordFrequency=" + recordFrequency +
                ", recordTime=" + recordTime +
                '}';
    }
}