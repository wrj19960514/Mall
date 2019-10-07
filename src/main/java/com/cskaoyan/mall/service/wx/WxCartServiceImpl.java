package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxCartServiceImpl implements WxCartService{

    @Autowired
    CartMapper cartMapper;

    @Override
    public boolean updateCart(int goodsId, int productId, int number, int id) {
        int update = cartMapper.updateById(goodsId, productId, number, id);
        if (update == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteCart(int[] productId) {
        for (int i : productId) {
            cartMapper.deleteByPrimaryKey(i);
        }
    }

    @Override
    public Map<String, Object> getIndex() {
        return null;
    }

//    @Override
//    public Map<String, Object> getIndex() {
//        Cart carts = cartMapper.selectAll();
//        Map<String, Object> cartList = new HashMap<>();
//        cartList.put("cartList", carts);
//    }
}
