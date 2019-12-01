package com.meiyingying.springlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(scanBasePackages = {"com.meiyingying.springlaunch.service","org.dozer"})
public class SpringlaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringlaunchApplication.class, args);
    }

}
