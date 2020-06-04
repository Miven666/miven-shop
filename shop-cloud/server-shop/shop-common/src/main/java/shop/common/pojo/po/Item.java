package shop.common.pojo.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */
@Getter
@Setter
public class Item implements Serializable {
    private static final long serialVersionUID = -1013639554934273366L;
    /**
     * 商品id，同时也是商品编号
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品卖点
     */
    private String sellPoint;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 售卖数量限制
     */
    private Integer limitNum;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 分类号
     */
    private Long cid;
    /**
     * 商品状态 1正常 0下架
     */
    private Byte status;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

    public String[] getImage() {
        return (image != null && !"".equals(image)) ? image.split(",") : new String[0];
    }
}
