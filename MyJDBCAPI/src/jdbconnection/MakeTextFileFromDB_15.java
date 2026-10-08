package jdbconnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;
public class MakeTextFileFromDB_15 {
private static final String SQL_SELECT_QUERY = "select eid,ename,eaddress,resume from employee where eid = ?";
public static void main(String[] args) {
// Resources used
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
int eid = 0;
try {
connection = MakeConnection_1.dbConnection();
// 2. Create a Statement Object
if (connection != null) {
preparedStatement =connection.prepareStatement(SQL_SELECT_QUERY);

}
Scanner scanner = new Scanner(System.in);
if (preparedStatement != null && scanner != null) {
System.out.print("Enter the id of the employee:: ");
eid = scanner.nextInt();
// Set the value to the placeholder '?'

preparedStatement.setInt(1, eid);
// Execute the Query
resultSet = preparedStatement.executeQuery();
}
// 4. Process the Result
if (resultSet.next()) {
System.out.println("EID\tENAME\tEADDRESS\tRESUME");
String resumeLocation = "D:\\octoberbatch\\src\\Resume.txt";
// Framework Code or API Code
FileWriter fileWriter = new FileWriter(new File(resumeLocation));

IOUtils.copy(resultSet.getCharacterStream(4), fileWriter);
fileWriter.flush();
System.out.println(resultSet.getInt(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getString(3)
+ "\t" + resumeLocation);

} else {
System.out.println("Record not found for the given id :: "+ eid);

}
scanner.close();
} catch (SQLException e) {
e.printStackTrace();
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
} finally {
	MakeConnection_1.cleanobject(resultSet, preparedStatement, connection);
}
}
}
