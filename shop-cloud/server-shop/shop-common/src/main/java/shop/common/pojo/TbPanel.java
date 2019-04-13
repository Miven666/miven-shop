package shop.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 板块
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Data
public class TbPanel implements Serializable {
    private static final long serialVersionUID = -8610635605753551467L;

    private Integer id;

    private String name;

    private Integer type;

    private Integer sortOrder;

    private Integer position;

    private Integer limitNum;

    private Integer status;

    private String remark;

    private Date created;

    private Date updated;

    private List<TbPanelContent> panelContents;

    public TbPanel() {
    }

    public TbPanel(Integer position, Integer status) {
        this.position = position;
        this.status = status;
    }
}
