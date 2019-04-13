package shop.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 面板内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@Data
public class TbPanelContent implements Serializable {
    private static final long serialVersionUID = -6753357515091984196L;

    private Integer id;

    private Integer panelId;

    private Integer type;

    private Long productId;

    private Integer sortOrder;

    private String fullUrl;

    private String picUrl;

    private String picUrl2;

    private String picUrl3;

    private Date created;

    private Date updated;

    private BigDecimal salePrice;

    private String productName;

    private String subTitle;

    public TbPanelContent() {
    }

    public TbPanelContent(Integer panelId) {
        this.panelId = panelId;
    }
}
