package jdbconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ToAddPhotoInDataBase_18 {
	static int a;
	private static final String Inset_Quary = "insert into person(`name`,`photo`) values(?,?)";
	private static Connection connection =null;
	static {
		try {
			connection=MakeConnection_1.dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	PreparedStatement ps=null;
	if(connection!=null) {
		try {
			ps=connection.prepareStatement(Inset_Quary);
			if(ps!=null) {
				Scanner sc=new Scanner(System.in);
				System.out.println("put the name of person");
				String name=sc.next();
				String s="C:\\Users\\Xps\\OneDrive\\Pictures\\Camera Roll\\WIN_20220814_09_00_28_Pro.jpg";
				ps.setString(1, name);
				ps.setBinaryStream(2, new FileInputStream(s));
				 a=ps.executeUpdate();
				 System.out.println("row inserted is ::"+a);
			}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, ps, connection);
		}
	}
}
}
