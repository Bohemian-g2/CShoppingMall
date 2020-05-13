package com.wsfzsc.pojo;

public class IndentDetail extends IndentDetailKey {
    private Integer indentGoodsNum;

    /**
     * 添加外键
     * @return
     */

    private Commodity commodity;

    private Indent indent;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Indent getIndent() {
        return indent;
    }

    public void setIndent(Indent indent) {
        this.indent = indent;
    }

    public Integer getIndentGoodsNum() {
        return indentGoodsNum;
    }

    public void setIndentGoodsNum(Integer indentGoodsNum) {
        this.indentGoodsNum = indentGoodsNum;
    }

    public IndentDetail() {
    }

    public IndentDetail(Integer indentId, Integer indentGoodsId, Integer indentGoodsNum) {
        super(indentId, indentGoodsId);
        this.indentGoodsNum = indentGoodsNum;
    }

    @Override
    public String toString() {
        return "IndentDetail{" +
                "indentGoodsNum=" + indentGoodsNum +
                ", commodity=" + commodity +
                ", indent=" + indent +
                '}';
    }
}