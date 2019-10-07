package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.GoodsProductMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.vo.wx.WxCartAddVo;
import com.cskaoyan.mall.vo.wx.WxCartCheckedVo;
import com.cskaoyan.mall.vo.wx.WxCartDeleteVo;
import com.cskaoyan.mall.vo.wx.WxCartListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxCartServiceImpl implements WxCartService{

    @Autowired
    CartMapper cartMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Override
    public boolean updateCart(int goodsId, int productId, int number, int id) {
        int update = cartMapper.updateById(goodsId, productId, number, id);
        if (update == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteCart(WxCartDeleteVo wxCartDeleteVo) {
        int userId = 1;
        List<Integer> productIds = wxCartDeleteVo.getProductIds();
        for (int productId : productIds) {
            cartMapper.deleteByUserIdandProductId(userId, productId);
        }
    }

    @Override
    public WxCartListVo getIndex() { // 先获取当前用户id
//        Subject subject = SecurityUtils.getSubject();
//        String principal = (String) subject.getPrincipal();
//        int userId = userMapper.queryUserIdByUsername(principal);
        int userId = 1;
        // 根据userId查找该用户的购物车
        List<Cart> carts = cartMapper.selectByUserId(userId);
        WxCartListVo wxCartListVo = new WxCartListVo();
        wxCartListVo.setCartList(carts);
        BigDecimal checkedGoodsAmount = BigDecimal.ZERO;
        BigDecimal checkedGoodsCount = BigDecimal.ZERO;
        BigDecimal goodsAmount = BigDecimal.ZERO;
        BigDecimal goodsCount = BigDecimal.ZERO;
        Map<String, BigDecimal> cartTotal = new HashMap<>();
        for (Cart cart : carts) {
            goodsCount = BigDecimal.valueOf(cart.getNumber());
            goodsAmount = goodsCount.multiply(cart.getPrice());
            if (cart.getChecked() == true) {
                checkedGoodsCount = BigDecimal.valueOf(cart.getNumber());
                checkedGoodsAmount = checkedGoodsCount.multiply(cart.getPrice());
            }
        }
        wxCartListVo.setCartTotal(new CartTotal(checkedGoodsAmount, checkedGoodsCount, goodsAmount, goodsCount));
        return wxCartListVo;
    }

    @Override
    public boolean addCart(WxCartAddVo wxCartAddVo) {
        int userId = 1;
        // 首先查询库存
        GoodsProduct goodsProduct = goodsProductMapper.selectByPrimaryKey(wxCartAddVo.getProductId());
        if (goodsProduct.getNumber() < wxCartAddVo.getNumber()) {
            return false;
        }
        // 判断购物车中是否有该商品 无则添加 有则相加
        Cart cart = cartMapper.selectByPrimaryKey(wxCartAddVo.getProductId());
        if (cart == null) {
            Date date = new Date();
            Goods goods = goodsMapper.selectByPrimaryKey(wxCartAddVo.getGoodsId());
            Cart cart1 = new Cart(userId, wxCartAddVo.getGoodsId(), goods.getGoodsSn(), goods.getName(),
                    wxCartAddVo.getProductId(), goodsProduct.getPrice(), (short)wxCartAddVo.getNumber(), goodsProduct.getSpecifications(),
                    true, goods.getPicUrl(), date, date, false);
            cartMapper.insert(cart1);
        } else {
            cart.setNumber((short) (cart.getNumber() + wxCartAddVo.getNumber()));
            cartMapper.updateByPrimaryKey(cart);
        }
        return true;
    }

    @Override
    public boolean fastAddCart(WxCartAddVo wxCartAddVo) {
        int userId = 1;
        // 首先查询库存
        GoodsProduct goodsProduct = goodsProductMapper.selectByPrimaryKey(wxCartAddVo.getProductId());
        if (goodsProduct.getNumber() < wxCartAddVo.getNumber()) {
            return false;
        }
        // 和add的区别是直接添加到购物车 无需判断是否有重复的购物车
        Date date = new Date();
        Goods goods = goodsMapper.selectByPrimaryKey(wxCartAddVo.getGoodsId());
        Cart cart1 = new Cart(userId, wxCartAddVo.getGoodsId(), goods.getGoodsSn(), goods.getName(),
                wxCartAddVo.getProductId(), goodsProduct.getPrice(), (short)wxCartAddVo.getNumber(), goodsProduct.getSpecifications(),
                    true, goods.getPicUrl(), date, date, false);
        cartMapper.insert(cart1);
        return true;
    }

    @Override
    public void checkOut(int cartId, int addressId, int couponId, int grouponRulesId) {

    }

    @Override
    public BigDecimal goodsCount() {
        int userId = 1;
        CartExample cartExample = new CartExample();
        CartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        BigDecimal goodsCount = BigDecimal.ZERO;
        for (Cart cart : carts) {
            goodsCount.add(BigDecimal.valueOf(cart.getNumber()));
        }
        return goodsCount;
    }

    @Override
    public boolean checked(WxCartCheckedVo wxCartCheckedVo) {
        int userId = 1;
        List<Integer> productIds = wxCartCheckedVo.getProductIds();
        Date date = new Date();
        for (Integer productId : productIds) {
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setChecked(wxCartCheckedVo.getIsChecked());
            cart.setProductId(productId);
            cart.setUpdateTime(date);
            cartMapper.updateByProductIdUserIdSelective(cart);
        }
        return true;
    }
}
