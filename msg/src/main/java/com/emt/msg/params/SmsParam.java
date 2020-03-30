package com.emt.msg.params;

import lombok.Data;

/**
 * @Author:刘震
 * @Description: 发送短信所需要的参数
 * @Date: Created in14:15 2020/3/18.
 * @Modified By:
 */
@Data
public class SmsParam {
    private String phone;
    private Integer templateId;
    private String[] param;
}
