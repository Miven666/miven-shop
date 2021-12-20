package com.miven.learning.rest;

import com.miven.learning.LearningLauncher;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * @author xiemingzhi
 * @since 1.0
 */
@SpringBootTest(classes = LearningLauncher.class)
public class RestTemplateDemoTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private RestTemplateDemo restTemplateDemo;

    @Test
    public void retryable() {
        restTemplateDemo.retryable();
    }
}