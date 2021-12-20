package com.miven.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 *  启动器
 * @author xiemingzhi
 * @since 1.0
 */
@EnableRetry
@SpringBootApplication
public class LearningLauncher {

    public static void main(String[] args) {
        SpringApplication.run(LearningLauncher.class, args);
    }
}
