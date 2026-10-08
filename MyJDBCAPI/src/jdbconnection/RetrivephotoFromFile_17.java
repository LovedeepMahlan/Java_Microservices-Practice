package jdbconnection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RetrivephotoFromFile_17 {
	private static final String Inset_Quary = "select id ,name,photo from person where id = ?";
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
	ResultSet rs=null;
	if(connection!=null) {
		try {
			ps=connection.prepareStatement(Inset_Quary);
			if(ps!=null) {
				Scanner sc=new Scanner(System.in);
				System.out.println("put the id of person");
				int a=sc.nextInt();
				ps.setInt(1, a);
				rs=ps.executeQuery();
				if(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
					System.out.println(getphoto(rs.getBinaryStream(3)));
				}else {
					System.out.println("record not found for given id"+a);
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(rs, ps, connection);
		}
	} 
}
public static String getphoto(InputStream is) throws IOException {
	String location="download.jpg";
	FileOutputStream fos=new FileOutputStream(location);
	int data=is.read();
	while(data!=-1) {
		fos.write(data);
		data=is.read();
	}
	fos.close();
	is.close();
	return "Output you get in your given location "+location;
}

}

;