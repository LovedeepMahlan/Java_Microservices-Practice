package jdbconnection;

import java.sql.*;


public class MakeConnection2 {
/*private static FileInputStream fis=null;
private static Properties properties=null;
String add="D:\\octoberbatch\\src\\jdbconnection\\database.properties";static {
	try {
		fis=new FileInputStream("add");
		if(fis!=null) {
			properties=new Properties();
			properties.load(fis);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
public static  Connection GetConnection() throws SQLException {
	Connection connection=null;
	String Db="jdbc:mysql://localhost:3306/apple";
	String username="root";
	String password="mysql#123";
		connection= DriverManager.getConnection(Db,username,password);
	
	return connection;
	
}
public static void cleanTheCode(ResultSet rs,Statement stmt,Connection connection) {
	if(rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}if(stmt!=null) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}if(connection!=null) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
