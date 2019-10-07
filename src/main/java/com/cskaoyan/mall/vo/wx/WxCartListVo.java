package com.cskaoyan.mall.vo.wx;

import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.bean.CartTotal;

import java.util.List;

public class WxCartListVo {
    private List<Cart> cartList;
    private CartTotal cartTotal;

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }
}
