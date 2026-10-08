package in.compney.service;

import in.compney.dataObjects.StudentDTO;

public interface StudentService {
public String InsertRecord(StudentDTO stddto);
public StudentDTO readRecord(Integer id);
public String deleteRecord(Integer id);
public String updateRecord(StudentDTO stddto);
}
