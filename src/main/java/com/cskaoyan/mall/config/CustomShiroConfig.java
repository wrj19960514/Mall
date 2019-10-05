package com.cskaoyan.mall.config;

import com.cskaoyan.mall.shiro.AdminRealm;
import com.cskaoyan.mall.shiro.CustomRealmAuthenticator;
import com.cskaoyan.mall.shiro.MallSessionManager;
import com.cskaoyan.mall.shiro.WxRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

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
        //不需要认证
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/admin/auth/login", "anon");
        filterChainDefinitionMap.put("/admin/auth/info", "anon");
        filterChainDefinitionMap.put("/wx/storage/fetch/**", "anon");
        filterChainDefinitionMap.put("/wx/auth/login", "anon");
        filterChainDefinitionMap.put("/wx/user/index", "anon");
         //需要进行认证
        filterChainDefinitionMap.put("admin/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*注册securityManager*/
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                     @Qualifier("wxRealm") WxRealm wxRealm,
                                                     CustomRealmAuthenticator customRealmAuthenticator) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        securityManager.setRealms(realms);
        //认证器(doAuthenticate根据realm的个数决定执行单个认证或多个认证)
        securityManager.setAuthenticator(customRealmAuthenticator);
        return securityManager;
    }

    //注册认证器
    @Bean
    public CustomRealmAuthenticator customRealmAuthenticator(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                             @Qualifier("wxRealm") WxRealm wxRealm){
        CustomRealmAuthenticator customRealmAuthenticator = new CustomRealmAuthenticator();
        ArrayList<Realm> realms = new ArrayList<>();
        //告诉认证器要使用的realms是securityManager中的realms
        realms.add(adminRealm);
        realms.add(wxRealm);
        customRealmAuthenticator.setRealms(realms);
        return customRealmAuthenticator;
    }

    /*通过异常类型，映射到不同的请求上*/
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("org.apache.shiro.authz.AuthorizationException","/fail");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        return simpleMappingExceptionResolver;
    }
    /*自定义的sessionManager*/
    @Bean
    public DefaultWebSessionManager webSessionManager(){
        MallSessionManager mallSessionManager = new MallSessionManager();
        return mallSessionManager;
    }
}