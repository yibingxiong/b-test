package com.xiong.jvmtool.controller;

import com.xiong.jvmtool.Demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static volatile boolean run = true;
    @GetMapping("/test1")
    public String test() throws InterruptedException {
        run = true;
        Thread thread = new Thread(() -> {
            while (run) {

            }
        });
        thread.setName("testThread");
        thread.start();
        thread.join();
        return "success";
    }

    @GetMapping("/test2")
    public String test2() {
        run = false;
        return "success";
    }

    @GetMapping("/testoom")
    public String testOom() {
        Demo.oom();
        return "success";
    }
}
