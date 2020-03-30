package com.emt.param;

import lombok.Data;

/** 
 * @author  刘震
 * @date 2018年12月28日 上午11:03:47 
 */
@Data
public class FeeParam {
private String mchId;
private String paymentType;
private String dateMin;
private String dateMax;
private Integer start;
private Integer length;
private String accountType;
}
