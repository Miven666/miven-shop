package shop.front.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.Member;
import shop.common.pojo.Result;
import shop.common.util.ResultUtils;
import shop.front.web.pojo.GeetestInit;
import shop.front.web.service.GeetestService;
import shop.front.web.manager.consumer.SsoConsumer;

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

    private final SsoConsumer ssoConsumer;

    public MemberController(GeetestService geetestService, SsoConsumer ssoConsumer) {
        this.geetestService = geetestService;
        this.ssoConsumer = ssoConsumer;
    }

    @GetMapping("/member/geetestInit")
    public GeetestInit geetestInit() {
        return geetestService.geetestInit(new HashMap<>(16));
    }

    @GetMapping("/member/checkLogin")
    public Result checkLogin(@RequestParam(defaultValue = "") String token){
        Member member = ssoConsumer.getUserByToken(token);
        return new ResultUtils<Member>().setData(member);
    }
}
