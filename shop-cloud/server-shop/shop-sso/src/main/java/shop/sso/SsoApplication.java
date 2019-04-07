package shop.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 登录服务
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoApplication.class, args);
    }
}
