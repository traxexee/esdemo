package com.emt.controller;

import java.util.List;
import java.util.Map;

import com.emt.constant.AccountTypeConstant;
import com.emt.model.p.OrgDetail;
import com.emt.param.FeeParam;
import com.emt.service.OrgDetailService;
import com.emt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘震
 * @date 2018年12月26日 下午12:56:39
 */
@Slf4j
@RequestMapping("/orgDetail")
@RestController
public class OrgDetailController {
	@Autowired
	private OrgDetailService orgDetailService;

	@GetMapping("/mchId/{mchId}")
	public ModelAndView page(ModelAndView modelAndView, @PathVariable("mchId") String mchId) {

		modelAndView.setViewName("/page/org/orgDetail");
		List<OrgDetail> orgDetails = orgDetailService.findAllByMchId(mchId);
		modelAndView.addObject("orgDetails", orgDetails);
		return modelAndView;
	}
	@GetMapping("/mchId/{mchId}/billDate/{billDate}/id/{id}")
	public ModelAndView page(ModelAndView modelAndView, @PathVariable("mchId") String mchId,@PathVariable("billDate") String billDate,@PathVariable("id") String id) {
		modelAndView.setViewName("/page/org/accountDetail");
		List<OrgDetail> orgDetails = orgDetailService.findOneByMchIdAndBillDate(mchId, billDate);
		modelAndView.addObject("orgDetails", orgDetails);
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	@GetMapping("/error")
	public ModelAndView page(ModelAndView modelAndView) {

		//查询异常提现的
		
		
		
		return modelAndView;
	}
	@GetMapping("/fee")
	public ModelAndView pageFee(ModelAndView modelAndView) {

		//查询异常提现的
		
		modelAndView.setViewName("/page/org/feeList");
		List<OrgDetail> orgDetails = orgDetailService.findAllByAccountType(AccountTypeConstant.fee);
		modelAndView.addObject("orgDetails", orgDetails);

		return modelAndView;
	}
	

	  @GetMapping("/fee/getList")
	    public Map<String, Object> getList(FeeParam feeParam, int start , int length) {
		   log.info("start:{},length:{}",start, length);
		   feeParam.setLength(length);
		   feeParam.setStart(start);
		   feeParam.setAccountType(AccountTypeConstant.fee);
	        List<OrgDetail> feeList= orgDetailService.findAllByFeeParam(feeParam);
	    
	        Integer num =orgDetailService.countByFeeParam(feeParam);
	        return ResultUtil.datatable(feeList, num);
	    }
}
