package shop.front.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.Member;
import shop.common.pojo.Result;
import shop.common.util.ResultUtils;
import shop.front.web.pojo.GeetestInit;
import shop.front.web.service.GeetestService;
import shop.front.web.service.SsoService;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 会员注册登录
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
@RestController
public class MemberController {
    @Resource
    private GeetestService geetestService;

    @Resource
    private SsoService ssoService;

    @GetMapping("/member/geetestInit")
    public GeetestInit geetestInit() {
        return geetestService.geetestInit(new HashMap<>(16));
    }

    @GetMapping("/member/checkLogin")
    public Result<Member> checkLogin(@RequestParam(defaultValue = "") String token){
        Member member = new Member();
        if (StringUtils.isEmpty(token)) {
            member.setState(0);
            member.setToken(token);
            member.setMessage("token is empty");
        } else {
            member = ssoService.getUserByToken(token);
        }

        return new ResultUtils<Member>().setData(member);
    }
}
