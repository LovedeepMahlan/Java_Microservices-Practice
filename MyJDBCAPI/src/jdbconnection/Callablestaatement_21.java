package jdbconnection;

import java.sql.*;
import java.util.Scanner;

public class Callablestaatement_21 {
private static final String Stored_Procedure ="{call GetEmployeeDetailsByEID(?,?,?,?)}";
private static Connection connection=null;
static {
	try {
		connection = MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the employee id");
	int a=sc.nextInt();
	try(CallableStatement calstmt=connection.prepareCall(Stored_Procedure)){
		//Setting the input parameter
		calstmt.setInt(1,a);
		/* TYPES is use to convert Data types of java into data types of DataBase*
		 * TYPES.INTEGER
		 * TYPES.FLOAT etc*/
		//Setting the output parameter
		calstmt.registerOutParameter(2, Types.VARCHAR);

		calstmt.registerOutParameter(3, Types.VARCHAR);
		
		calstmt.registerOutParameter(4, Types.VARCHAR);
		calstmt.execute();
		System.out.println(calstmt.getString(2));
		System.out.println(calstmt.getString(3));
		System.out.println(calstmt.getString(4));
	}catch(SQLException s) {
		s.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	MakeConnection_1.cleanobject(null, null, connection);
}
}
