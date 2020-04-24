package com.wsfzsc.pojo;

public class KindBase {
    private Integer kindId;

    private String kindName;

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public KindBase() {
    }

    public KindBase(Integer kindId, String kindName) {
        this.kindId = kindId;
        this.kindName = kindName;
    }

    @Override
    public String toString() {
        return "KindBase{" +
                "kindId=" + kindId +
                ", kindName='" + kindName + '\'' +
                '}';
    }
}