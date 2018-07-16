package com.zipi;

import com.zipi.core.config.EnvConfigBanner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author linzhicheng
 * 2018年6月13日13:16:36
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.zipi.*.*.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartApplication.class);
        application.setBanner(new EnvConfigBanner());
        application.run(args);
    }
}