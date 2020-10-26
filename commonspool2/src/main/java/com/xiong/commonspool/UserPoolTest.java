package com.xiong.commonspool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class UserPoolTest {
    public static void main(String[] args) throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        GenericObjectPool<User> pool = new GenericObjectPool<User>(new UserPooledObjectFactory(), config);
        User user = pool.borrowObject();
        user.setUsername("hello");
        user.sayName();
        pool.returnObject(user);
        int numActive = pool.getNumActive();
        System.out.println("numActive=" + numActive);
    }
}
