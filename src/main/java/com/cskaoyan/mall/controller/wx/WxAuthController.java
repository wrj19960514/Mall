package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.LoginVo;
import com.cskaoyan.mall.vo.vx.LoginRespVo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WxAuthController {

    /*登陆*/
    @PostMapping("wx/auth/login")
    public BaseRespVo login(@RequestBody LoginVo vo){
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setToken("tt1i9fq6q2nqmexibr7lr3h3q3x7gyu4");
        loginRespVo.setTokenExpire("2019-10-06T02:14:48.718");
        Map<String,String> map = new HashMap<>(10);
        map.put("avatarUrl","");
        map.put("nickName","wx");
        loginRespVo.setUserInfo(map);
        BaseRespVo ok = BaseRespVo.ok(loginRespVo);
        return ok;
    }

    @GetMapping("wx/user/index")
    public BaseRespVo index(String token){
        return BaseRespVo.ok(null);
    }

    @RequestMapping("wx/user/logout")
    public BaseRespVo logout() {

        return BaseRespVo.ok(null);
    }

}
