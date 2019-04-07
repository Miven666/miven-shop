package shop.front.web.manager.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.common.pojo.Member;
import shop.front.web.manager.hystrix.SsoHystrix;

/**
 * 登录
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@FeignClient(value = "shop-sso", fallback = SsoHystrix.class)
public interface SsoConsumer {

    /**
     * 根据token获取user
     * @param token token
     * @return  user
     */
    @GetMapping("/user")
    Member getUserByToken(@RequestParam String token);
}
