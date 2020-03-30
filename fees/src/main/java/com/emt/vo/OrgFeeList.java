package com.emt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in13:39 2019/4/14.
 * @Modified By:
 */
@Data
public class OrgFeeList {
    private List<String> billDate;//横坐标
    private List<BigDecimal> feeOut;//值
}
