package com.miven.logging;

/**
 * Web请求内容在线程上下文中的持有者
 * @author mingzhi.xie
 * @since 1.0
 */
public class WebRequestContentContextHolder {

    private static final ThreadLocal<WebRequestContent> HOLDER = new ThreadLocal<>();

    public static WebRequestContent getWebRequestContent() {
        return HOLDER.get();
    }

    public static void setWebRequestContent(WebRequestContent webRequestContent) {
        if (webRequestContent == null) {
            restWebRequestContent();
            return;
        }

        HOLDER.set(webRequestContent);
    }

    public static void restWebRequestContent() {
        HOLDER.remove();
    }
}
