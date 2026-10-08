package jdbconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;



public class JDBC3_6 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		Connection con=null;
		Statement stmt=null;
		ResultSet re=null;
		
		try {
			String add="D:\\octoberbatch\\src\\jdbconnection\\database.properties";
			fis=new FileInputStream(add);
			Properties pro=new Properties();
			pro.load(fis);
		
			String dbProtocol=pro.getProperty("url");
			String username=pro.getProperty("username");
			String password="mysql#123";
			con=DriverManager.getConnection(dbProtocol,username,password);
		
		System.out.println("Connection is established to ::"+dbProtocol);
		System.out.println("Connection :: "+con.getClass().getName());
		stmt=con.createStatement();
		System.out.println("\nStatement Object got created...");
		System.out.println("Statement :: "+stmt.getClass().getName());
		String selectQuary="Select sid,sname,sage,saddress from student";
		re=stmt.executeQuery(selectQuary);
		System.out.println("\nResultSet Object got created...");
		System.out.println("ResultSet :: "+re.getClass().getName());
		while(re.next()) {
			int sid=re.getInt(1);
			String sname=re.getString(2);
			int sage=re.getInt(3);
			String saddress=re.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddress);
		
		}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		if(fis!=null) {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	}
}
