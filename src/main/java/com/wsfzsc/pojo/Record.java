package com.wsfzsc.pojo;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Integer recordCommodityId;

    private Integer recordUserId;

    private Integer recordFrequency;

    private Date recordTime;

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
}