package jdbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public final class MakeConnection_1 {
private MakeConnection_1() {}
private static Properties properties=null;
static {
	FileInputStream  fis=null;
	String path="D:\\Nitin_Projects\\MyJDBCAPI\\src\\jdbconnection\\database.properties";
	try {
		fis=new FileInputStream(path);
		if(fis!=null) {
		properties=new Properties();
		properties.load(fis);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	public static Connection dbConnection() throws SQLException {
		String dbProtocol=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		return DriverManager.getConnection(dbProtocol,username,password);
	}
	public static void cleanobject(ResultSet re, Statement stmt,Connection con) {
		if(re!=null) {
			
			try {
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
	}
