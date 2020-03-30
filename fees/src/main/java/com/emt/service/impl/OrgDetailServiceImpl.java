package com.emt.service.impl;

import java.util.List;

import com.emt.model.p.OrgDetail;
import com.emt.param.FeeParam;
import com.emt.repository.p.OrgDetailRepository;
import com.emt.service.OrgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * @author 刘震
 * @date 2018年12月26日 下午1:02:49
 */
@Service
public class OrgDetailServiceImpl implements OrgDetailService {
    @Autowired
    private OrgDetailRepository orgDetailRepository;

    @Override
    public List<OrgDetail> findAllByMchId(String mchId) {

        return orgDetailRepository.findAllByMchId(mchId);
    }

  /*  @Override
    public List<OrgDetail> findAllByMchIdAndBillDate(String mchid, String billDate) {

        return orgDetailRepository.findAllByMchIdAndBillDate(mchid, billDate);
    }*/

    @Override
    public List<OrgDetail> findOneByMchIdAndBillDate(String mchid, String billDate) {

        String wxBillNo = orgDetailRepository.searchWxBillNoByMchIdAndBillDate(mchid, billDate);
        List<OrgDetail> orgs = orgDetailRepository.findAllByWxBillNo(wxBillNo);
        if (orgs != null && orgs.size() > 0) {
            List<OrgDetail> orgss = orgDetailRepository.findAllByPaymentAmountAndMchIdAndWxBillNo(orgs.get(0).getPaymentAmount(),
                    orgs.get(0).getMchId(), wxBillNo);
            orgs.addAll(orgss);
        }
        return orgs;
    }

    @Override
    public List<OrgDetail> findAllByAccountType(String accountType) {
        // TODO Auto-generated method stub
        return orgDetailRepository.findAllByAccountType(accountType);
    }

    @Override
    public List<OrgDetail> findAllByFeeParam(FeeParam feeParam) {
        // TODO Auto-generated method stub
      Page<OrgDetail> orgDetails= orgDetailRepository.findByAccountType(feeParam.getAccountType(),new PageRequest(feeParam.getStart(),feeParam.getLength()));
        return orgDetails.getContent();
    }

    @Override
    public Integer countByFeeParam(FeeParam feeParam) {
        // TODO Auto-generated method stub
        Page<OrgDetail> orgDetails= orgDetailRepository.findByAccountType(feeParam.getAccountType(),new PageRequest(feeParam.getStart(),feeParam.getLength()));
        return orgDetails.getTotalPages();
    }
}
