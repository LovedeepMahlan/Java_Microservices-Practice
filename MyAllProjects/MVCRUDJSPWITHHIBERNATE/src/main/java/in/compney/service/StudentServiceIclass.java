package in.compney.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import in.compney.Repository.StudentRepository;
import in.compney.dataObjects.StudentBO;
import in.compney.dataObjects.StudentDTO;
import in.compney.factory.StudentRepofactory;

public class StudentServiceIclass implements StudentService{
	
	@Override
	public String InsertRecord(StudentDTO stddto) {
		StudentBO stdbo=new StudentBO();
		System.out.println(stddto);
		stdbo.setSname(stddto.getSname());
		stdbo.setSage(stddto.getSage());
		stdbo.setSaddress(stddto.getSaddress());
		System.out.println("SENDING BO OBJECT TO REPO LAYER");
		StudentRepository studrepo=StudentRepofactory.getStudeRepo();
		System.out.println(stdbo);
		return studrepo.InsertRecord(stdbo);
		
	}

	@Override
	public StudentDTO readRecord(Integer id) {
		StudentDTO stddto=null;
		StudentBO stdbo=null;
		StudentRepository repository=StudentRepofactory.getStudeRepo();
		stdbo=repository.readRecord(id);
		if(stdbo==null) {
			return stddto;
		}else {
			stddto=new StudentDTO();
			try {
				BeanUtils.copyProperties(stddto, stdbo);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stddto;
		}
	}

	@Override
	public String deleteRecord(Integer id) {
		String status=null;
		StudentRepository repository=null;
		repository=StudentRepofactory.getStudeRepo();
		status=repository.deleteRecord(id);
		return status;
	}

	@Override
	public String updateRecord(StudentDTO stddto) {
		String status=null;
		StudentBO stdbo=null;
		StudentRepository repository=null;
		try {
			stdbo=new StudentBO();
			BeanUtils.copyProperties(stdbo, stddto);
			repository=StudentRepofactory.getStudeRepo();
			status=repository.updateRecord(stdbo);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	

}
