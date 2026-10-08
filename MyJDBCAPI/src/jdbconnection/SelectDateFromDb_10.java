package jdbconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectDateFromDb_10 {
private static Connection connection;
private static String Select_Quary="select * from users where userid=?";
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void main(String[] args) throws SQLException {
	PreparedStatement prepstmt=null;
	if(connection!=null) {
		prepstmt=connection.prepareStatement(Select_Quary);
	}
	if(prepstmt!=null) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the user id :: ");
		Integer userid=sc.nextInt();
		prepstmt.setInt(1, userid);
		ResultSet resultset=prepstmt.executeQuery();
		System.out.println("userid\tusername\tuserdob");
		if(resultset.next()) {
			System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+getDate(resultset.getDate(3)));
		}else {
			System.out.println("Sorry you enter out of bound userid");
		}
	}
}
public static String getDate(Date date) {
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	return sdf.format(date);
}
}
