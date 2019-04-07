package shop.front.web.service;

import shop.common.pojo.Member;

/**
 * 登录
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public interface SsoService {
    /**
     * 根据token获取user
     * @param token token
     * @return  user
     */
    Member getUserByToken(String token);
}
