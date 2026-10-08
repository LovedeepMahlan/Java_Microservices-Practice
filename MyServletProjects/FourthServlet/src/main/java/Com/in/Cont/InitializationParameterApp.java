package Com.in.Cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//code for print the parameters in a servlet
@WebServlet(
		urlPatterns = { "/Test" }, 
		initParams = { 
				@WebInitParam(name = "Name", value = "Lovedeep"), 
				@WebInitParam(name = "Phone_No", value = "9991830226", description = "This is my personal number"), 
				@WebInitParam(name = "Email", value = "lovedeepmahaalan@gmail.com", description = "Personal mail id")
		})
public class InitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestingProcessing :: Initilizationparameterapp");
		System.out.println("Config object details ::"+getServletConfig()); //
		System.out.println("Context object details ::"+getServletContext());
		PrintWriter out=response.getWriter();
		out.println("<body align='center' bgcolor='red'>");
		out.println("<h1 style='text-align:center;'>SERVLETCONGFIDATA IS"+getServletName()+"</h1>");
		out.println("<table align='center' border='6'>");
		out.println("<tr bgcolor='freen'> <th>PARAMETERNAME</th> <th>PARMETERVALUE</th> </tr>");
		Enumeration<String> enu=getInitParameterNames();
		while(enu.hasMoreElements()) {
			out.println("<tr>");
			String paramtername=(String)enu.nextElement();
			String parametervalue=getInitParameter(paramtername);
			out.println("<td>"+paramtername+"</td>");
			out.println("<td>"+parametervalue+"</td>");
			out.println("</tr>");
		}
	}

	

}
