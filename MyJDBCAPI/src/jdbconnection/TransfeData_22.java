package jdbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransfeData_22 {
	//Whole Data Transfer from one bank to another bank.
	private static final String Add_Data = "insert into CaneraBank(`ACCNO`,`holdername`,`Balance`) values(?,?,?)";
	private static final String Retrive_Data = "select * from SyndicateBank";

	public static Connection applecon=null;
	public static Connection pwskillscon=null;
	static {
		try {
			pwskillscon=MakeConnection_1.dbConnection();
			applecon=MakeConnection2.GetConnection();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void main(String[] args) throws SQLException {
	Statement stmt=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	int z=0;
	if(pwskillscon!=null) {
		stmt=pwskillscon.createStatement();
	}
	if(applecon!=null) {
		ps=applecon.prepareStatement(Add_Data);
	}
	if(stmt!=null) {
		rs=stmt.executeQuery(Retrive_Data);
	}
	System.out.println(rs);
	if(ps!=null&& rs!=null) {
		while(rs.next()){
			ps.setInt(1, rs.getInt("SACCNO"));
			ps.setString(2, rs.getString("Sholdername"));
			ps.setInt(3, rs.getInt("Sbalance"));
			z=ps.executeUpdate();
		}
	}
	if(z!=0) {
		System.out.println("your data has been transfered");
	}else {
		System.out.println("sorry some error has been occured");
	}
}
}
