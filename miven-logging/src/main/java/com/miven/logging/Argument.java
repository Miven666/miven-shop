package com.miven.logging;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * 方法参数
 * @author mingzhi.xie
 * @since 1.0
 */
@Getter
@Setter
public class Argument {
    /**
     * 参数类型
     */
    private String type;
    /**
     * 参数名
     */
    private String name;
    /**
     * 参数值
     */
    private Object value;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
