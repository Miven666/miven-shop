package com.miven.learning.redis;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author xiemingzhi
 * @since 1.0
 */
@Component
public class RedisOperationDemo {

    @Resource
    private RedisTemplate<String, Object> redisTemplateJson;

    public void execute() {
        ArrayList<String> strings = new ArrayList<>(8);
        strings.add("test2");
        strings.add("test1");
        byte[][] keys = strings.stream().map(s -> s.getBytes(StandardCharsets.UTF_8))
                .toArray(byte[][]::new);
        Long count = redisTemplateJson.execute((RedisCallback<Long>) connection -> connection.exists(keys));
        System.out.println(count);
    }
}
