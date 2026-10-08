package in.compney.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MakeConnection {
	static String path="D:\\Nitin_Projects\\MyAllProjects\\MVCRUDJSP\\src\\main\\java\\in\\compney\\utility\\HikariProp.properties";
	private static HikariDataSource datasource=null;
	static {
		HikariConfig config=new HikariConfig(path);
		datasource=new HikariDataSource(config);
	}
	public static Connection getConnection() throws SQLException {
		
		return datasource.getConnection();
	}
	public static void CleanCode(Connection con,Statement stmt,ResultSet rs) {
		try {
			con.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
