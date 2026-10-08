package jdbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLInjectionByPreparedStatement_20 {
/* preparedStatement is not SqlInjection Global 
 * if we try to pass SQl injection then it gives
 *  error :SQL Error: Parameter index out of range (2 > number of parameters, which is 1).*/
    private static final String SELECT_QUERY = "select count(*) from employee where eid=? and ename=?";
    private static Connection connection = null;

    static {
        try {
            connection = MakeConnection_1.dbConnection();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        PreparedStatement prepstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            if (connection != null) {
                prepstmt = connection.prepareStatement(SELECT_QUERY);
            }

            if (prepstmt != null) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the eid");
                int eid = sc.nextInt();
                System.out.println("Enter the ename");
                String ename = sc.next();

                prepstmt.setInt(1, eid);
                prepstmt.setString(2, ename);

                rs = prepstmt.executeQuery();

                if (rs.next()) { // Move cursor to the first row
                    count = rs.getInt(1);
                }
            }

            if (count == 1) {
                System.out.println("Your credential is proper");
            } else {
                System.out.println("Sorry, your credential is not proper");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } finally {
            MakeConnection_1.cleanobject(rs, prepstmt, connection);
        }
    }
}
