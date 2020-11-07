package com.nacos.shiro;

import com.nacos.feign.FeignUserClient;
import com.nacos.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 认证和授权
 * Created by tym
 */
public class UsersRealm extends AuthorizingRealm {

    @Autowired
    private FeignUserClient service;

    /**
     * 鉴权(认证)
     * 控制器调用subject.login(token)将调用该方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    /*@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("鉴权：");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //调用service根据用户名查询数据库获得Users对象
        Users user = service.findUsersByName(token.getUsername());
        System.out.println("user:"+user);
        if(user==null){
            //抛出UnknownAccountException
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }*/


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    /*@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权："+service);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //获得当前登录用户
        Subject subject = SecurityUtils.getSubject();
        Object user = subject.getPrincipal();
        //System.out.println("class:"+user.getClass());
        //和上面一样
        Users user2 = (Users)principalCollection.getPrimaryPrincipal();
        System.out.println(user+"\t"+user2);
        //info.addStringPermissions(new ArrayList<>());
        info.addStringPermission(user2.getPermission());
        info.addRole(user2.getRoles());
        System.out.println("permissions:"+user2.getPermission());
        System.out.println("roles:"+user2.getRoles());

        return info;
    }*/

    /**
     * 加密认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //调用service根据用户名查询数据库获得Users对象
        //User user = service.getOne(new QueryWrapper<User>().eq("userCode",token.getUsername()));
        //if (user == null) {
            //抛出UnknownAccountException
            //return null;
        //}
        //第三个参数：盐值(这个盐是 username)
        ByteSource solt = ByteSource.Util.bytes(token.getUsername());
        //第四个参数：获取这个Realm的信息
        String userCode = this.getName();
        return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), solt, userCode);
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得当前登录用户
        Subject subject = SecurityUtils.getSubject();
        String userCode = (String) subject.getPrincipal();
        //User user = service.getOne(new QueryWrapper<User>().eq("userCode",userCode));
        info.addRole(userCode.toString());                  //添加角色
        //info.addStringPermission(user.getUserRole().toString()); //添加权限
        //clearCached();  不能写这里清空
        return info;
    }

    /**
     * 自定义清空缓存方法
     */
    public void clearCached(){
        //清空缓存
        //super.clearCachedAuthenticationInfo(SecurityUtils.getSubject().getPrincipals());
        super.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        //super.clearCache(SecurityUtils.getSubject().getPrincipals());
    }
}
