package in.pwskills.nitin.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InsauracnePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;

}
