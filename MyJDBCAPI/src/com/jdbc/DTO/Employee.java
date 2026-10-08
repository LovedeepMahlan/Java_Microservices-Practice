package com.jdbc.DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Employee{
String ename;
int eid;
String eaddress;
String loction;
String resume;

public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getLoction() {
	return loction;
}
public void setLoction(String loction) {
	this.loction = loction;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEaddress() {
	return eaddress;
}
public void setEaddress(String eaddress) {
	this.eaddress = eaddress;
}
public String getResume() {
	return resume;
}
public void setResume(String Location) {
		try {
			FileReader fr = new FileReader(new File(Location));
			BufferedReader br=new BufferedReader(fr);
			resume=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
@Override
public String toString() {
	return "Employee [ename=" + ename + ", eaddress=" + eaddress + ", Resume=" + resume + "]";
}
}
