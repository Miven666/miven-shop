package com.miven.logging;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * Web请求内容
 * @author mingzhi.xie
 * @since 1.0
 */
@Getter
@Setter
public class WebRequestContent {
    /**
     * 请求IP
     */
    private String ip;
    /**
     * 映射地址
     */
    private String mapping;

    @Override
    public String toString() {
        return JSON.toJSONString(WebRequestContent.this);
    }
}
