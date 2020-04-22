package com.wsfzsc.pojo;

import java.util.Date;

public class Commodity {
    private Integer commodityId;

    private Integer commodityKind;

    private String commodityName;

    private Integer commodityStatus;

    private Float commodityMoney;

    private Integer commodityStock;

    private String commoditySize;

    private Integer commoditySex;

    private String commodityPicture;

    private String commodityDescript;

    private String commodityColor;

    private String commodityStyle;

    private String commoditySource;

    private Date commodityDate;

    //商品类别信息
    private KindBase kindBase;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityKind() {
        return commodityKind;
    }

    public void setCommodityKind(Integer commodityKind) {
        this.commodityKind = commodityKind;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public Integer getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Integer commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public Float getCommodityMoney() {
        return commodityMoney;
    }

    public void setCommodityMoney(Float commodityMoney) {
        this.commodityMoney = commodityMoney;
    }

    public Integer getCommodityStock() {
        return commodityStock;
    }

    public void setCommodityStock(Integer commodityStock) {
        this.commodityStock = commodityStock;
    }

    public String getCommoditySize() {
        return commoditySize;
    }

    public void setCommoditySize(String commoditySize) {
        this.commoditySize = commoditySize == null ? null : commoditySize.trim();
    }

    public Integer getCommoditySex() {
        return commoditySex;
    }

    public void setCommoditySex(Integer commoditySex) {
        this.commoditySex = commoditySex;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture == null ? null : commodityPicture.trim();
    }

    public String getCommodityDescript() {
        return commodityDescript;
    }

    public void setCommodityDescript(String commodityDescript) {
        this.commodityDescript = commodityDescript == null ? null : commodityDescript.trim();
    }

    public String getCommodityColor() {
        return commodityColor;
    }

    public void setCommodityColor(String commodityColor) {
        this.commodityColor = commodityColor == null ? null : commodityColor.trim();
    }

    public String getCommodityStyle() {
        return commodityStyle;
    }

    public void setCommodityStyle(String commodityStyle) {
        this.commodityStyle = commodityStyle == null ? null : commodityStyle.trim();
    }

    public String getCommoditySource() {
        return commoditySource;
    }

    public void setCommoditySource(String commoditySource) {
        this.commoditySource = commoditySource == null ? null : commoditySource.trim();
    }

    public Date getCommodityDate() {
        return commodityDate;
    }

    public void setCommodityDate(Date commodityDate) {
        this.commodityDate = commodityDate;
    }

    public KindBase getKindBase() {
        return kindBase;
    }

    public void setKindBase(KindBase kindBase) {
        this.kindBase = kindBase;
    }

    public Commodity() {
    }

    public Commodity(Integer commodityId, Integer commodityKind, String commodityName, Integer commodityStatus, Float commodityMoney, Integer commodityStock, String commoditySize, Integer commoditySex, String commodityPicture, String commodityDescript, String commodityColor, String commodityStyle, String commoditySource, Date commodityDate) {
        this.commodityId = commodityId;
        this.commodityKind = commodityKind;
        this.commodityName = commodityName;
        this.commodityStatus = commodityStatus;
        this.commodityMoney = commodityMoney;
        this.commodityStock = commodityStock;
        this.commoditySize = commoditySize;
        this.commoditySex = commoditySex;
        this.commodityPicture = commodityPicture;
        this.commodityDescript = commodityDescript;
        this.commodityColor = commodityColor;
        this.commodityStyle = commodityStyle;
        this.commoditySource = commoditySource;
        this.commodityDate = commodityDate;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityId=" + commodityId +
                ", commodityKind=" + commodityKind +
                ", commodityName='" + commodityName + '\'' +
                ", commodityStatus=" + commodityStatus +
                ", commodityMoney=" + commodityMoney +
                ", commodityStock=" + commodityStock +
                ", commoditySize='" + commoditySize + '\'' +
                ", commoditySex=" + commoditySex +
                ", commodityPicture='" + commodityPicture + '\'' +
                ", commodityDescript='" + commodityDescript + '\'' +
                ", commodityColor='" + commodityColor + '\'' +
                ", commodityStyle='" + commodityStyle + '\'' +
                ", commoditySource='" + commoditySource + '\'' +
                ", commodityDate=" + commodityDate +
                '}';
    }
}