package in.pwskills.nitin.main;

import in.pwskills.nitin.dao.StudentInterfImpl;

public class MainClass {

	public static void main(String[] args) {
		StudentInterfImpl impl=new StudentInterfImpl();
		impl.loadRecordUsingParent();
	}

}
