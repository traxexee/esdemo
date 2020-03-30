package com.emt.service;

import com.emt.param.SmsParam;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:50 2020/3/18.
 * @Modified By:
 */
public interface SendMsgService {
    void SendSimpleMsg(SmsParam smsParam);
}
