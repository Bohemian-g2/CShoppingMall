package com.wsfzsc.pojo;

public class IndentDetailKey {
    private Integer indentId;

    private Integer indentGoodsId;

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public Integer getIndentGoodsId() {
        return indentGoodsId;
    }

    public void setIndentGoodsId(Integer indentGoodsId) {
        this.indentGoodsId = indentGoodsId;
    }

    public IndentDetailKey() {
    }

    public IndentDetailKey(Integer indentId, Integer indentGoodsId) {
        this.indentId = indentId;
        this.indentGoodsId = indentGoodsId;
    }
}