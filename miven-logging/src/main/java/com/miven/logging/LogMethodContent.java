package com.miven.logging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

/**
 * 方法日志信息
 * @author mingzhi.xie
 * @since 1.0
 */
@Setter
@Getter
public class LogMethodContent<T> extends LogContent {
    private static final long serialVersionUID = -433906078857739516L;

    /**
     * 模块名,例如：{@link Module.SpringModule#Controller}
     * @see Module
     */
    @JSONField(ordinal = 100)
    private String module;
    /**
     * 请求IP
     */
    @JSONField(ordinal = 150)
    private String ip;
    /**
     * 映射地址
     */
    @JSONField(ordinal = 200)
    private String mapping;
    /**
     * 方法名
     */
    @JSONField(ordinal = 300)
    private String method;
    /**
     * 方法的行为
     */
    @JSONField(ordinal = 310)
    private MethodBehavior methodBehavior;
    /**
     * 方法参数
     */
    @JSONField(ordinal = 320)
    private Argument[] arguments;
    /**
     * 耗时
     */
    @JSONField(ordinal = 330)
    private long spendTimeMS;
    /**
     * 方法返回值对象
     */
    @JSONField(ordinal = 340)
    private T result;

    @Override
    protected void filterProperty() {
        super.filterProperty();
        Set<String> excludes = propertyPreFilter.getExcludes();
        if (!Module.SpringModule.Controller.name().equalsIgnoreCase(module)) {
            excludes.add("ip");
            excludes.add("mapping");
        } else {
            excludes.remove("ip");
            excludes.remove("mapping");
        }
        if (MethodBehavior.invoke.equals(methodBehavior)) {
            excludes.add("result");
            excludes.add("spendTimeMS");
        } else  {
            excludes.remove("result");
            excludes.remove("spendTimeMS");
        }
    }

    @Override
    public String toString() {
        filterProperty();
        return JSON.toJSONString(LogMethodContent.this, propertyPreFilter, WriteMapNullValue, IgnoreNonFieldGetter);
    }
}
