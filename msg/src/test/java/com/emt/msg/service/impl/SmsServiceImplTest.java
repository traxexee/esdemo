package com.emt.msg.service.impl;

import com.emt.msg.service.SmsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in14:45 2020/3/18.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public  class SmsServiceImplTest {
@Autowired
private SmsService smsService;
    @Test
    void sendSimpleMsg() {
    smsService.SendSimpleMsg();
    }
}