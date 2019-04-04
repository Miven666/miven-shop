package shop.front.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.front.web.pojo.GeetestInit;
import shop.front.web.service.GeetestService;

import java.util.HashMap;

/**
 * 会员注册登录
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */

@RestController
public class MemberController {

    private final GeetestService geetestService;

    public MemberController(GeetestService geetestService) {
        this.geetestService = geetestService;
    }

    @GetMapping("/member/geetestInit")
    public GeetestInit geetestInit() {
        return geetestService.geetestInit(new HashMap<>(16));
    }
}
