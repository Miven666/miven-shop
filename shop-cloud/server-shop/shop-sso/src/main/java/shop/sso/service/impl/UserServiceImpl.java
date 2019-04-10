package shop.sso.service.impl;

import cn.miven.cloud.common.jedis.JedisClient;
import cn.miven.cloud.common.jedis.JedisClientPool;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import shop.common.pojo.Member;
import shop.sso.properties.SessionProperties;
import shop.sso.service.UserService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JedisClient jedisClient;

    private Integer expire;

    public UserServiceImpl(SessionProperties sessionProperties) {
        this.expire = sessionProperties.getExpire();
    }

    @Override
    public Member getUserByToken(String token) {
        Optional<String> json = jedisClient.get("SESSION:" + token);
        if (!json.isPresent()) {
            Member member = new Member();
            member.setState(0);
            member.setMessage("用户登录已过期");
            return member;
        }
        //重置过期时间
        jedisClient.expire("SESSION:" + token, expire);
        return JSON.parseObject(json.get(),Member.class);
    }
}
