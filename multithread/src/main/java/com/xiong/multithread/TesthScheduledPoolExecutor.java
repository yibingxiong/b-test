package com.xiong.multithread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TesthScheduledPoolExecutor {
    @Test
    public void test1() throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3);
        scheduledThreadPoolExecutor.schedule(new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        }, 10, TimeUnit.SECONDS);
        Thread.sleep(20000);
    }

    @Test
    public void test2() throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(new Date());
            }
        }, 0, 3, TimeUnit.SECONDS);
        while (true){
            Thread.sleep(100);
        }
    }
}
