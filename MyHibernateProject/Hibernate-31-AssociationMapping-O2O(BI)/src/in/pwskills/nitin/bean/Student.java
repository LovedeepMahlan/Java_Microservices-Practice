package in.pwskills.nitin.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Student_O2O_BI")
public class Student implements Serializable{
	
	public LiberaryMembership getLibmem() {
		return libmem;
	}
	public void setLibmem(LiberaryMembership libmem) {
		this.libmem = libmem;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sno;
	private String sname;
	private String saddress;
	
	@OneToOne(targetEntity = LiberaryMembership.class,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="sno" ,referencedColumnName = "S_no")
	private LiberaryMembership libmem;
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
}
