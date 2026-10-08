package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertQuaryInJDBC_2 {

	private InsertQuaryInJDBC_2() {}

	public static void main(String[] args) {
		Statement stmt = null;
		Connection con=null;
		int rowcount=0;
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid");
			int sid=sc.nextInt();
			System.out.println("enter the sname");
			String sname=sc.next();
			System.out.println("enter the sage");
			int sage=sc.nextInt();
			System.out.println("Enter the saddress");
			String saddress=sc.next();
			final String SQLInsert_Quary="insert into student values("+sid+",'"+sname+"','"+saddress+"',"+sage+")";
			System.out.println(SQLInsert_Quary);
			con=MakeConnection_1.dbConnection();
			if(con!=null) 
				stmt=con.createStatement();
			if(stmt!=null) 
				rowcount=stmt.executeUpdate(SQLInsert_Quary);
			if(rowcount==0) {
				System.out.println("You re unable to insert qurary");
			}else {
				System.out.println("Qury is updated successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, stmt, con);
		}
	}

}
