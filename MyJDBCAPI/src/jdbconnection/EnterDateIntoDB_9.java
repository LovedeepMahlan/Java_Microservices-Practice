package jdbconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EnterDateIntoDB_9 {
private static Connection connection=null;
private static final String insert_into_DB="insert into users (username, userdob) values (?, ?)";
static {
	try {
		connection=MakeConnection_1.dbConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void main(String[] args) throws ParseException {
	PreparedStatement preparestmt=null;
	if(connection!=null) {
		try {
			preparestmt=connection.prepareStatement(insert_into_DB);
			if(preparestmt!=null) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the username which we have to insert");
				String username=sc.next();
				System.out.println("enter thr dob of user");
				String userdob=sc.next();
				preparestmt.setString(1, username);
				preparestmt.setDate(2, getDOB(userdob));
				Integer num=preparestmt.executeUpdate();
				if(num==0) {
					System.out.println("Sorry unable to inseert the Quary");
				}else {
					System.out.println("your data has been inserted ::"+num);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MakeConnection_1.cleanobject(null, preparestmt, connection);
		}
	}
}

private static Date getDOB(String userdob) throws ParseException  {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date date=sdf.parse(userdob);
	long jsd1=date.getTime();
	java.sql.Date jsd=new Date(jsd1);
	return jsd;
}
}
