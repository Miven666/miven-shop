package shop.common.util;

import com.sun.istack.internal.Nullable;
import org.springframework.util.Assert;

/**
 * 前后端交互结果集状态
 *
 * @author mingzhi.xie
 * @date 2019/4/6
 */
public enum ResultStatus {
    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 内部服务错误
     */
    ERROR(500, "Internal Server Error"),

    ;

    /**
     * 状态码
     */
    private final Integer value;

    /**
     * 原因
     */
    private final String reasonPhrase;

    ResultStatus(Integer value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public static ResultStatus valueOf(int statusCode) {
        ResultStatus status = resolve(statusCode);
        Assert.notNull(status, "No matching constant for [" + statusCode + "]");
        return status;
    }

    @Nullable
    public static ResultStatus resolve(int statusCode) {
        ResultStatus[] var1 = values();

        for (ResultStatus status : var1) {
            if (status.value == statusCode) {
                return status;
            }
        }

        return null;
    }
}
