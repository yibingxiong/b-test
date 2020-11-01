package com.xiong.multithread;

import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
        final LinkedList<String> linkedList = new LinkedList<>();
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(new Date());
                linkedList.add("hello" + atomicInteger.getAndIncrement());
            }
        }, 0, 30, TimeUnit.SECONDS);
        while (true){
            Thread.sleep(100);
        }
    }
}
