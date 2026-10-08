package jdbconnection;

import java.sql.*;



public class JDBC2_5 {
	public static void main(String[] args)throws Exception {
		Connection con=MakeConnection_1.dbConnection();
		Statement stmt=con.createStatement();
		System.out.println("\nStatement Object got created...");
		System.out.println("Statement :: "+stmt.getClass().getName());
		String selectQuary="Select sid,sname,sage,saddress from student";
		ResultSet re=stmt.executeQuery(selectQuary);
		System.out.println("\nResultSet Object got created...");
		System.out.println("ResultSet :: "+re.getClass().getName());
		while(re.next()) {
			int sid=re.getInt(1);
			String sname=re.getString(2);
			int sage=re.getInt(3);
			String saddress=re.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddress);
		
		}
		re.close();	
		stmt.close();
		con.close();
	}

}
