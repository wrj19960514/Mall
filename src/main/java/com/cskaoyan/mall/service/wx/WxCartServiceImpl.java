package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.wx.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    CouponMapper couponMapper;

    @Override
    public boolean updateCart(WxCartUpdateVo wxCartUpdateVo) {
        Cart cart = new Cart();
        cart.setId(wxCartUpdateVo.getId());
        cart.setNumber(wxCartUpdateVo.getNumber());
        cart.setUpdateTime(new Date());
        cart.setGoodsId(wxCartUpdateVo.getGoodsId());
        cart.setProductId(wxCartUpdateVo.getProductId());
        int update = cartMapper.updateByPrimaryKeySelective(cart);
        if (update == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteCart(WxCartDeleteVo wxCartDeleteVo) {
        int userId = 1;
        List<Integer> productIds = wxCartDeleteVo.getProductIds();
        Boolean flag = false;
        for (int productId : productIds) {
            int delete = cartMapper.deleteByUserIdandProductId(userId, productId);
            if (delete == 1) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public WxCartListVo getIndex() { // 先获取当前用户id
//        Subject subject = SecurityUtils.getSubject();
//        String principal = (String) subject.getPrincipal();
//        int userId = userMapper.queryUserIdByUsername(principal);
        int userId = 1;
        // 根据userId查找该用户的购物车
        List<Cart> carts = cartMapper.selectByUserId(userId, false);
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
        Cart cart = cartMapper.queryByProductId(userId, wxCartAddVo.getProductId());
        if (cart == null) {
            Date date = new Date();
            Goods goods = goodsMapper.selectByPrimaryKey(wxCartAddVo.getGoodsId());
            Cart cart1 = new Cart(userId, wxCartAddVo.getGoodsId(), goods.getGoodsSn(), goods.getName(),
                    wxCartAddVo.getProductId(), goodsProduct.getPrice(), (short)wxCartAddVo.getNumber(), goodsProduct.getSpecifications(),
                    true, goods.getPicUrl(), date, date, false);
            cartMapper.insert(cart1);
        } else {
            cart.setNumber((short) (cart.getNumber() + wxCartAddVo.getNumber()));
            cartMapper.updateByPrimaryKeySelective(cart);
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
    public WxCartCheckoutReturnVo checkOut(WxCartCheckOutVo vo) {
        int userId = 1;
        WxCartCheckoutReturnVo returnVo = new WxCartCheckoutReturnVo();
        //商品总价
        BigDecimal goodsTotalPrice = BigDecimal.ZERO;
        if (vo.getCartId() != 0) {
            Cart cart = cartMapper.selectByPrimaryKey(vo.getCartId());
            List<Cart> carts = new ArrayList<>();
            carts.add(cart);
            returnVo.setCheckedGoodsList(carts);
            goodsTotalPrice = cart.getPrice().multiply(new BigDecimal(cart.getNumber()));
        } else {
            List<Cart> carts = cartMapper.selectByUserId(userId, true);
            returnVo.setCheckedGoodsList(carts);
            for (Cart cart : carts) {
                goodsTotalPrice = goodsTotalPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }
        returnVo.setGoodsTotalPrice(goodsTotalPrice);
        //地址
        Address address;
        if (vo.getAddressId() != 0) {
            address = addressMapper.selectByPrimaryKey(vo.getAddressId());
        } else {
            address = addressMapper.selectDefaultAddressByUserId(userId);
        }
        returnVo.setCheckedAddress(address);
        returnVo.setAddressId(address.getId());
        //团购优惠价格
        BigDecimal grouponPrice = BigDecimal.ZERO;
        if (vo.getGrouponRulesId() != 0) {
            GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(vo.getGrouponRulesId());
            returnVo.setGrouponRulesId(grouponRules.getId());
            grouponPrice = grouponRules.getDiscount();
        }
        returnVo.setGrouponPrice(grouponPrice);
        //优惠券的价格
        BigDecimal couponPrice = BigDecimal.ZERO;
        if (vo.getCouponId() != 0 && vo.getCouponId() != -1) {
            Coupon coupon = couponMapper.selectByPrimaryKey(vo.getCouponId());
            returnVo.setCouponId(coupon.getId());
            couponPrice = coupon.getDiscount();
        }
        returnVo.setCouponPrice(couponPrice);
        //订单总价
        BigDecimal orderTotalPrice = BigDecimal.ZERO;
        returnVo.setOrderTotalPrice(orderTotalPrice);
        //快递费
        BigDecimal freightPrice = new BigDecimal(10);
        if (goodsTotalPrice.compareTo(BigDecimal.valueOf(88)) == 1) {
            freightPrice = new BigDecimal(0);
        }
        returnVo.setFreightPrice(freightPrice);
        //实际需要支付的总价
        returnVo.setActualPrice(goodsTotalPrice.add(freightPrice).subtract(couponPrice));
        return returnVo;
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
