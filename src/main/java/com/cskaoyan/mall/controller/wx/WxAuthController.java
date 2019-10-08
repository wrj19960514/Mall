package com.cskaoyan.mall.controller.wx;

import com.cskaoyan.mall.service.wx.AuthService;
import com.cskaoyan.mall.service.wx.SmsService;
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
    SmsService smsService;
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
        map.put("avatarUrl","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
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
    public BaseRespVo register(@RequestBody RegisterVo registerVo){
        boolean flag;
        Session session = SecurityUtils.getSubject().getSession();
        String codeFromSession = (String) session.getAttribute("code");
        if(!registerVo.getCode().equals(codeFromSession)){
            return BaseRespVo.fail();
        }else {
           flag = authService.register(registerVo);
        }
        if(flag == true){
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }
    @RequestMapping("/reset")
    public BaseRespVo reset(){
        return BaseRespVo.ok(null);
    }

    @RequestMapping("/regCaptcha")
    public BaseRespVo regCaptcha(@RequestBody Map map){
        Session session = SecurityUtils.getSubject().getSession();
        String mobile = (String) map.get("mobile");
        // 验证码
        String code = (int) ((Math.random()*9+1)*100000) + "";
        boolean b = smsService.sendMessage(mobile, code);
        if (b) {
            session.setAttribute("code",code);
            Serializable id = session.getId();
            return BaseRespVo.ok(id);
        }
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("发送验证码失败");
        baseRespVo.setErrno(500);
        return baseRespVo;
    }

    @RequestMapping("bindPhone")
    public BaseRespVo bindPhone(){
        return BaseRespVo.ok(null);
    }
}
