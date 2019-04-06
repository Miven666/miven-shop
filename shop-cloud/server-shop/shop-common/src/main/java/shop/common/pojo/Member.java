package shop.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@Data
public class Member implements Serializable {
    private static final long serialVersionUID = -3358982819161824186L;
    private Long id;
    private String username;
    private String phone;
    private String email;
    private String sex;
    private String address;
    private String file;
    private String description;
    private Integer points;
    private Long balance;
    private int state;
    private String token;
    private String message;
}
