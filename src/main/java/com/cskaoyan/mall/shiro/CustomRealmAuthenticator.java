package com.cskaoyan.mall.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

public class CustomRealmAuthenticator extends ModularRealmAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        this.assertRealmsConfigured();
        Collection<Realm> allRealms = this.getRealms();
        CustomToken token = (CustomToken) authenticationToken;
        String type = token.getType();
        Collection<Realm> realms = new ArrayList<>();
        for (Realm realm : allRealms) {
            //对realm进行筛选，筛选的标准是token中的type
            if (realm.getName().toLowerCase().contains(type)){
                realms.add(realm);
            }
        }
        //执行单个或多个认证
        return realms.size() == 1 ? this.doSingleRealmAuthentication((Realm)realms.iterator().next(), authenticationToken) : this.doMultiRealmAuthentication(realms, authenticationToken);
    }
}
