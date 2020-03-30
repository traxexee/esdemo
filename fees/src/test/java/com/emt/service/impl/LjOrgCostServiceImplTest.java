package com.emt.service.impl;

import com.emt.constant.SmsConstant;
import com.emt.param.SmsParam;
import com.emt.service.SendMsgService;
import com.emt.vo.LongJiangMsg;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in14:23 2020/3/24.
 * @Modified By:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LjOrgCostServiceImplTest {
@Autowired
private LjOrgCostServiceImpl ljOrgCostService;
    @Autowired
    private SendMsgService sendMsgService;
    @Test
    public void totalByBillDate() {

        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date=calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd%");
        String billDate=    formatter.format(date);
        log.info("龙江交易概况通知,{}",billDate);
        SmsParam smsParam = new SmsParam();
        smsParam.setPhone(SmsConstant.zhen);
        smsParam.setTemplateId(560821);


        LongJiangMsg longJiangMsg=  ljOrgCostService.totalByBillDate(billDate);
       smsParam.setParam(new String[]{ billDate,longJiangMsg.getAllFee(),longJiangMsg.getAllNum().toString(), longJiangMsg.getGuoFee(),longJiangMsg.getGuoNum().toString(),longJiangMsg.getNongFee(),longJiangMsg.getNongNum().toString()});
       sendMsgService.SendSimpleMsg(smsParam);
    }
}