package com.emt.service.impl;

import java.util.Date;
import java.util.List;

import com.emt.config.UrlConfig;
import com.emt.constant.ProvinceConstant;
import com.emt.model.p.Org;
import com.emt.repository.p.OrgRepository;
import com.emt.service.OrgService;
import com.emt.utils.HttpRequest;
import com.emt.utils.MyDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;


/** 
 * @author  刘震
 * @date 2018年12月6日 上午9:40:33 
 */
@Slf4j
@Service
public class OrgServiceImpl implements OrgService {
	@Resource
private OrgRepository orgRepository;
	@Resource
	private EntityManagerFactory entityManagerFactory;
	public Date getMaxCreatetime(){
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Date> cq = cb.createQuery(Date.class); //查询结果

//在哪个表查
		Root<Org> root = cq.from(Org.class);
		cq.select(cb.greatest((Path)root.get("lastUpdateTime")));

//结果
		TypedQuery<Date> typedQuery = em.createQuery(cq);
		return typedQuery.getSingleResult();

	}

@Override
public List<Org> getAllOrg() {
	// TODO Auto-generated method stub


	return orgRepository.findAll();
}

@Override
public Org findOneById(Integer id) {
	// TODO Auto-generated method stub
	return orgRepository.findById(id).get();
}

	@Override
	public List<Org> getProvinceOrg() {
		return orgRepository.findAllByParProvinceId(ProvinceConstant.PROVINCE_ID);
	}

	@Override
	public List<Org> getOrgByProvinceId(Integer id) {

		List<Org> orgs=orgRepository.findAllByParProvinceId(id);
		if(orgs.size()==0){
			log.info("id:{}下没有市县了",id);
		Org org=orgRepository.findOneById(id);
			log.info("naem：{}下没有市县了",org.getName());
		org.setParProvinceId(-1);//
		orgs.add(org);
		}
		return orgs;

	}

	@Override
public Date searchMinTime() {

	return orgRepository.searchMinTime();
}
@Async
@Override
public void refresh() {
	// TODO Auto-generated method stub
	HttpRequest.sendGet(UrlConfig.url.replace("billDate", MyDateUtil.getBeforeDate()));
}


}
