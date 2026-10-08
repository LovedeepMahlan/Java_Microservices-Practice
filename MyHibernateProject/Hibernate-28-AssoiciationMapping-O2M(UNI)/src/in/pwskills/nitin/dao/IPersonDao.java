package in.pwskills.nitin.dao;

public interface IPersonDao {
	public void saveRecordUsingParent();
	public void saveRecordUsingChild();
	
	//performing select operation using parent
	public void loadRecordUsingParent();
	
	//delete operations using parent
	public void loadRecordUsingChild();
	
}
