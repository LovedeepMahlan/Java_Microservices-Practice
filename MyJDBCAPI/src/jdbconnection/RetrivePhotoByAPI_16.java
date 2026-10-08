package jdbconnection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;
public class RetrivePhotoByAPI_16 {
private static final String SQL_SELECT_QUERY = "select id,name,photo from person where id = ?";
public static void main(String[] args) {
// Resources used
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
int id = 0;
try {
connection = MakeConnection_1.dbConnection();
// 2. Create a Statement Object
if (connection != null) {
preparedStatement =
connection.prepareStatement(SQL_SELECT_QUERY);

}
Scanner scanner = new Scanner(System.in);
if (preparedStatement != null && scanner != null) {
System.out.print("Enter the id of the user:: ");

id = scanner.nextInt();
// Set the value to the placeholder '?'
preparedStatement.setInt(1, id);
// Execute the Query
resultSet = preparedStatement.executeQuery();
}
// 4. Process the Result
if (resultSet.next()) {
System.out.println("ID\tNAME\tPHOTO");
String imageName = "download.jpg";
//Framework Code or API Code
IOUtils.copy(resultSet.getBinaryStream(3), new FileOutputStream(imageName));

System.out.println(resultSet.getInt(1) + "\t" +

resultSet.getString(2) + "\t"+imageName);

} else {
System.out.println("Record not found for the given id :: "

+ id);

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