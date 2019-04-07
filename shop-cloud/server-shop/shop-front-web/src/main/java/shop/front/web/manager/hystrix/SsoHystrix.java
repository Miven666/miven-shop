package shop.front.web.manager.hystrix;

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
    @Override
    public Member getUserByToken(String token) {
        return null;
    }
}
