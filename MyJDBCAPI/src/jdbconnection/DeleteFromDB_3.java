package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteFromDB_3 {

	private DeleteFromDB_3() {}

	public static void main(String[] args) {
		Statement stmt = null;
		Connection con=null;
		int rowcount=0;
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the sid");
			int sid=sc.nextInt();
			final String SQLUpdate_Quary="delete from student where sid= "+sid;
			System.out.println(SQLUpdate_Quary);
			con=MakeConnection_1.dbConnection();
			if(con!=null) 
				stmt=con.createStatement();
			if(stmt!=null) 
				rowcount=stmt.executeUpdate(SQLUpdate_Quary);
			if(rowcount==0) {
				System.out.println("You have no row to delete ");
			}else {
				System.out.println("deletion is updated successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, stmt, con);
		}
	}

}
