package jdbconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Isolation_24 {
public static void main(String[] args) {
	try(Connection connection=MakeConnection_1.dbConnection()){
		System.out.println(connection.getTransactionIsolation());
		connection.setTransactionIsolation(8);
		System.out.println(connection.getTransactionIsolation());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
