package shop.sso.service;

import shop.common.pojo.Member;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public interface UserService {

    /**
     * 根据token获取user
     * @param token token
     * @return  user
     */
    Member getUserByToken(String token);
}
