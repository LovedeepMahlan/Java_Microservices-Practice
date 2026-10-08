package jdbconnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddFileIntoDB_14 {
	private static final String Insert_Employee = "insert into Employee(`ename`,`eaddress`,`resume`) values(?,?,?)";
	private static Connection connection=null;
	static {
		try {
			connection=MakeConnection_1.dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement(Insert_Employee);
			Scanner sc=new Scanner(System.in);
			if(pstmt!=null) {
				System.out.println("Enter the Employee name");
				String ename=sc.next();
				System.out.println("Enter the Employee address");
				String eaddress=sc.next();
				pstmt.setString(1,ename);
				pstmt.setString(2, eaddress);
				String location="D:\\octoberbatch\\src\\Resume.txt";
				pstmt.setCharacterStream(3, new FileReader(location));
				int rowcount=pstmt.executeUpdate();
				if(rowcount!=0) {
					System.out.println("Quary get updated");
				}else {
					System.out.println("Sorry some error has been occured");
				}
			}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, pstmt, connection);
		}
	}
}
