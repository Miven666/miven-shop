package shop.common.pojo;

import lombok.Getter;
import lombok.Setter;
import shop.common.util.SortRule;

/**
 * 排序的分页
 *
 * @author mingzhi.xie
 * @since 2020/5/25 1.0
 */
@Getter
@Setter
public class SortPage extends Page {
    /**
     * 排序字段名
     */
    private String sortFeild;
    /**
     * 排序字段名
     */
    private SortRule rule;

}
