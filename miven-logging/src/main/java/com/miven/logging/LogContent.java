package com.miven.logging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * 日志信息
 * @author mingzhi.xie
 * @since 1.0
 */
@Getter
@Setter
public class LogContent implements Serializable {
    private static final long serialVersionUID = -5803742959496051744L;
    protected transient PropertyPreFilters.MySimplePropertyPreFilter propertyPreFilter = new PropertyPreFilters().addFilter();

    @JSONField(ordinal = 1000)
    protected String exception;
    @JSONField(ordinal = 2000)
    protected String msg;

    protected void filterProperty() {
        propertyPreFilter.addExcludes("propertyPreFilter");
        Set<String> excludes = propertyPreFilter.getExcludes();
        if (exception == null && msg == null) {
            excludes.add("exception");
            excludes.add("msg");
        } else {
            excludes.remove("exception");
            excludes.remove("msg");
        }
    }

    @Override
    public String toString() {
        filterProperty();
        return JSON.toJSONString(LogContent.this, propertyPreFilter, SerializerFeature.WriteMapNullValue);
    }
}
