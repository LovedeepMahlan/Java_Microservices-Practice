package jdbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteByPreparedStmt_8 {
	private static Connection connection=null;
	private static final String Delete_From_DB="delete from student where sid=?";
	static {
		try {
			connection=MakeConnection_1.dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		PreparedStatement preparestmt=null;
		if(connection!=null) {
			try {
				preparestmt=connection.prepareStatement(Delete_From_DB);
				if(preparestmt!=null) {
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter the sid here we have to delete");
					Integer sid=sc.nextInt();
					preparestmt.setInt(1,sid);
					Integer num=preparestmt.executeUpdate();
					System.out.println("No of row deleted is ::"+num);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MakeConnection_1.cleanobject(null, preparestmt, connection);
			}
			
		}
	}
}
