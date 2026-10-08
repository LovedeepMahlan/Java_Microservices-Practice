package jdbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionByStatement_19 {
private static final String Select_Quary = "select count(*) from employee where eid=1-- and ename='Annu'";
private static Connection connection =null;
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}/* in statement if e write wrong password also it gives proper credential statement is sqlInjection Causable */
public static void main(String[] args) throws SQLException {
	Statement stmt=null;
	ResultSet rs=null;
	if(connection!=null) {
		stmt=connection.createStatement();
	}
	if(stmt!=null) {
		rs=stmt.executeQuery(Select_Quary);
	}int count=0;
	if(rs.next()) {
		count=(rs.getInt(1));
		if(count==1) {
			System.out.println("your credential is proper");
		}else {
			System.out.println("sorry your credential is not proper");
		}
	}
	MakeConnection_1.cleanobject(rs, stmt, connection);
	}
}
