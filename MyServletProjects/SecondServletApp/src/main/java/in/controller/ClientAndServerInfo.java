package in.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientAndServerInfo
 */
@WebServlet(description = "To get client information", urlPatterns = { "/Client" })
public class ClientAndServerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static {
    	System.out.println("Loading of Client .class");
    }
    public ClientAndServerInfo() {
        System.out.println("Instantiation of Client class");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("Initiliation of Client class");
    }
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REqustProcessing :: ClientServerInfo");
		PrintWriter out=response.getWriter();
		String servername=request.getServerName();
		int serverport=request.getServerPort();
		String remoteaddr=request.getRemoteAddr();
		String remotehost=request.getRemoteHost();
		int remoteport=request.getRemotePort();
		out.println("<body bgcolor='pink' align='center'>");
		out.println("<Table border='1'>");
		out.println("<tr>");
		out.println("<th>SERVERNAME</th>");
		out.println("<th>SERVERPORT</th>");
		out.println("<th>REMOTEADDR</th>");
		out.println("<th>REMOTEHOST</th>");
		out.println("<th>REMOTEPORT</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>"+servername+"</th>");
		out.println("<th>"+serverport+"</th>");
		out.println("<th>"+remoteaddr+"</th>");
		out.println("<th>"+remotehost+"</th>");
		out.println("<th>"+remoteport+"</th>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		
	}

}
