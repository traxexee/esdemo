package com.emt.service.impl;

import com.emt.constant.StateConstant;
import com.emt.model.p.OrgFee;
import com.emt.repository.p.OrgFeeRepository;
import com.emt.service.OrgFeeService;
import com.emt.service.OrgService;
import com.emt.vo.DataList;
import com.emt.vo.OrgFeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 刘震
 * @date 2018年12月6日 下午3:49:18
 */
@Service
public class OrgFeeServiceImpl implements OrgFeeService {
    @Autowired
    private OrgFeeRepository orgFeeRepository;

    @Autowired
    private OrgService orgService;

    @Override
    public List<OrgFee> searchByOrgId(Integer orgId) {

        return orgFeeRepository.findAllByOrgIdOrderByBillDate(orgId);
    }

    @Override
    public OrgFee updateRemarkById(Integer id, String remark) {
        OrgFee orgFee = orgFeeRepository.findById(id).get();
        orgFee.setRemark(remark);
        return orgFeeRepository.saveAndFlush(orgFee);
    }

    /*@Override
    public List<OrgFee> searchByState(Integer state) {

        return orgFeeRepository.findAllByState(state);
    }*/

    @Override
    public OrgFee updateStateById(Integer id, Integer state) {
        OrgFee orgFee = orgFeeRepository.findById(id).get();
        orgFee.setState(state);
        return orgFeeRepository.saveAndFlush(orgFee);

    }

    @Override
    public List<OrgFee> searchErrorState() {
        List<OrgFee> orgFees= orgFeeRepository.findAllByStateOrState(StateConstant.basicState, StateConstant.dealState);
        for (OrgFee orgFee:orgFees
             ) {
            orgFee.setOrg(orgService.findOneById(orgFee.getOrgId()));
        }
        return orgFees;
    }

    @Override
    public OrgFeeList findByOrgId(Integer id) {

        OrgFeeList orgFeeList = new OrgFeeList();
        List<Object[]> all =  orgFeeRepository.findBillDateAndFeeOutByOrgId(id);
        List<BigDecimal> feeOut = new ArrayList<>();
        List<String> billDate = new ArrayList<>();
        for (int i = 1; i < all.size(); i++) {
            //TODO 对缺少日期补全
            billDate.add((String) all.get(i)[0]);
            feeOut.add((BigDecimal) all.get(i)[1]);
        }
        orgFeeList.setBillDate(billDate);
        orgFeeList.setFeeOut(feeOut);
        return orgFeeList;
    }

    @Override
    public BigDecimal findMinFeeOutByOrgId(Integer id) {
        return orgFeeRepository.findMinFeeOutByOrgId(id);
    }

    @Override
    public BigDecimal findMaxFeeOutByOrgId(Integer id) {
        return orgFeeRepository.findMaxFeeOutByOrgId(id);
    }

    @Override
    public BigDecimal findAvgFeeOutByOrgId(Integer id) {
        return orgFeeRepository.findAvgFeeOutByOrgId(id);
    }

    @Override
    public DataList findDataByPrivinceId(Integer id) {
        DataList dataList = new DataList();
        List<OrgFee> all = orgFeeRepository.findAllByOrgIdOrderByBillDate(id);
        List<BigDecimal> moneys = new ArrayList<>();
        List<String> times = new ArrayList<>();

        if (all != null) {

            moneys.add(all.get(0).getFeeOut());
            times.add( all.get(0).getBillDate());
            for (OrgFee orgFee: all
                 ) {
                moneys.add(orgFee.getFeeOut());
                times.add(orgFee.getBillDate());
            }
        }
        dataList.setMoneys(moneys);
        dataList.setStrings(times);
        return dataList;

    }

}
