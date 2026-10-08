package in.pwskills.nitin.bean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Doctor_M2M_AssociationMapping")
public class Doctor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctId;
	private String doctName;
	private String hospital;
	
	@ManyToMany(targetEntity =Patient.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "doctor")
	private Set<Patient> patient;
	
	public Integer getDoctId() {
		return doctId;
	}
	public Set<Patient> getPatient() {
		return patient;
	}
	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}
	public void setDoctId(Integer doctId) {
		this.doctId = doctId;
	}
	public String getDoctName() {
		return doctName;
	}
	public void setDoctName(String doctName) {
		this.doctName = doctName;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	@Override
	public String toString() {
		return "Patient [doctId=" + doctId + ", doctName=" + doctName + ", hospital=" + hospital + "]";
	}
	
}
