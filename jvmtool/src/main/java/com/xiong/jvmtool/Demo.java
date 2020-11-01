package com.xiong.jvmtool;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static List<Byte[]> oomList = new ArrayList<>();
    public static void start() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        while (true) {
            try {
                Thread.sleep(1004);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void oom() {
        while (true) {
            oomList.add(new Byte[1024 * 1024 * 10]);
        }
    }
}
