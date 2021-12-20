package com.miven.learning.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiemingzhi
 * @since 1.0
 */
@Slf4j
@Component
public class RestTemplateDemo {

    @Resource
    private RestTemplate restTemplate;

    @Retryable(value = Exception.class, maxAttempts = 7,
            // 0.5 1 2 4 8 16 32 64 * 60 = 3840 必须设置 maxDelay
            backoff = @Backoff(delay = 30_000L, multiplier = 2, maxDelay = 3846_000L))
    public void retryable() {
        ResponseEntity<String> entity = restTemplate.getForEntity("https://www.baidu.com", String.class);
        String body = entity.getBody();
        log.info(body);
        if (entity.getStatusCode().is2xxSuccessful()) {
            // 以真乱假
            throw new RuntimeException("以真乱假去重试");
        }
        System.out.println(body);
    }
}
