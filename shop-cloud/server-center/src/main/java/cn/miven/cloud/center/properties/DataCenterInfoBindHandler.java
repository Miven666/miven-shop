package cn.miven.cloud.center.properties;

import cn.miven.cloud.center.info.ShanghaiDataCenterInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.AbstractBindHandler;
import org.springframework.boot.context.properties.bind.BindContext;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;

/**
 * @author mingzhi.xie
 * @date 2020/4/24
 * @since 1.0
 */
@Slf4j
public class DataCenterInfoBindHandler extends AbstractBindHandler {

    private static final String PREFIX = "eureka.instance";

    public DataCenterInfoBindHandler(BindHandler parent) {
        super(parent);
    }

    @Override
    public <T> Bindable<T> onStart(ConfigurationPropertyName name, Bindable<T> target, BindContext context) {
        if (PREFIX.equals(name.toString())) {
            log.info("Default setting eureka.instance.data-center-info as: shanghai");
        }
        return super.onStart(name, target, context);
    }

    @Override
    public Object onSuccess(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) {
        if (PREFIX.equals(name.toString())) {
            log.info("Set successful eureka.instance.data-center-info as: shanghai");
        }
        return super.onSuccess(name, target, context, result);
    }

    @Override
    public Object onFailure(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Exception error) throws Exception {
        if (PREFIX.equals(name.toString())) {
            log.info("Set onFailure eureka.instance.data-center-info as: shanghai");
        }
        return super.onFailure(name, target, context, error);
    }

    @Override
    public void onFinish(ConfigurationPropertyName name, Bindable<?> target, BindContext context, Object result) throws Exception {
        if (PREFIX.equals(name.toString()) && result instanceof EurekaInstanceConfigBean) {
            ((EurekaInstanceConfigBean) result).setDataCenterInfo(new ShanghaiDataCenterInfo());
            log.info("Set onFinish eureka.instance.data-center-info as: shanghai");
        }
        super.onFinish(name, target, context, result);
    }
}
