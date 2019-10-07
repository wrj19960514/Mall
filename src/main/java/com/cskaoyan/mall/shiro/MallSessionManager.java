package com.cskaoyan.mall.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author adore
 * @date 2019/10/4 20:10
 */
public class MallSessionManager extends DefaultWebSessionManager {
    @Override
    protected Serializable getSessionId(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //后台X-cskaoyanmall-Admin-Token
        //前端X-Litemall-Token
        String header = request.getHeader("X-cskaoyanmall-Admin-Token");
        if (header != null && !"".equals(header)) {
            return header;
        }
        return super.getSessionId(servletRequest, response);
    }
}
