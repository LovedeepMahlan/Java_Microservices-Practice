package jdbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBatchByPrepStmt_13 {
private static final String Insert_Query = "insert into worker(wname,wsallary) values(?,?)";
private static Connection connection=null;
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) throws SQLException {
	PreparedStatement stmt=null;
	if(connection!=null) {
		stmt=connection.prepareStatement(Insert_Query);
	}
	Scanner sc=new Scanner(System.in);
	while(true) {
		System.out.println("Enter the worker name");
		String wname=sc.next();
		System.out.println("Enter the worker sallary");
		int wsallary=sc.nextInt();
		stmt.setString(1, wname);
		stmt.setInt(2, wsallary);
		stmt.addBatch();
		System.out.println("Doy you insert any worker if yes then press yes else press no");
		String choice=sc.next();
		if(choice.equalsIgnoreCase("no")) {
			break;
		}
	}
	stmt.executeBatch();
	MakeConnection_1.cleanobject(null, stmt, connection);;
}
}
