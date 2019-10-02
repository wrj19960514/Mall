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
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    public BaseRespVo getUserList(int page, int limit, String sort, String order, String username, String mobile) {
        ListBean userList = userService.getUserList(page, limit, sort, order, username, mobile);
        BaseRespVo ok = BaseRespVo.ok(userList);
        return ok;
    }

    @RequestMapping("/address/list")
    public BaseRespVo getAddressList(int page, int limit, String sort, String order, String user_id, String name) {
        ListBean addressList = userService.getAddressList(page, limit, sort, order, user_id, name);
        BaseRespVo ok = BaseRespVo.ok(addressList);
        return ok;
    }
    @RequestMapping("/collect/list")
    public BaseRespVo getCollectList(int page, int limit, String sort, String order, String user_id, String value_id) {
        ListBean collectList = userService.getCollectList(page, limit, sort, order, user_id, value_id);
        BaseRespVo ok = BaseRespVo.ok(collectList);
        return ok;
    }
    @RequestMapping("/footprint/list")
    public BaseRespVo getFootprintList(int page, int limit, String sort, String order, String user_id, String goods_id) {
        ListBean footprintList = userService.getFootprintList(page, limit, sort, order, user_id, goods_id);
        BaseRespVo ok = BaseRespVo.ok(footprintList);
        return ok;
    }
    @RequestMapping("/history/list")
    public BaseRespVo getHistoryList(int page, int limit, String sort, String order, String user_id, String keyword) {
        ListBean footprintList = userService.getHistoryList(page, limit, sort, order, user_id, keyword);
        BaseRespVo ok = BaseRespVo.ok(footprintList);
        return ok;
    }
    @RequestMapping("/feedback/list")
    public BaseRespVo getFeedbackList(int page, int limit, String sort, String order, String username, String id) {
        ListBean feedbackList = userService.getFeedbackList(page, limit, sort, order, username, id);
        BaseRespVo ok = BaseRespVo.ok(feedbackList);
        return ok;
    }
}
