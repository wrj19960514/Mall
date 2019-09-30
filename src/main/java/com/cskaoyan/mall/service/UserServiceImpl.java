package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.UserMapper;
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
        if (username != null && "".equals(username.trim())) {
            userExample.createCriteria().andUsernameLike("%" + username + "%");
        }
        // 根据 mobile 模糊查询
        if (mobile != null && "".equals(mobile.trim())) {
            userExample.createCriteria().andMobileLike("%" + mobile + "%");
        }
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getSize();
        ListBean listBean = new ListBean();
        listBean.setItems(users);
        listBean.setTotal(total);
        return listBean;
    }
}
