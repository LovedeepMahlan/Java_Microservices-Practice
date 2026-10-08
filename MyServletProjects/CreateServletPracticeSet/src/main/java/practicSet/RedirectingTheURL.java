package practicSet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectingTheURL
 */
@WebServlet("/RedirectingTheURL")
public class RedirectingTheURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectingTheURL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("First servlet reqest object ::"+request.getClass().getName());
		//While dispatching the response object same object will send but all data will be flushed
		System.out.println("First servlet response hashcode ::"+response.getClass().getName());
		System.out.println("REquest Processing");
		PrintWriter out=response.getWriter();
		//out.flush(); after flush the printWriter object request will no be transfer from one servlet to another servlet;
		//we can send the request th aboslute path also but good programming practice is send th request by relative path
		RequestDispatcher rd=request.getRequestDispatcher("/FirstServlet");
		request.setAttribute("Name", "Lovedeep");
		request.setAttribute("Age", "18");
		out.println("<h1 align='center' color='pink'>Request from first servlet</h1>");
		rd.include(request, response);
		System.out.println(10/0);
	}
}
