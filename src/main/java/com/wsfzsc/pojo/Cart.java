package com.wsfzsc.pojo;

public class Cart {
    private Integer cartId;

    private Integer cartUserId;

    private Integer cartCapacity;

    //外键 user
    private UserInf userInf;

    public UserInf getUserInf() {
        return userInf;
    }

    public void setUserInf(UserInf userInf) {
        this.userInf = userInf;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartUserId() {
        return cartUserId;
    }

    public void setCartUserId(Integer cartUserId) {
        this.cartUserId = cartUserId;
    }

    public Integer getCartCapacity() {
        return cartCapacity;
    }

    public void setCartCapacity(Integer cartCapacity) {
        this.cartCapacity = cartCapacity;
    }

    public Cart() {
    }

    public Cart(Integer cartId, Integer cartUserId, Integer cartCapacity) {
        this.cartId = cartId;
        this.cartUserId = cartUserId;
        this.cartCapacity = cartCapacity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartUserId=" + cartUserId +
                ", cartCapacity=" + cartCapacity +
                '}';
    }
}