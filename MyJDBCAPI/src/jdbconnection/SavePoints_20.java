package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoints_20 {
public static void main(String[] args) {
	try(Connection con=MakeConnection_1.dbConnection()){
		if(con!=null) {
			try(Statement stmt=con.createStatement()){
				/* SavePoint is use when you have to not pass some Query then we can Stop them in this 
				 * example we annot add to Sidhu becuse of some reason
				 * so here we use SavePoint 
				 */
				con.setAutoCommit(false);
				stmt.executeUpdate("insert into politicians(`name`,`party`) values('Modi' ,'BJP')");
				stmt.executeUpdate("insert into politicians(`name`,`party`) values('Rahul' ,'Congress')");
				Savepoint sp = con.setSavepoint();
				
				stmt.executeUpdate("insert into politicians(`name`,`party`) values('Sidhu' ,'BJP')");
				System.out.println("some error has been occured you have to retrive the query");
				con.rollback(sp);
				con.commit();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
