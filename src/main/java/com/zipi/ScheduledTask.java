package com.zipi;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * author linzhicheng
 * 2018年6月16日16:36:36
 */
@Lazy(false)
@Configuration
@EnableScheduling
@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0/1 * * * ?")// 每分钟执行一次
    public void work() throws Exception {
        System.out.println("执行调度任务："+new Date());
    }
}
