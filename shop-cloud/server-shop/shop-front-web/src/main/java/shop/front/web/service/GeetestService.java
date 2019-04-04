package shop.front.web.service;

import shop.front.web.pojo.GeetestInit;

import java.util.Map;

/**
 * 极验
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
public interface GeetestService {

    String VER_NAME = "4.0";

    String SDK_LANG = "java";

    String API_URL = "http://api.geetest.com";

    String REGISTER_URL = "/register.php";

    String VALIDATE_URL = "/validate.php";

    String JSON_FORMAT = "1";

    /**
     * 极验初始化
     * @param map 初始化参数
     * @return  GeetestInit
     */
    GeetestInit geetestInit(Map<String, String> map);
}
