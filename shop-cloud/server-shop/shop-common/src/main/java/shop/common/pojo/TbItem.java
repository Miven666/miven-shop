package shop.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Data
public class TbItem implements Serializable {

    private static final long serialVersionUID = -1013639554934273366L;

    private Long id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private Integer limitNum;

    private String image;

    private Long cid;

    private Byte status;

    private Date created;

    private Date updated;
}
