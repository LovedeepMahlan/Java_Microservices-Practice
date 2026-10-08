package in.pwskills.nitin.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
@Entity
@Table(name="Employee_Info")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	public Employee() {
		System.out.println("Employee class is initializiG");
	}
	
	public Employee(String ename, String address, List<String> friends, Set<Long> phoneNumber,
			Map<String, Long> bankAccounts) {
		super();
		this.ename = ename;
		this.address = address;
		this.friends = friends;
		this.phoneNumber = phoneNumber;
		this.bankAccounts = bankAccounts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private String address;
	
	@ElementCollection
	@Column(name="names")
	@CollectionTable(name="Friend_List" ,joinColumns=@JoinColumn(referencedColumnName = "eid", name="emp_id"))
	@OrderColumn(name="f_id")
	@ListIndexBase(value = 1)
	private List<String> friends;
	
	@ElementCollection
	@Column(name="phonenumber")
	@CollectionTable(name="Phone_Number_Set", joinColumns = @JoinColumn(referencedColumnName = "eid",name="emp_id"))
	private Set<Long> phoneNumber;
	
	@ElementCollection
	@Column(name="accNo")
	@CollectionTable(name="EMP_BANK_DETAILS", joinColumns=@JoinColumn(name="emp_id", referencedColumnName="eid"))
	@MapKeyColumn(name="bankName")
	private Map<String,Long> bankAccounts;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", address=" + address + ", friends=" + friends
				+ ", phoneNumber=" + phoneNumber + ", bankAccounts=" + bankAccounts + "]";
	}
	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public Set<Long> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Set<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
