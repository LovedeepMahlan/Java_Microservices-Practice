package jdbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;


public final class MakeConnection3 {
	private MakeConnection3() {}
private static Properties properties=null;
static {
	FileInputStream  fis=null;
	String add="D:\\octoberbatch\\src\\jdbconnection\\database.properties";
	try {
		fis=new FileInputStream(add);
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
	public static Connection getMysqldbConnection() throws SQLException {
		MysqlConnectionPoolDataSource dataSource=new MysqlConnectionPoolDataSource();
		dataSource.setURL(properties.getProperty("url"));
		dataSource.setUser(properties.getProperty("username"));
		dataSource.setPassword(properties.getProperty("password"));
		return dataSource.getConnection();
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
