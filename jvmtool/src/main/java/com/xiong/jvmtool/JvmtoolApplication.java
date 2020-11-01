package com.xiong.jvmtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JvmtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvmtoolApplication.class, args);
        Demo.start();
    }

}
