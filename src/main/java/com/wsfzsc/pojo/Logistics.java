package com.wsfzsc.pojo;

//模拟物流 地址类
public class Logistics {

    private Integer logisticsId;

    private Integer indentId;

    private String logisticsAddress;

    public Logistics() {
    }

    public Logistics(Integer logisticsId, Integer indentId, String logisticsAddress) {
        this.logisticsId = logisticsId;
        this.indentId = indentId;
        this.logisticsAddress = logisticsAddress;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "logisticsId=" + logisticsId +
                ", indentId=" + indentId +
                ", logisticsAddress='" + logisticsAddress + '\'' +
                '}';
    }
}
