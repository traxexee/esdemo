package com.emt.msg.service;

import com.emt.msg.params.SmsParam;

/**
 * @Author:刘震
 * @Description: 短信消息
 * @Date: Created in14:12 2020/3/18.
 * @Modified By:
 */
public interface SmsService {
    void SendSimpleMsg(SmsParam smsParam);

}
