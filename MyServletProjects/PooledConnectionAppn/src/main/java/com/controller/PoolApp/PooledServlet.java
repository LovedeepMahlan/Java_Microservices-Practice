package com.controller.PoolApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PooledServlet
 */
@WebServlet("/pool")
public class PooledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Sql_Query = "insert into student(`sid`,`sname`,`sage`,`saddress`) values(?,?,?,?)";
    @Resource(name="jdbc/EmployeeDB")
    DataSource dataresource;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("ID");
		String name=request.getParameter("Name");
		String age=request.getParameter("userAge");
		String address=request.getParameter("userAddress");
		PrintWriter out=response.getWriter();
		ServletContext scontext=getServletContext();
		String dsinfo=scontext.getInitParameter("JNDC");
		try(Connection connection=getConnection(dsinfo)){//connection=dataresource.getconnection()
			if(connection!=null) {
				try(PreparedStatement ps=connection.prepareStatement(Sql_Query)){
					if(ps!=null) {
						ps.setInt(1,Integer.parseInt(id));
						ps.setString(2,name);
						ps.setInt(3,Integer.parseInt(age));
						ps.setString(4, address);
						int num=ps.executeUpdate();
						if(num==0) {
							out.println("<h1 style='color:red;text-align:center;'>PROBLEM IN your INSERTION</h1>");
						}else {
							out.println("<h1 style='color:red;text-align:center;'>INSERTION HAS BEEN SUCCESSFULLY</h1>");
						}
					}
				}
			}
		} catch (Exception e) {
			out.println("<h1 style='color:red;text-align:center;'>PROBLEM IN YOUR INSERTION</h1>");
			e.printStackTrace();
		}
		out.println("<h1 style='color:red;text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>");
		out.close();
	}
	private Connection getConnection(String info) throws Exception {
		InitialContext context=new InitialContext();
		DataSource ds=(DataSource)context.lookup(info);
		Connection connection=ds.getConnection();
		return connection;
	}

}
