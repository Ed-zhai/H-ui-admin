package com.lanou.shiro;

import com.lanou.bean.SysUser;
import com.lanou.service.SysUserService;
import com.lanou.service.impl.SysUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/11/7.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService ;

    @Override
    public String getName() {

        return "realm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {

        return token instanceof UsernamePasswordToken;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        String username = (String) authenticationToken.getPrincipal();

        SysUser sysUser = sysUserService.selectByName(username);

        if (username == null || username.trim().equals("")||sysUser == null) {

            throw new UnknownAccountException("用户名错误");
        }

        String password = new String((char[]) authenticationToken.getCredentials());

        if (!sysUser.getPassword().equals(password)) {

            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

        //可以获取sysUser的用户id及各种信息

        List<String> perList = Arrays.asList("sysUser:query", "sysUser:update");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        for (String per : perList) {

            info.addStringPermission(per);
        }

        return info;
    }

}
