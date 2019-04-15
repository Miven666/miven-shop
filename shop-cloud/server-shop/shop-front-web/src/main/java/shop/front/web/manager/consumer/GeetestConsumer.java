package shop.front.web.manager.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import shop.front.web.manager.route.UriRoute;
import shop.front.web.pojo.Geetest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 极验消费者
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */

@Component
public class GeetestConsumer {

    @Resource
    private RestTemplate restTemplate;

    public ResponseEntity<Geetest> register(Map<String, String> param) {
        // 对参数拼接中，默认实现 HierarchicalUriComponents类的expandQueryParams(UriTemplateVariables variables)方法貌似有点问题，有待研究，先自己简单实现下
        StringBuilder params = new StringBuilder("?");
        for (String key : param.keySet()) {
            params.append(key);
            params.append("=");
            params.append(param.get(key));
            params.append("&");
        }
        return restTemplate.getForEntity(UriRoute.URI_GEETEST_REGISTER + params.toString(), Geetest.class);
    }
}
