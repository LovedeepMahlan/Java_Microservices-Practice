package practicSet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(description = "Basics of servlet", urlPatterns = { "/FirstServlet" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String passworrd=request.getParameter("userpassword");
		PrintWriter out=response.getWriter();
		out.println("<p>The name that you have entered is "+name+"</p>");
		out.println("<p>The password that you have entered is "+passworrd+"</p>");
	}

}
