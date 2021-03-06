package com.zipi;

import com.zipi.core.config.EnvConfigBanner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * author linzhicheng
 * 2018年6月13日13:16:36
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.zipi.*.*.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartApplication.class);
        application.setBanner(new EnvConfigBanner());
        application.run(args);
    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println("事务管理器>>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }

}