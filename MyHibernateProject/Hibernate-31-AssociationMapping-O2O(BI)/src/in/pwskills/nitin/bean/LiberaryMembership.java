package in.pwskills.nitin.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LiberaryMembership_O2O_BI")
public class LiberaryMembership implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lid;
	private String type;
	private LocalDate date;
	
	@OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL,mappedBy = "libmem")
	
	private Student student;
	@Override
	public String toString() {
		return "LiberaryMembership [lid=" + lid + ", type=" + type + ", date=" + date + "]";
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getType() {
		return type;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
