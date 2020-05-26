package shop.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 知道总条数的数据集
 * @author mingzhi.xie
 * @date 2020/5/22
 * @since 1.0
 */
@Getter
@Setter
public class DataPages {

    private long total;

    private List<?> data;
}
