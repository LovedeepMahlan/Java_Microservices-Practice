package Com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionApp2")
public class SessionApp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session==null) {
			out.println("<h1 color=black text-align=center>No data available</h1>");
		}else {
			Enumeration<String> enu=session.getAttributeNames();
			out.println("<h1 style=\"color: yellow; text-align: center;\">SESION INFORMATION</h1>");
			out.println("<table align='center' boredr=1>");
			out.println("<tr> <th> ATTRIBUTE NAME </th> <th> ATTRIBULT VALUE </th> <tr>");
			while(enu.hasMoreElements()) {
				out.println("<tr>");
				String Attributename=(String)enu.nextElement();
				Object AttributeValue=session.getAttribute(Attributename);
				out.println("<td>"+Attributename+"</td>");
				out.println("<td>"+AttributeValue+"</td>");
				out.println("</tr");
			}
			out.println("</table");
			out.println("/body");
		}
		
	}

}
