package com.miven.logging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 微服务方法日志信息
 * @author mingzhi.xie
 * @since 1.0
 */
@Getter
@Setter
public class LogMethodMicroServiceContent<T> extends LogMethodContent<T> {
    private static final long serialVersionUID = 3538082186736345581L;

    /**
     * 服务名
     */
    @JSONField(ordinal = 10)
    private String server;
    /**
     * 域名
     */
    @JSONField(ordinal = 20)
    protected String host;
    /**
     * 全链路ID
     */
    @JSONField(ordinal = 30)
    protected String traceId;
    /**
     * 分片ID
     */
    @JSONField(ordinal = 31)
    private String spanId;

    @Override
    protected void filterProperty() {
        super.filterProperty();
        Set<String> excludes = propertyPreFilter.getExcludes();
        if (!Module.SpringModule.Controller.name().equalsIgnoreCase(super.getModule())) {
            excludes.add("host");
        } else  {
            excludes.remove("host");
        }
    }

    @Override
    public String toString() {
        filterProperty();
        return JSON.toJSONString(this, propertyPreFilter, SerializerFeature.WriteMapNullValue);
    }
}
