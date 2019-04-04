package shop.front.web.manager.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shop.front.web.manager.route.UriRoute;
import shop.front.web.pojo.Geetest;

import java.util.Map;

/**
 * 极验消费者
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */

@Component
public class GeetestConsumer {

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<Geetest> register(Map<String, String> param) {
        return restTemplate.getForEntity(UriRoute.URI_GEETEST_REGISTER, Geetest.class, param);
    }
}
