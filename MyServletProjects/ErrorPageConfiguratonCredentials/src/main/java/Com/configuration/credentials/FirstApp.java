package Com.configuration.credentials;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/first")
public class FirstApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		if(name.equalsIgnoreCase("Lovedeep") && password.equals("Choudhary")) {
			out.println("<h1 text-align='center' color=red;>Welcome to PWSKILLS</h1>");
		}else{
			response.sendError(401);
		}
		out.close();
	}

}
