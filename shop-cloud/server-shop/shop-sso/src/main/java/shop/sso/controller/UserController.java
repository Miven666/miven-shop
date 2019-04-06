package shop.sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.Member;
import shop.sso.service.UserService;

/**
 * 用户
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    Member getUserByToken(@RequestParam String token) {
        return null;
    }
}
