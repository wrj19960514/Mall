package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.AuthService;
import com.cskaoyan.mall.shiro.CustomToken;
import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.LoginVo;
import com.cskaoyan.mall.vo.wx.LoginRespVo;
import com.cskaoyan.mall.vo.wx.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 实用shiro后必须在访问已经实现的本地接口否则会被弹回登陆页面
 * 抓包请使用老师的接口登陆
 * 测试运行本地程序请使用此接口登陆
 */
@RestController
@RequestMapping("wx/auth")
public class WxAuthController {

    @Autowired
    AuthService authService;
    /*登陆*/
    @PostMapping("/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo){
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        CustomToken token = new CustomToken(username, password,"wx");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.fail();
        }
        // 返回session的id
        Serializable id = subject.getSession().getId();
        String time = getdelayTime();
        LoginRespVo loginRespVo = new LoginRespVo();
        loginRespVo.setToken((String)id);
        loginRespVo.setTokenExpire(time);
        Map<String,String> map = new HashMap<>(10);
        map.put("avatarUrl","");
        map.put("nickName",username);
        loginRespVo.setUserInfo(map);
        BaseRespVo ok = BaseRespVo.ok(loginRespVo);
        return ok;
    }

    private String getdelayTime() {
        long dalaytime = System.currentTimeMillis() + 60*60*1000;
        Date date = new Date(dalaytime);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        return s;
    }

    @PostMapping("/logout")
    public BaseRespVo logout() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        subject.logout();
        return BaseRespVo.exit();
    }

    @RequestMapping("/login_by_weixin")
    public BaseRespVo wxLogin(){
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/register")
    public BaseRespVo register(@RequestBody RegisterVo registerVo, HttpSession httpSession){
        String id = httpSession.getId();
        String codeFromSession = (String) httpSession.getAttribute("code");
        if(!registerVo.getCode().equals(codeFromSession)){
            return BaseRespVo.fail();
        }else {
           //authService.register(registerVo);
        }
        System.out.println(id);
        return BaseRespVo.ok(null);
    }
    @RequestMapping("/reset")
    public BaseRespVo reset(){
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/regCaptcha")
    public BaseRespVo regCaptcha(String mobile){
        Session session = SecurityUtils.getSubject().getSession();
        Serializable id = session.getId();
        int code = (int) ((Math.random()*9+1)*100000);
        session.setAttribute("code",code);
        System.out.println(id);
        return BaseRespVo.ok(id);
    }

    @RequestMapping("bindPhone")
    public BaseRespVo bindPhone(){
        return BaseRespVo.ok(null);
    }
}
