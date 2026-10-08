package jdbconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateWthoutQuery_last {
public static void main(String[] args) {
	
	try(Connection con=MakeConnection_1.dbConnection()){
		if(con!=null) {
			//Update the table without pass any query by using ResultSet.CONCUR_UPDATABLE
			try(Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				//By this Conque_updatable we can update table without pass the query;
				if(stmt!=null) {
					try(ResultSet rs=stmt.executeQuery("Select * from worker")){
						while(rs.next()) {
						int salary=rs.getInt(3);
						if(salary<15000) {
							rs.updateInt(3,salary+1000);
							rs.updateRow();
						}
					}
						System.out.println("Salary has been updated");
					}
				}
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
