package com.uedsonreis.mybeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "io.github.uedsonreis.*",
        "com.uedsonreis.mybeer.*"
})
public class MyBeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBeerApplication.class, args);
    }

}
