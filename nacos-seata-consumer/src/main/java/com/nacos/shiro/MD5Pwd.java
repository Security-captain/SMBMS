package com.nacos.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by tym
 */
public class MD5Pwd {

    public static final String ALGORITHM_NAME = "MD5";   // 基础散列算法
    public static final int HASH_ITERATIONS = 12;        // 自定义散列次数

    /**
     * MD5加密
     * @param username
     * @param password
     * @return
     */
    public static String MD5Pwd(String username, String password) {
        // salt盐值 username
        ByteSource salt = ByteSource.Util.bytes(username);
        String md5Pwd = new SimpleHash(ALGORITHM_NAME, password,
                salt, HASH_ITERATIONS).toHex();
        return md5Pwd;
    }

    public static void main(String[] args) {
        //加密的字符串
        String pwd = "123456";
        //盐值，用于和密码混合起来用
        ByteSource salt = ByteSource.Util.bytes("accp");
        //通过SimpleHash来进行加密操作
        SimpleHash hash = new SimpleHash(ALGORITHM_NAME, pwd, salt, HASH_ITERATIONS);
        System.out.println(salt.toHex() + "\t" + ByteSource.Util.bytes("admin").toHex());
    }
}
