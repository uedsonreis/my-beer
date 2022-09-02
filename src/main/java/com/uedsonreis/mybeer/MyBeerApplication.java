package com.uedsonreis.mybeer;

import io.github.uedsonreis.libwscrud.api.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ SwaggerConfig.class })
@SpringBootApplication(scanBasePackages = {
        "io.github.uedsonreis.*",
        "com.uedsonreis.mybeer.*"
})
public class MyBeerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBeerApplication.class, args);
    }

}
