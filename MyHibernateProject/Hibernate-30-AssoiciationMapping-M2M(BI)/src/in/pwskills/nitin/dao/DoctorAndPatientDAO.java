package in.pwskills.nitin.dao;

public interface DoctorAndPatientDAO {
	//performing insert operation using parent
		public void saveRecordUsingParent();
		public void saveRecordUsingChild();
		//performing select operation using parent
		public void loadRecordUsingParent();
		public void loadRecordUsingChild();
}
