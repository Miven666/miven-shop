package shop.front.web.service.impl;

import org.springframework.stereotype.Service;
import shop.common.pojo.Member;
import shop.front.web.remote.SsoRemote;
import shop.front.web.service.SsoService;

import javax.annotation.Resource;

/**
 * 登录
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Service
public class SsoServiceImpl implements SsoService {
    @Resource
    private SsoRemote ssoRemote;

    @Override
    public Member getUserByToken(String token) {
        return ssoRemote.getUserByToken(token);
    }
}
