package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatchQuery_12 {
public static Connection connection;
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
		try(Statement stmt=connection.createStatement()){
			stmt.addBatch("insert into worker(wname,wsallary) values('Sachin',27000)");
			stmt.addBatch("update worker set wsallary =wsallary+100 where wsallary <15000");
			stmt.addBatch("delete from worker where wname='virat'");
			int[] count=stmt.executeBatch();
			int total=0;
			for(int result:count) {
				total+=result;
			}
			System.out.println("Total Query is :: "+total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
