package com.miven.spring.boot.autoconfigure.logging;

import com.miven.logging.Logging;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.AbstractSingletonProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.scope.ScopedProxyFactoryBean;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;

/**
 * 增强方法日志输出的处理器
 *
 * @author mingzhi.xie
 * @since 1.0
 * @see ScopedProxyFactoryBean
 * @see AbstractSingletonProxyFactoryBean
 */
public class MethodLogAdvisingPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor implements InitializingBean, EnvironmentAware {

    private static final long serialVersionUID = -2593285466220107057L;

    private final Class<? extends Annotation> loggingType = Logging.class;
    private final Class<? extends Annotation> controllerType = Controller.class;
    private final Class<? extends Annotation> restControllerType = RestController.class;

    /**
     * 是否开启控制层日志
     */
    private boolean lcEnable = true;

    protected Advice createMethodLogInterceptor() {
        return new MethodLogInterceptor(lcEnable);
    }

    @Override
    public void afterPropertiesSet() {
        Pointcut lCP = new AnnotationMatchingPointcut(loggingType, true);
        ComposablePointcut result = new ComposablePointcut(lCP);

        Pointcut lMP = new AnnotationMatchingPointcut(null, loggingType, true);
        result = result.union(lMP);

        if (lcEnable) {
            Pointcut cCP = new AnnotationMatchingPointcut(controllerType, true);
            Pointcut rcCP = new AnnotationMatchingPointcut(restControllerType, true);
            result = result.union(cCP).union(rcCP);
        }
        super.advisor = new DefaultPointcutAdvisor(result, createMethodLogInterceptor());
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.lcEnable = Boolean.parseBoolean(environment.getProperty("miven.spring.logging.controller.enable", "true"));
    }

}
