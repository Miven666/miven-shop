package cn.miven.cloud.center.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * eureka事件监听器
 * @author mingzhi.xie
 * @date 2020/4/27
 * @since 1.0
 */
@Slf4j
@Component
public class EurekaListener {

    @EventListener
    public void OnEurekaServerStartedEvent(EurekaServerStartedEvent event) {
        log.info("Eureka server started event: {}", JSON.toJSONString(event));
    }

    @EventListener
    public void OnEurekaRegistryAvailableEvent(EurekaRegistryAvailableEvent event) {
        log.info("Eureka registry available event: {}", JSON.toJSONString(event));
    }

    @EventListener
    public void OnEurekaInstanceRenewedEvent(EurekaInstanceRenewedEvent event) {
        log.info("Eureka instance renewed event: {}", JSON.toJSONString(event));
    }

    @EventListener
    public void OnEurekaInstanceRegisteredEvent(EurekaInstanceRegisteredEvent event) {
        log.info("Eureka instance registered event: {}", JSON.toJSONString(event));
    }

    @EventListener
    public void OnEurekaInstanceCanceledEvent(EurekaInstanceCanceledEvent event) {
        log.info("Eureka instance canceled event: {}", JSON.toJSONString(event));
    }
}
