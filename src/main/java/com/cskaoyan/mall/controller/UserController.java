package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.ListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author levi-j
 * @CreateDate 2019-09-30 20:46
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/admin/user/list")
    public BaseRespVo getUserList(int page, int limit, String sort, String order, String username, String mobile) {
        ListBean userList = userService.getUserList(page, limit, sort, order, username, mobile);
        BaseRespVo ok = BaseRespVo.ok(userList);
        return ok;
    }

}
