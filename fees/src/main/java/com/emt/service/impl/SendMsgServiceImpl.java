package com.emt.service.impl;

import com.emt.constant.SmsConstant;
import com.emt.param.SmsParam;
import com.emt.service.SendMsgService;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in15:52 2020/3/18.
 * @Modified By:
 */
@Service
@Slf4j
public class SendMsgServiceImpl implements SendMsgService {
    @Override
    public void SendSimpleMsg(SmsParam smsParam) {
        try {
            //  String[] params = {"1234567890","0.47","500"};
            SmsSingleSender ssender = new SmsSingleSender(SmsConstant.appId, SmsConstant.appKey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", smsParam.getPhone(),
                    smsParam.getTemplateId(), smsParam.getParam(), "", "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }


}
