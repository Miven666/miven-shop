package com.miven.core.util;

/**
 * 字符串工具类
 * @author mingzhi.xie
 * @date 2019/7/17
 * @since 1.0
 */
public class StringUtils {

    /**
     * 去除多行注释中'*'和换行
     * @param comment 注释
     * @return 注释文本
     */
    public static String formatComment(String comment) {
        return comment.replace(" * ", " ").replaceAll("\r|\n", " ");
    }
}
