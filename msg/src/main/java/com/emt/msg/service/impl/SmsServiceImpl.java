package com.emt.msg.service.impl;

import com.emt.msg.params.SmsParam;
import com.emt.msg.service.SmsService;
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
 * @Date: Created in14:16 2020/3/18.
 * @Modified By:
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void SendSimpleMsg(SmsParam smsParam) {
        try {
          //  String[] params = {"1234567890","0.47","500"};
            SmsSingleSender ssender = new SmsSingleSender(1400143497, "382e8eeba1f0839d85fe72a11c5a9329");
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
