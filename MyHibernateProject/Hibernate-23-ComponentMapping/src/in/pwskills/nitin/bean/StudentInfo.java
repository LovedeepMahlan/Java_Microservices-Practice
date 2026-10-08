 package in.pwskills.nitin.bean;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Info")
public class StudentInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("StudentInfo.class is Loading");
	}
	
	public StudentInfo() {
		System.out.println("StudentInfo class is initializing");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private Float avg;
	
	@Embedded
	private Address address;

	@Override
	public String toString() {
		return "StudentInfo [sid=" + sid + ", sname=" + sname + ", avg=" + avg + ", address=" + address + "]";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	public StudentInfo( String sname, Float avg,Address address) {
		super();
		this.address=address;
		this.sname = sname;
		this.avg = avg;
		System.out.println("Instance od class is creating");
	}
}
