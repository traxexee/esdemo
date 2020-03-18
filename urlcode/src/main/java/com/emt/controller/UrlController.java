package com.emt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/order")
@Slf4j
public class UrlController {
    //http://anydomain.com/wechat/order/entry?cons=0150019818
    //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx96eb8ffc58aae982&redirect_uri=http://anydomain.com/wechat/order/pay&response_type=code&scope=snsapi_base&state=0150019818&connect_redirect=1#wechat_redirect

    @GetMapping("/entry")
    public String entry(@RequestParam("cons") String cons) {
        String returnUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3b7ee58a475d50d5&redirect_uri=http://wchat.i-emt.com/wechat/order/pay&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        log.info(returnUrl);
        log.info(cons);
        String redirectUrl = returnUrl.replace("STATE", cons);
        log.info(returnUrl);
        log.info(redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/pay")
    @ResponseBody
    public String pay(
            @RequestParam("code") String code,
            @RequestParam("state") String cons
    ) {
        log.info(code);
        log.info(cons);
       /* log.info(con);*/
        return cons;
    }

}
