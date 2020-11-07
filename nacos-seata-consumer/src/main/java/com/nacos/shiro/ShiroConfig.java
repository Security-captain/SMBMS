package com.nacos.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tym
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private ShiroProperties shiroProperties;

    /**
     * 创建ShiroFilterFactoryBean
     */
    /*@Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        // 1.定义shiroFactoryBean
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        // 2.设置securityManager
        factory.setSecurityManager(securityManager);
        // 3.LinkedHashMap是有序的，进行顺序拦截器配置，也就是前面匹配放过后不会执行后面拦截，不用HashMap
        Map<String, String> filterMap = new LinkedHashMap<>();
        //放过静态资源，默认静态映射static，所以不要加
        filterMap.put("/js/**", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/doRegist", "anon");
        filterMap.put("/unauth", "anon");
        filterMap.put("/doLogin", "anon");
        // 4.配置logout过滤器
        filterMap.put("/logout", "logout");
        // 5.除了上面的其他url必须通过认证才可以访问
        filterMap.put("/add","roles[admins]");
        filterMap.put("/update","roles[manager]");
        filterMap.put("/update","perms[user:update]");
        filterMap.put("/**", "authc");
        //注意顺序：这里的已经被上面拦截不能过去
        //filterMap.put("/index","anon");
        // 6.设置默认登录的url
        factory.setLoginUrl("/login");
        // 7.设置未授权界面
        factory.setUnauthorizedUrl("/unauth");
        // 8.设置shiroFilterFactoryBean的FilterChainDefinitionMap
        factory.setFilterChainDefinitionMap(filterMap);
        return factory;
    }*/

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        factory.setSecurityManager(securityManager);

        //shiroProperties.getFilterChainDefinitionMap().put("/**", "authc");
        //factory.setFilterChainDefinitionMap(shiroProperties.getFilterChainDefinitionMap());

        Map<String, String> filterMap = new LinkedHashMap<>();
        shiroProperties.getPerms().forEach(m->{
            filterMap.put(m.get("url"),m.get("permission"));
        });
        factory.setLoginUrl("/login");
        factory.setUnauthorizedUrl("/unauth");
        factory.setFilterChainDefinitionMap(filterMap);
        return factory;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager securityManager(Realm usersRealm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        // 将自定义的realm交给SecurityManager管理
        sm.setRealm(usersRealm);
        // 自定义缓存实现 使用redis
        sm.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        sm.setSessionManager(sessionManager());
        return sm;
    }

    /**
     * 创建Realm
     */
    @Bean
    public UsersRealm usersRealm(HashedCredentialsMatcher hcm) {
        UsersRealm realm = new UsersRealm();
        realm.setCachingEnabled(true);
        realm.setAuthorizationCachingEnabled(true);
        //设置加密
        realm.setCredentialsMatcher(hcm);
        return realm;
    }

    /**
     * 配置加密
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
        hcm.setHashAlgorithmName(MD5Pwd.ALGORITHM_NAME);    // 散列算法
        hcm.setHashIterations(MD5Pwd.HASH_ITERATIONS);      // 散列次数
        return hcm;
    }

    /**
     * 用于thymeleaf和shiro标签整合
     * 没有标签不起作用
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * redisManager
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        //单位秒,默认2000
        redisManager.setTimeout(2000);
        return redisManager;
    }

    /**
     * cacheManager
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        //设置缓存过期时间，单位秒
        redisCacheManager.setExpire(300);
        return redisCacheManager;
    }

    /**
     * redisSessionDAO
     */
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * sessionManager
     */
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        //sessionManager.setGlobalSessionTimeout(300);
        return sessionManager;
    }

}
