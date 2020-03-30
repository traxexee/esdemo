package com.emt.controller;

import com.emt.constant.SmsConstant;
import com.emt.model.p.Org;
import com.emt.param.SmsParam;
import com.emt.service.OrgCostService;
import com.emt.service.OrgService;
import com.emt.service.SendMsgService;
import com.emt.service.impl.LjOrgCostServiceImpl;
import com.emt.vo.LongJiangMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:59 2019/11/27.
 * @Modified By:
 */
@Component
@Slf4j
public class ScheduledTasks {
    @Autowired
    private LjOrgCostServiceImpl lgorgCostService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private SendMsgService sendMsgService;

    //每隔30分钟执行一次
    @Scheduled(cron = "0 0/30 * * * ?")
    public void putData() {
        log.info("查询龙江手续费使用情况");
        lgorgCostService.refreshOrgCost();
    }

    @Scheduled(cron = "0 0 15 * * ?")
    public void sendMsg() {
        log.info("龙江手续费不足提醒");
        //提醒策略 安全系数小于0.5 或预计余额小于200
        List<Org> provinceOrgs = orgService.getProvinceOrg(); //获得省份的手续费剩余情况
        provinceOrgs.forEach(org -> {
            BigDecimal forecast = org.getOrgCost().getForecast();
            //预计今天剩余
            BigDecimal yu = org.getFee().subtract(forecast);
//安全系数
            BigDecimal anquan = org.getFee().subtract(forecast).divide(org.getFee(), 4, RoundingMode.HALF_UP);
            if (anquan.compareTo(new BigDecimal("0.5")) == -1) {
                SmsParam smsParam = new SmsParam();
                smsParam.setPhone(SmsConstant.phone);
                smsParam.setTemplateId(557253);
                smsParam.setParam(new String[]{org.getMchId(), anquan.toString(), yu.toString()});
                sendMsgService.SendSimpleMsg(smsParam);
            } else if (yu.compareTo(new BigDecimal("200")) == -1) {
                SmsParam smsParam = new SmsParam();
                smsParam.setPhone(SmsConstant.phone);
                smsParam.setTemplateId(557253);
                smsParam.setParam(new String[]{org.getMchId(), anquan.toString(), yu.toString()});
                sendMsgService.SendSimpleMsg(smsParam);
            }

        });

    }

    //@Scheduled(cron = "* 0/1 * * * ?")
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendToTalMsg() {

        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date=calendar.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd%");
        String billDate=    formatter.format(date);
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM月dd日");
        String d =formatter1.format(date);
        log.info("龙江交易概况通知,{}",billDate);
        SmsParam smsParam = new SmsParam();
        smsParam.setPhone(SmsConstant.tong);
        smsParam.setTemplateId(560821);

      LongJiangMsg longJiangMsg=  lgorgCostService.totalByBillDate(billDate);
        smsParam.setParam(new String[]{ d, longJiangMsg.getGuoNum().toString(),longJiangMsg.getGuoFee(),longJiangMsg.getNongNum().toString(),longJiangMsg.getNongFee(),longJiangMsg.getAllNum().toString(),longJiangMsg.getAllFee()});
        sendMsgService.SendSimpleMsg(smsParam);

    }

    public static void main(String[] args) {
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        date=calendar.getTime();
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM月dd日");
        String d =formatter1.format(date);
        System.out.println(d);
    }

}
