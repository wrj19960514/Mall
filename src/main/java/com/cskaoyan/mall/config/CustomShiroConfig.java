package com.cskaoyan.mall.config;

import com.cskaoyan.mall.shiro.CustomRealm;
import com.cskaoyan.mall.shiro.MallSessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author adore
 * @date 2019/10/4 19:13
 */
@Configuration
public class CustomShiroConfig {
    /*shiroFilter*/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/");
        // 拦截器
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/admin/auth/login", "anon");
        filterChainDefinitionMap.put("/admin/auth/info", "anon");
        filterChainDefinitionMap.put("/wx/storage/fetch/**", "anon");
        filterChainDefinitionMap.put("admin/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*securityManager*/
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("customRealm") CustomRealm customRealm,
                                                     DefaultSessionManager defaultSessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        securityManager.setSessionManager(defaultSessionManager);
        return securityManager;
    }

    /*realm*/
    /*SessionManager*/
    @Bean
    public DefaultSessionManager defaultSessionManager() {
        // 返回自定义的SessionManager
        return new MallSessionManager();
    }

    /*声明式使用鉴权注解的开关*/
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
}
