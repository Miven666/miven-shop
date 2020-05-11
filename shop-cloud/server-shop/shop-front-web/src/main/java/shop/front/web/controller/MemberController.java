package shop.front.web.controller;

import com.miven.logging.Logging;
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
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 会员注册登录
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
@Logging
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

    @Logging
    @GetMapping("/member/checkLogin")
    public Result<Member> checkLogin(@RequestParam(defaultValue = "") String token) {
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

    @Logging
    @GetMapping("/demo")
    public String demo(String token, String token1, String age, int num, HttpServletRequest request) {
        System.out.println("context path: " + request.getContextPath());
        System.out.println("local addr: " + request.getLocalAddr());
        System.out.println("local name: " + request.getLocalName());
        System.out.println("path info: " + request.getPathInfo());
        System.out.println("path translated: " + request.getPathTranslated());
        System.out.println("query string: " + request.getQueryString());
        System.out.println("remote addr: " + request.getRemoteAddr());
        System.out.println("remote host: " + request.getRemoteHost());
        System.out.println("remote port: " + request.getRemotePort());
        System.out.println("request uri: " + request.getRequestURI());
        System.out.println("request url: " + request.getRequestURL());
        System.out.println("scheme: " + request.getScheme());
        System.out.println("server name: " + request.getServerName());
        System.out.println("servlet path: " + request.getServletPath());
        return "SUCCESS";
    }
}
