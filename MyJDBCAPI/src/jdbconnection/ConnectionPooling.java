package jdbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPooling {
public static void main(String[] args) {
	try(Connection connection=MakeConnection3.getMysqldbConnection()){
		try(Statement stmt=connection.createStatement()){
			try(ResultSet rs=stmt.executeQuery("select * from worker")){
				System.out.println("worker id     Worker name     worker sallary");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+"  "+rs.getInt(3));
				}
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
