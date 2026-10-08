package in.pwskills.nitin.bean;

import java.io.Serializable;


public class PersonInfo  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String pname;
	
	private String paddr;

	
	static {
		System.out.println("HIBERNATE LOADS .CLASS FILE...");
	}

	public PersonInfo() {
		System.out.println("HIBERNATE CREATES OBJECT :: ZERO PARAM CONSTRUCTOR...");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddr() {
		return paddr;
	}

	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}

	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", pname=" + pname + ", paddr=" + paddr + "]";
	}

}
