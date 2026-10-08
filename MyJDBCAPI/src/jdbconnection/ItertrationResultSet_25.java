package jdbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItertrationResultSet_25 {
public static void main(String[] args) {
	
	try(Connection con=MakeConnection_1.dbConnection()){
		if(con!=null) {
			try(Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)){
				if(stmt!=null) {
					try(ResultSet rs=stmt.executeQuery("Select * from politicians")){
						System.out.println("name  party");
						while(rs.next()) {
							System.out.println(rs.getString(1) +"  "+  rs.getString(2));
						}
						System.out.println();
						
						while(rs.previous()) {
							System.out.println(rs.getString(1) +"  " +  rs.getString(2));
						}
						System.out.println();
						rs.last();
						System.out.println("At last");
						System.out.println(rs.getString(1) +"  " +  rs.getString(2));
						rs.first();
						System.out.println("At First");
						
						System.out.println(rs.getString(1) +"  " +  rs.getString(2));
						rs.absolute(4);
						System.out.println("At Number 4");
						System.out.println(rs.getString(1) +"  " +  rs.getString(2));
						rs.relative(2);
						System.out.println("At Number 6");
						System.out.println(rs.getString(1) +"  " +  rs.getString(2));
						rs.relative(-2);
						System.out.println("At Number 4");
						System.out.println(rs.getString(1) +"  " +  rs.getString(2));
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
