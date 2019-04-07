package shop.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.Member;
import shop.sso.service.UserService;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/user")
    public Member getUserByToken(@RequestParam String token) {
        return userService.getUserByToken(token);
    }
}
