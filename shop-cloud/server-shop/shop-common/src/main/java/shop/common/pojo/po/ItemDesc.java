package shop.common.pojo.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 商品详情表
 * @author mingzhi.xie
 * @since 2020/5/26 1.0
 */
@Getter
@Setter
@Table(name = "tb_item_desc")
public class ItemDesc {
    /**
     * 商品ID
     */
    @Id
    @Column(name = "item_id")
    private Long itemId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 商品描述
     */
    @Column(name = "item_desc")
    private String itemDesc;
}
