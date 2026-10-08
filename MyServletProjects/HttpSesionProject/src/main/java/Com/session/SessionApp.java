package Com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionApp")
public class SessionApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession();
		if(session.isNew()) {
			out.println("<h1 style=\"color:red;text-align: center;\">New session object is created with sessionid ::"+session.getId()+" </h1>");
		}
		else{
			out.println("<h1 style=\"color:red;text-align: center;\">same session with sessionid ::"+session.getId()+" </h1>");
		}
		// if we have to change session after a particular time the we use following code
		//session.setMaxInactiveInterval(12);
		session.setAttribute(name, value);
		RequestDispatcher rd=request.getRequestDispatcher("./index.html");
		rd.forward(request, response);
	}

}
