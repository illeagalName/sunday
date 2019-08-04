package com.seventh.sunday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:dubbo.xml")
public class SundayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SundayApplication.class, args);
    }

}
