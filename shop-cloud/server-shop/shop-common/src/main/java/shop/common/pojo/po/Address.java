package shop.common.pojo.po;

import lombok.Data;

import javax.persistence.*;

/**
 * 地址表
 * @author mingzhi.xie
 * @date 2020/5/26
 * @since 1.0
 */
@Data
@Table(name = "tb_address")
public class Address {
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    private String tel;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "is_default")
    private Boolean isDefault;
}