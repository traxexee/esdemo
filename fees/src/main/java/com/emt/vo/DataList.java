package com.emt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in17:04 2019/4/11.
 * @Modified By:
 */
@Data
public class DataList {
    private List<BigDecimal> nums;
    private List<BigDecimal> moneys;
    private List<Date> times;
    private List<String> strings;
}
