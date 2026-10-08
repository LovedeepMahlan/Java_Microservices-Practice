package jdbconnection;

import java.sql.*;
import java.util.Scanner;

public class PreparedStmt_7 {
private static final String Insert_value="insert into student values(?,?,?,?)";
private static Connection connection=null;
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	PreparedStatement stmt=null;
	if(connection!=null) {
		try {
			stmt=connection.prepareStatement(Insert_value);
	Scanner sc=new Scanner(System.in);
	if(stmt!=null && sc != null) {
		System.out.println("Enter the sid");
		Integer sid=sc.nextInt();
		System.out.println("Enter the sname");
		String sname=sc.next();
		System.out.println("Enter the sadress");
		String saddress=sc.next();
		System.out.println("Enter the sage");
		Integer sage=sc.nextInt();
		stmt.setInt(1, sid);
		stmt.setString(2,sname);
		stmt.setString(3,saddress);
		stmt.setInt(4, sage);
		int rowCount=stmt.executeUpdate();
        System.out.println(rowCount + " row(s) inserted successfully.");
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		MakeConnection_1.cleanobject(null, stmt, connection);
	}
	
	}
	
	
}
}
