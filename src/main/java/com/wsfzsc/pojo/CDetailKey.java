package com.wsfzsc.pojo;

public class CDetailKey {
    private Integer cartId;

    private Integer cartCommodityId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartCommodityId() {
        return cartCommodityId;
    }

    public void setCartCommodityId(Integer cartCommodityId) {
        this.cartCommodityId = cartCommodityId;
    }

    public CDetailKey() {
    }

    public CDetailKey(Integer cartId, Integer cartCommodityId) {
        this.cartId = cartId;
        this.cartCommodityId = cartCommodityId;
    }

    @Override
    public String toString() {
        return "CDetailKey{" +
                "cartId=" + cartId +
                ", cartCommodityId=" + cartCommodityId +
                '}';
    }
}