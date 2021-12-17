package com.miven.spring.boot.autoconfigure.logging;

import com.miven.logging.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 日志方法拦截器
 *
 * @author mingzhi.xie
 * @since 1.0
 */
public class MethodLogInterceptor implements MethodInterceptor {
    /**
     * 该拦截器最终会被注册成单例，所以直接用{@link LogMethodContent}做成员变量很可能
     * 引发线程安全问题
     * 也可以改写成局部变量解决此问题，这里采用{@link ThreadLocal}方式
     */
    private final ThreadLocal<LogMethodContent<Object>> ctl = ThreadLocal.withInitial(LogMethodContent::new);
    /**
     * 是否开启控制层日志
     */
    private final boolean lcEnable;

    public MethodLogInterceptor(boolean lcEnable) {
        this.lcEnable = lcEnable;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Logger logger = LoggerFactory.getLogger(invocation.getThis().getClass());
        Method method = invocation.getMethod();

        Class<?> declaringClass = method.getDeclaringClass();
        boolean presentMethod = method.isAnnotationPresent(Logging.class);
        boolean presentDC = declaringClass.isAnnotationPresent(Logging.class);
        Logging logging = null;
        if (presentMethod) {
            logging = method.getDeclaredAnnotation(Logging.class);
        } else if (presentDC) {
            logging = declaringClass.getDeclaredAnnotation(Logging.class);
        } else if (lcEnable && isDeclaringController(declaringClass)) {
            logging = new Logging() {
                @Override
                public Class<? extends Annotation> annotationType() {
                    return Logging.class;
                }

                @Override
                public Level level() {
                    return Level.INFO;
                }

                @Override
                public String module() {
                    return "Controller";
                }
            };
        }
        if (logging != null) {
            String module = logging.module();
            if (!StringUtils.hasText(module)) {
                if (isDeclaringController(declaringClass)) {
                    module = Controller.class.getSimpleName();
                }
                if (declaringClass.isAnnotationPresent(Service.class)) {
                    module = Service.class.getSimpleName();
                }
                if (declaringClass.isAnnotationPresent(Repository.class)) {
                    module = Repository.class.getSimpleName();
                }
            }

            LogMethodContent<Object> content = ctl.get();
            WebRequestContent webRequestContent = WebRequestContentContextHolder.getWebRequestContent();
            if (Module.SpringModule.Controller.name().equalsIgnoreCase(module) && webRequestContent!= null) {
                content.setMapping(webRequestContent.getMapping());
                content.setIp(webRequestContent.getIp());
            }

            content.setModule(module);
            content.setMethod(method.getName());
            content.setMethodBehavior(MethodBehavior.invoke);
            Object[] rawArguments = invocation.getArguments();
            Parameter[] parameters = method.getParameters();
            int length = parameters.length;
            Argument[] arguments = new Argument[length];
            for (int i = 0; i < length; i++) {
                Argument argument = new Argument();
                argument.setType(parameters[i].getType().getName());
                argument.setName(parameters[i].getName());
                argument.setValue(rawArguments[i]);
                arguments[i] = argument;
            }
            content.setArguments(arguments);
            LogUtils.log(logging.level(), logger, content.toString());

            long start = System.currentTimeMillis();
            Object result = invocation.proceed();
            content.setSpendTimeMS(System.currentTimeMillis() - start);
            content.setMethodBehavior(MethodBehavior.answer);
            content.setResult(result);
            LogUtils.log(logging.level(), logger, content.toString());
            ctl.remove();

            return result;
        }
        return invocation.proceed();
    }

    private boolean isDeclaringController(Class<?> declaringClass) {
        return declaringClass.isAnnotationPresent(Controller.class) || declaringClass.isAnnotationPresent(RestController.class);
    }
}
