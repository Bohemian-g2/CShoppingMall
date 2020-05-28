package com.wsfzsc.pojo;

public class CDetail extends CDetailKey {
    private Integer cartCommodityNumbe;

    private Float cartCommodityMoney;

    /**
     * 添加外键
     * @return
     */

    private Commodity commodity;

    private Cart cart;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

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

    public CDetail(Integer cartId, Integer cartCommodityId, Integer cartCommodityNumbe, Float cartCommodityMoney) {
        super(cartId, cartCommodityId);
        this.cartCommodityNumbe = cartCommodityNumbe;
        this.cartCommodityMoney = cartCommodityMoney;
    }

    @Override
    public String toString() {
        return "CDetail{" +
                "cartCommodityNumbe=" + cartCommodityNumbe +
                ", cartCommodityMoney=" + cartCommodityMoney +
                ", commodity=" + commodity +
                ", cart=" + cart +
                '}';
    }
}