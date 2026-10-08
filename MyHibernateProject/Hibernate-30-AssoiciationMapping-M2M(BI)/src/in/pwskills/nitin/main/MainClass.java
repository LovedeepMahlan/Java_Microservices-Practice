package in.pwskills.nitin.main;

import in.pwskills.nitin.dao.Hospital;

public class MainClass {

	public static void main(String[] args) {
		Hospital hos=new Hospital();
		hos.saveRecordUsingParent();
		hos.loadRecordUsingChild();
		
	}

}
