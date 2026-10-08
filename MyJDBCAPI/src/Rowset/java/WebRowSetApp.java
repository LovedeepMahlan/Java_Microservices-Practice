package Rowset.java;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetApp {
public static void main(String[] args) {
	/* it is use to write a program in XML code and communicate it to another language*/
	WebRowSet webrowset=null;
	try {
		RowSetFactory factory=RowSetProvider.newFactory();
		webrowset=factory.createWebRowSet();
		webrowset.setUrl("jdbc:mysql:///pwskills_octbatch");
		webrowset.setUsername("root");
		webrowset.setPassword("mysql#123");
		webrowset.setCommand("select * from employee");
		webrowset.execute();
		FileWriter f=new FileWriter("WebXml.txt");
		webrowset.writeXml(f);
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
