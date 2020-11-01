package com.xiong.jvmtool;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsaveTest {
    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredField.get(null);

        while (true) {
            unsafe.allocateMemory(1024 * 1024 * 100);
            Thread.sleep(1000);
            System.out.println("分配");
        }
    }
}
