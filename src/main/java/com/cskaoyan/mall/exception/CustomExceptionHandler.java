package com.cskaoyan.mall.exception;

import com.cskaoyan.mall.vo.BaseRespVo;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author adore
 * @date 2019/10/3 23:30
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public BaseRespVo myExceptionHandle(HttpMessageNotReadableException e) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("请输入正确的价格");
        baseRespVo.setErrno(402);
        return baseRespVo;
    }
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public BaseRespVo numberFormatExceptionHandle(NumberFormatException e) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("请输入正确的数据");
        baseRespVo.setErrno(402);
        return baseRespVo;
    }
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public BaseRespVo authorizationExceptionHandler(AuthorizationException e) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("没有访问权限");
        baseRespVo.setErrno(402);
        return baseRespVo;
    }
}
