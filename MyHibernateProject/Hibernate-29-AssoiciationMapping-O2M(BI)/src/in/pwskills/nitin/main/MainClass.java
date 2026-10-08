package in.pwskills.nitin.main;

import in.pwskills.nitin.dao.IPersonDao;
import in.pwskills.nitin.dao.IPersonDaoImpl;

public class MainClass {

	public static void main(String[] args) {
		IPersonDao obj=new IPersonDaoImpl();
		obj.deleteParentAndItsChilds();
	}

}
