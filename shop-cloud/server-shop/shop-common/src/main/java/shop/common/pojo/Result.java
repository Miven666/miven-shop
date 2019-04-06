package shop.common.pojo;

import lombok.Data;
import shop.common.util.ResultStatus;

import java.io.Serializable;

/**
 * 前后端交互数据标准
 *
 * @author mingzhi.xie
 * @date 2019/4/6
 */

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5395083851087317344L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;

    public void setCode(ResultStatus status) {
        this.code = status.value();
    }
}
