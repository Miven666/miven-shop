package shop.front.web.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 极验初始化
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class GeetestInit extends Geetest{

    private int success;

    private String gt;

    private String statusKey;

    private boolean newCaptcha;
}
