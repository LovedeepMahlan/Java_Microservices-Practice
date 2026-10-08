package Com.in.Cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectionWithDB
 */
@WebServlet(
		urlPatterns = { "/ConnectionWithDB" }, 
		initParams = { 
				@WebInitParam(name = "drivername", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql:///apple"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "mysql#123")
		})
public class ConnectionWithDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_Query = "select * from student";
	static {
		System.out.println("ConnectionWithDB loading");
	}
	public ConnectionWithDB() {
	System.out.println("ConnectionWithDB.Instantiation ");	// TODO Auto-generated constructor stub
	}
	Connection connection=null;
	Statement statement=null;
	public void init() throws ServletException {
		System.out.println("Initialization of required  class");
		try {
			Class.forName(getInitParameter("drivername"));
			connection=DriverManager.getConnection(getInitParameter("url"),
					getInitParameter("username"),getInitParameter("password"));
			if(connection!=null) {
				statement=connection.createStatement();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		System.out.println("Request Processing");
		ResultSet rs=null;
		if(statement!=null) {
			try {
				rs=statement.executeQuery(SQL_Query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			PrintWriter out=response.getWriter();
			out.println("<body align='center' bgcolor='orange'>");
			out.println("<h1 bgcolor='pink' text-align='center'>Compelte data of required table</h1>");
			out.println("<table align ='center' border='2'>");
			out.println("<tr> <th>SID</th> <th>SNAME</th> <th>SAGE</th> <th>SADDRESS</th> </tr>");
			try {
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>"+rs.getInt(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getInt(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("</tr>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.println("</table>");
			out.println("</body>");
			out.close();
		}
	}
	@Override
	public void destroy() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
