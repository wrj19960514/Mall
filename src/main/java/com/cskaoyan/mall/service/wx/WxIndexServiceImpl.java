package com.cskaoyan.mall.service.wx;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.vo.wx.WxOrderstateVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxIndexServiceImpl implements WxIndexService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    AdMapper adMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    TopicMapper topicMapper;
    //用户页
    @Override
    public Map<String,Object> getuserIndex() {
        Map<String,Object> map = new HashMap<>(20);
        WxOrderstateVo wxOrderstateVo = new WxOrderstateVo();
        //userId
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        int userId = userMapper.queryUserIdByUsername(principal);
        //待付款
        OrderExample orderExample1 = new OrderExample();
        orderExample1.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)1);
        int unpaid = (int)orderMapper.countByExample(orderExample1);
        wxOrderstateVo.setUnpaid(unpaid);
        //待发货
        OrderExample orderExample2 = new OrderExample();
        orderExample2.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)2);
        int unship = (int)orderMapper.countByExample(orderExample2);
        wxOrderstateVo.setUnship(unship);
        //待收货
        OrderExample orderExample3 = new OrderExample();
        orderExample3.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)3);
        int unrecv = (int)orderMapper.countByExample(orderExample3);
        wxOrderstateVo.setUnrecv(unrecv);
        //待评论
        OrderExample orderExample4 = new OrderExample();
        orderExample4.createCriteria().andUserIdEqualTo(userId).andOrderStatusEqualTo((short)4);
        int uncomment = (int)orderMapper.countByExample(orderExample4);
        wxOrderstateVo.setUncomment(uncomment);
        map.put("order",wxOrderstateVo);
        return map;
    }
    //首页
    @Override
    public Map<String, Object> gethomeIndex() {
        Map<String,Object> map = new HashMap<>(100);
        //ad表,brand表,category表,coupon表,goods和groupon,goods表,goods表,topic表
        AdExample adExample  = new AdExample();
        List<Ad> ad = adMapper.selectByExample(adExample);
        map.put("banner",ad);

        BrandExample brandExample = new BrandExample();
        brandExample.setOrderByClause("update_time desc");
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        map.put("brandList",brands);

        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andLevelEqualTo("L1");
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        map.put("channel",categories);

        CouponExample couponExample = new CouponExample();
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        map.put("couponList",coupons);


        List<Object> floorGoodsList = new ArrayList<>();
        for (Category category : categories) {
            Map<String,Object> categorymap = new HashMap<>(20);
            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andCategoryIdEqualTo(category.getId());
            List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
            if(goodsList.size() != 0) {
                categorymap.put("goodsList",goodsList);
                categorymap.put("id",category.getId());
                categorymap.put("name",category.getName());
            }
            if(categorymap.size() != 0) {
                floorGoodsList.add(categorymap);
            }
        }
        map.put("floorGoodsList",floorGoodsList);

        List<Map<String,Object>> list = new ArrayList<>();
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        List<GrouponRules> grouponRulesList = grouponRulesMapper.selectByExample(grouponRulesExample);
        for (GrouponRules grouponRules : grouponRulesList) {
            Map<String,Object> grouponmap = new HashMap<>();
            GoodsExample grouponGoodsExample = new GoodsExample();
            grouponGoodsExample.createCriteria().andGoodsSnEqualTo(grouponRules.getGoodsId());
            List<Goods> goods = goodsMapper.selectByExample(grouponGoodsExample);
            Goods good = goods.get(0);
            int member = grouponRules.getDiscountMember();
            int discount = grouponRules.getDiscount().intValue();
            int grouponPrice = good.getRetailPrice().intValue() - discount;
            grouponmap.put("goods",good);
            grouponmap.put("groupon_member",member);
            grouponmap.put("groupon_price",grouponPrice);
            list.add(grouponmap);
        }
        map.put("grouponList",list);

        GoodsExample hotGoodsExample = new GoodsExample();
        hotGoodsExample.createCriteria().andIsHotEqualTo(true);
        List<Goods> hotgoods = goodsMapper.selectByExample(hotGoodsExample);
        map.put("hotGoodsList",hotgoods);

        GoodsExample newGoodsExample = new GoodsExample();
        newGoodsExample.createCriteria().andIsNewEqualTo(true);
        List<Goods> newgoods = goodsMapper.selectByExample(newGoodsExample);
        map.put("newGoodsList",newgoods);

        TopicExample topicExample = new TopicExample();
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        map.put("topicList",topics);
        return map;
    }
    //分类页面
    @Override
    public Map<String, Object> getcatalogIndex() {
        //Category表
        Map<String,Object> map = new HashMap<>();
        CategoryExample categoryExampleL1 = new CategoryExample();
        categoryExampleL1.setOrderByClause("update_time desc");
        categoryExampleL1.createCriteria().andLevelEqualTo("L1").andDeletedEqualTo(false);
        List<Category> categoryList = categoryMapper.selectByExample(categoryExampleL1);

        map.put("categoryList",categoryList);
        map.put("currentCategory",categoryList.get(0));

        CategoryExample categoryExampleL2 = new CategoryExample();
        categoryExampleL1.createCriteria().andLevelEqualTo("L2").andDeletedEqualTo(false);
        List<Category> currentSubCategory = categoryMapper.selectByExample(categoryExampleL2);
        map.put("currentSubCategory",currentSubCategory);
        return map;
    }

    @Override
    public Map<String, Object> getcatalogCurrent(int id) {
        Map<String,Object> map = new HashMap<>();
        Category father = categoryMapper.selectByPrimaryKey(id);
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPidEqualTo(id).andLevelEqualTo("L2");
        List<Category> child = categoryMapper.selectByExample(categoryExample);
        map.put("currentCategory",father);
        map.put("currentSubCategory",child);
        return map;
    }
}
