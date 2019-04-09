package shop.front.web.manager.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import shop.common.pojo.Member;
import shop.front.web.manager.consumer.SsoConsumer;

/**
 * 登录熔断
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Component
public class SsoHystrix implements SsoConsumer {
    private final static Logger logger = LoggerFactory.getLogger(SsoHystrix.class);

    @Override
    public Member getUserByToken(String token) {
        logger.error("FeignClient shop-sso getUserByToken is error.");
        Member member = new Member();
        member.setState(-1);
        member.setToken(token);
        member.setMessage("shop-sso is error");
        return member;
    }
}
