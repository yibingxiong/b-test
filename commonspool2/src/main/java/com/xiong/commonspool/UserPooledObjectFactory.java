package com.xiong.commonspool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class UserPooledObjectFactory implements PooledObjectFactory<User> {
    public PooledObject<User> makeObject() throws Exception {
        DefaultPooledObject<User> userDefaultPooledObject = new DefaultPooledObject<User>(new User());
        System.out.println("makeObject state=" + userDefaultPooledObject.getState());
        return userDefaultPooledObject;
    }

    public void destroyObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("destroyObject, state=" + pooledObject.getState());
    }

    public boolean validateObject(PooledObject<User> pooledObject) {
        System.out.println("validateObject, state=" + pooledObject.getState());
        return true;
    }

    public void activateObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("activateObject, state=" + pooledObject.getState());
    }

    public void passivateObject(PooledObject<User> pooledObject) throws Exception {
        System.out.println("passivateObject, state=" + pooledObject.getState());
    }
}
