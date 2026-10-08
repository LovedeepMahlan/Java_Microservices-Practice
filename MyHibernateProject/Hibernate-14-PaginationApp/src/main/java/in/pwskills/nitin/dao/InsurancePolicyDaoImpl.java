package in.pwskills.nitin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.InsurancePolicy;
import in.pwskills.nitin.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao{
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public long getTotalRecordsCount() {
		Session session=HibernateUtil.getSession();
		Query query=session.getNamedQuery("Total_noOfEntity");
		List<Long> list=query.getResultList();
		return list.get(0);
	}

	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		Session session=HibernateUtil.getSession();
		Query query=session.getNamedQuery("Total_Selection");
		query.setFirstResult(startPos);
		query.setMaxResults(pageSize);
		List<InsurancePolicy> list=query.getResultList();
		return list;
		
	}
}
