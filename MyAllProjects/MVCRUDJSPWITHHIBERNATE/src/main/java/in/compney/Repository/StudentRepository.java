package in.compney.Repository;

import in.compney.dataObjects.StudentBO;

public interface StudentRepository {
	public String InsertRecord(StudentBO stdbo);
	public StudentBO readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentBO stdbo);
	}
