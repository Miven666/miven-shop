package cn.miven.cloud.center.properties;

import org.springframework.boot.context.properties.ConfigurationPropertiesBindHandlerAdvisor;
import org.springframework.boot.context.properties.bind.BindHandler;
import org.springframework.context.annotation.Configuration;

/**
 * @author mingzhi.xie
 * @date 2020/4/24
 * @since 1.0
 */
@Configuration
public class DataCenterInfoBindHandlerAdvisor implements ConfigurationPropertiesBindHandlerAdvisor {

    @Override
    public BindHandler apply(BindHandler bindHandler) {
        return new DataCenterInfoBindHandler(bindHandler);
    }
}
