package com.emt.msg.controller;

import com.emt.msg.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:22 2020/3/18.
 * @Modified By:
 */
@RestController
@RequestMapping("")
public class SmsController {
    @Autowired
    private SmsService smsService;

    public void SendMsg() {
        return;
    }

}
