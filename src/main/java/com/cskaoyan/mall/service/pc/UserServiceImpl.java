package com.cskaoyan.mall.service.pc;

import com.alibaba.druid.util.StringUtils;
import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.util.SearchUtils;
import com.cskaoyan.mall.vo.ListBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author levi-j
 * @CreateDate 2019-09-30 21:05
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    FootprintMapper footprintMapper;
    @Autowired
    SearchHistoryMapper searchHistoryMapper;
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    /**获取用户列表
     * @param page 当前页码
	 * @param limit 每页条目数
	 * @param sort 排序字段
	 * @param order 升序/降序
	 * @param username 搜索用户名
	 * @param mobile 搜索手机号
     * @return 用户列表
     */
    public ListBean getUserList(int page, int limit, String sort, String order, String username, String mobile) {
        // 分页
        PageHelper.startPage(page, limit);
        UserExample userExample = new UserExample();
        // 排序
        userExample.setOrderByClause(sort + " " + order);
        // 根据 username 模糊查询
        UserExample.Criteria criteria = userExample.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        // 根据 mobile 模糊查询
        if (!StringUtils.isEmpty(mobile)) {
            userExample.createCriteria().andMobileLike("%" + mobile + "%");
        }
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(users);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    /**
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @param user_id 搜索 user_id
     * @param name 搜索 name
     * @return 收货地址列表
     */
    public ListBean getAddressList(int page, int limit, String sort, String order, String userId, String name) {
        // 分页
        PageHelper.startPage(page, limit);
        AddressExample addressExample = new AddressExample();
        // 排序
        addressExample.setOrderByClause(sort + " " + order);
        // id查询
        AddressExample.Criteria criteria = addressExample.createCriteria();
//        if (!StringUtils.isEmpty(userId) && IntegerUtils.isInteger(userId)) {
//            criteria.andUserIdEqualTo(Integer.valueOf(userId));
//        } else if (!StringUtils.isEmpty(userId) && !IntegerUtils.isInteger(userId)){
//            criteria.andUserIdEqualTo(-1);
//        }
        /*
        * 判断是否为空
        * 非空进一步判断是否为数字
        */
        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(userId));
        }
        // 模糊查询
        if(!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        // 封装
        List<Address> addressList = addressMapper.selectByExample(addressExample);
        PageInfo<Address> addressPageInfo = new PageInfo<>(addressList);
        long total = addressPageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(addressList);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean getCollectList(int page, int limit, String sort, String order, String userId, String valueId) {
        // 分页
        PageHelper.startPage(page, limit);
        // 排序
        CollectExample collectExample = new CollectExample();
        collectExample.setOrderByClause(sort + " " + order);
        // 查询
        CollectExample.Criteria criteria = collectExample.createCriteria();
//        if (!StringUtils.isEmpty(userId) && IntegerUtils.isInteger(userId)) {
//            // 非空数字
//            criteria.andUserIdEqualTo(Integer.valueOf(userId));
//        } else if (!StringUtils.isEmpty(userId) && !IntegerUtils.isInteger(userId)){
//            // 非空非数字
//            criteria.andUserIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(userId));
        }
//        if (!StringUtils.isEmpty(valueId) && IntegerUtils.isInteger(valueId)) {
//            // 非空数字
//            criteria.andValueIdEqualTo(Integer.valueOf(valueId));
//        } else if (!StringUtils.isEmpty(valueId) && !IntegerUtils.isInteger(valueId)){
//            // 非空非数字
//            criteria.andValueIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(valueId));
        }
        // 封装
        List<Collect> collectList = collectMapper.selectByExample(collectExample);
        PageInfo<Collect> pageInfo = new PageInfo<>(collectList);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(collectList);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean getFootprintList(int page, int limit, String sort, String order, String userId, String goodsId) {
        // 分页
        PageHelper.startPage(page, limit);
        // 排序
        FootprintExample footprintExample = new FootprintExample();
        footprintExample.setOrderByClause(sort + " " + order);
        // 查询
        FootprintExample.Criteria criteria = footprintExample.createCriteria();
//        if (!StringUtils.isEmpty(userId) && IntegerUtils.isInteger(userId)) {
//            criteria.andUserIdEqualTo(Integer.valueOf(userId));
//        } else if (!StringUtils.isEmpty(userId) && !IntegerUtils.isInteger(userId)) {
//            criteria.andUserIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(userId));
        }
//        if (!StringUtils.isEmpty(goodsId) && IntegerUtils.isInteger(goodsId)) {
//            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
//        } else if (!StringUtils.isEmpty(goodsId) && !IntegerUtils.isInteger(goodsId)){
//            criteria.andGoodsIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(goodsId));
        }
        // 封装
        List<Footprint> footprintList = footprintMapper.selectByExample(footprintExample);
        PageInfo<Footprint> pageInfo = new PageInfo<>(footprintList);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(footprintList);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean getHistoryList(int page, int limit, String sort, String order, String userId, String keyword) {
        // 分页
        PageHelper.startPage(page, limit);
        // 排序
        SearchHistoryExample searchHistoryExample = new SearchHistoryExample();
        searchHistoryExample.setOrderByClause(sort + " " + order);
        // 查询
        SearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
//        if (!StringUtils.isEmpty(userId) && IntegerUtils.isInteger(userId)) {
//            criteria.andUserIdEqualTo(Integer.valueOf(userId));
//        } else if (!StringUtils.isEmpty(userId) && !IntegerUtils.isInteger(userId)){
//            criteria.andUserIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(SearchUtils.search(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        // 封装
        List<SearchHistory> searchHistoryList = searchHistoryMapper.selectByExample(searchHistoryExample);
        PageInfo<SearchHistory> pageInfo = new PageInfo<>(searchHistoryList);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(searchHistoryList);
        listBean.setTotal(total);
        return listBean;
    }

    @Override
    public ListBean getFeedbackList(int page, int limit, String sort, String order, String username, String id) {
        // 分页
        PageHelper.startPage(page, limit);
        // 排序
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.setOrderByClause(sort + " " + order);
        // 查询
        FeedbackExample.Criteria criteria = feedbackExample.createCriteria();
//        if (!StringUtils.isEmpty(id) && IntegerUtils.isInteger(id)) {
//            criteria.andIdEqualTo(Integer.valueOf(id));
//        } else if (!StringUtils.isEmpty(id) && !IntegerUtils.isInteger(id)){
//            criteria.andIdEqualTo(-1);
//        }
        if (!StringUtils.isEmpty(id)) {
            criteria.andUserIdEqualTo(SearchUtils.search(id));
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }

        // 封装
        List<Feedback> feedbackList = feedbackMapper.selectByExample(feedbackExample);
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedbackList);
        long total = pageInfo.getTotal();
        ListBean listBean = new ListBean();
        listBean.setItems(feedbackList);
        listBean.setTotal(total);
        return listBean;
    }
}
