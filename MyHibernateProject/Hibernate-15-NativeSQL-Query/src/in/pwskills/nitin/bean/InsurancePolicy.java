package in.pwskills.nitin.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="insurance_policy")
@NamedNativeQuery(name="DeleteQuery",query = "delete from InsurancePolicy where company=:comp")
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	@Column(name="pname")
	private String policyName;
	@Column(name="ptype")
	private String policyType;
	@Column(name="pcompany")
	private String company;
	@Column(name="ptenure")
	private Integer tenure;
	
	static {
		System.out.println("Hibernate-> Loading InsurancePolicy.class file...");
	}

	public InsurancePolicy() {
		System.out.println("Hibernate-> InsurancePolicy Object created using Zero param constructor...");
	}
	
	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}

}
