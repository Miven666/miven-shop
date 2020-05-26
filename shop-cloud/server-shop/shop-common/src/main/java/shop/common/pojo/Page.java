package shop.common.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页
 *
 * @author mingzhi.xie
 * @since 2020/5/25 1.0
 */
@Getter
@Setter
public class Page {
    /**
     * 当前页数
     */
    private int page = 1;
    /**
     * 每页大小
     */
    private int size = 20;
}
