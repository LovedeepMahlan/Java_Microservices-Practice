package jdbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Transaction_21 {
public static Connection connection =null;
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	
	if(connection!=null) {
		try(Statement stmt = connection.createStatement()){
			if(stmt!=null) {
				try(ResultSet rs=stmt.executeQuery("select * from transection")){
					while(rs.next()) {
						System.out.println(rs.getString(1)+"  "+rs.getInt(2));
					}
				}
				/* Transection Started */
				System.out.println();
				stmt.executeUpdate("update transection set Balance=Balance-1000 where name='Lovedeep'");
				stmt.executeUpdate("update transection set Balance=Balance+1000 where name='Nitin'");
			System.out.println();
			Scanner sc=new Scanner(System.in);
			System.out.println("if you want to perform the Query then press 1 else press 0");
			int choice=sc.nextInt();
			connection.setAutoCommit(false);
			if(choice==1) {
				connection.commit();
			}else {
				connection.rollback();
			}
			//Transection ended
			try(ResultSet rs=stmt.executeQuery("select * from transection")){
				while(rs.next()) {
					System.out.println(rs.getString(1)+"  "+rs.getInt(2));
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
