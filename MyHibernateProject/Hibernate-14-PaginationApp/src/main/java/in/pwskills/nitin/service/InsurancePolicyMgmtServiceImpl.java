package in.pwskills.nitin.service;

import java.util.ArrayList;
import java.util.List;

import in.pwskills.nitin.bean.InsurancePolicy;
import in.pwskills.nitin.bean.InsurancePolicyDTO;
import in.pwskills.nitin.dao.InsurancePolicyDao;
import in.pwskills.nitin.dao.InsurancePolicyDaoImpl;

public class InsurancePolicyMgmtServiceImpl implements InsurancePolicyManagementService{
	InsurancePolicyDao dao=null;
	public InsurancePolicyMgmtServiceImpl() {

	dao=new InsurancePolicyDaoImpl();
	}
	@Override
	public long fetchPagesCount(int pageSize) {
		long recordsCount=dao.getTotalRecordsCount();
		long pagecount=recordsCount/pageSize;
		if(recordsCount%pageSize!=0) {
			pagecount++;
		}
		return pagecount;
	}
	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		List<InsurancePolicyDTO> listdto=new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicy> entities=null;
		int startpos=0;
		startpos=(pageNo*pageSize-pageSize);
		entities=dao.getPageData(pageSize, startpos);
		
		entities.forEach(entity->{
			InsurancePolicyDTO dto=new InsurancePolicyDTO();
			
			dto.setCompany(entity.getCompany());
			dto.setPolicyId(entity.getPolicyId());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenure(entity.getTenure());
			dto.setSerialNo(listdto.size()+1);
			listdto.add(dto);
		});
		return listdto;
	}

}
