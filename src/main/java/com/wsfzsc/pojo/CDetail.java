package com.wsfzsc.pojo;

public class CDetail extends CDetailKey {
    private Integer cartCommodityNumbe;

    private Float cartCommodityMoney;

    public Integer getCartCommodityNumbe() {
        return cartCommodityNumbe;
    }

    public void setCartCommodityNumbe(Integer cartCommodityNumbe) {
        this.cartCommodityNumbe = cartCommodityNumbe;
    }

    public Float getCartCommodityMoney() {
        return cartCommodityMoney;
    }

    public void setCartCommodityMoney(Float cartCommodityMoney) {
        this.cartCommodityMoney = cartCommodityMoney;
    }

    public CDetail() {
    }

    public CDetail(Integer cartCommodityNumbe, Float cartCommodityMoney) {
        this.cartCommodityNumbe = cartCommodityNumbe;
        this.cartCommodityMoney = cartCommodityMoney;
    }


    @Override
    public String toString() {
        return "CDetail{" +
                "cartCommodityNumbe=" + cartCommodityNumbe +
                ", cartCommodityMoney=" + cartCommodityMoney +
                '}';
    }
}