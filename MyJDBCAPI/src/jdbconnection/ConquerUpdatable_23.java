package jdbconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConquerUpdatable_23 {
public static void main(String[] args) {
	
	try(Connection con=MakeConnection_1.dbConnection()){
		if(con!=null) {
			try(Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				//if we have to perform this then we have to take the table with not repeatable row;
				if(stmt!=null) {
					try(ResultSet rs=stmt.executeQuery("Select * from employee")){
						System.out.println("eid   ename    eaddress    resume");
						while(rs.next()) {
							System.out.println(rs.getString(1) +"  "+  rs.getString(2)+"  "+  rs.getString(3)+"  "+  rs.getString(4));
						}
						System.out.println();
						System.out.println("Application is in pausable state you can change in database");
						System.in.read();
						rs.beforeFirst();
						while(rs.next()) {
							rs.refreshRow();
							System.out.println(rs.getString(1) +"  "+  rs.getString(2)+"  "+  rs.getString(3)+"  "+  rs.getString(4));
						}
						System.out.println();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
