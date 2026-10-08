package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuaryInJDBC_1 {

	private static final String SQLInsert_Quary = "insert into student values(9,'Lara','WI',53)";

	private InsertQuaryInJDBC_1() {}

	public static void main(String[] args) {
		Statement stmt = null;
		Connection con=null;
		int rowcount=0;
		try {
			con=MakeConnection_1.dbConnection();
			if(con!=null) 
				stmt=con.createStatement();
			if(stmt!=null) 
				rowcount=stmt.executeUpdate(SQLInsert_Quary);
			if(rowcount==0) {
				System.out.println("You are unable to insert qurary");
			}else {
				System.out.println("Query is updated successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, stmt, con);
		}
	}
}
