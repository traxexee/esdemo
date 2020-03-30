package com.emt.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:刘震
 * @Description:
 * @Date: Created in14:17 2019/4/11.
 * @Modified By:
 */
@Data
public class Series {
    private String name;
    private String type;
    private String stack;
    private String cursor;
    private List<BigDecimal> data;
}
