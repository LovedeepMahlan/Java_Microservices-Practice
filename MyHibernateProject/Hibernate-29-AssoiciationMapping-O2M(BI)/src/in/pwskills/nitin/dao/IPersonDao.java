package in.pwskills.nitin.dao;

public interface IPersonDao {
	public void saveRecordUsingParent();
	public void addChildToExistingParent();
	
	//performing select operation using parent
	public void loadRecordUsingParent();
	
	//delete operations using parent
	public void deleteAllChildsOfAParent();
	public void deleteOneChildFromCollectionofChildsOfAParent();
	public void deleteParentAndItsChilds();
}
