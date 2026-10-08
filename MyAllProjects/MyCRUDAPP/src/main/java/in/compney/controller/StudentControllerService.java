package in.compney.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.compney.dataObjects.StudentDTO;
import in.compney.factory.StudentServiceFactory;
import in.compney.service.StudentService;

@WebServlet("/controller/*")
public class StudentControllerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentControllerService() {
       System.out.println("Servlet Initialize");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request URI is ::"+request.getRequestURI());
		System.out.println("Request pathinfo is ::"+request.getPathInfo());
		StudentService stdservice=StudentServiceFactory.getStudentService();
		
		//code for add Student
		if(request.getRequestURI().endsWith("add")) {
			String Studname=request.getParameter("studname");
			String studage=request.getParameter("studage");
			String studaddr=request.getParameter("studaddr");
			String studid=request.getParameter("studid");
			StudentDTO dto=new StudentDTO();
			dto.setSid(Integer.parseInt(studid));
			dto.setSage(Integer.parseInt(studage));
			dto.setSaddress(studaddr);
			dto.setSname(Studname);
			String status=stdservice.InsertRecord(dto);
			
			RequestDispatcher rd=null;
			if (status.equals("success")) {
				System.out.println(status);
				rd = request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
			} else {
				System.out.println(status);
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
			
		}
		if(request.getRequestURI().endsWith("search")) {
			String id=request.getParameter("studid");
			StudentDTO dto=null;
			PrintWriter out=response.getWriter();
			dto=stdservice.readRecord(Integer.parseInt(id));
			if (dto != null) {
				out.println("<body>");
				out.println("<br/><br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>SID</th><td>" + dto.getSid() + "</td></tr>");
				out.println("<tr><th>SNAME</th><td>" + dto.getSname() + "</td></tr>");
				out.println("<tr><th>SAGE</th><td>" + dto.getSage() + "</td></tr>");
				out.println("<tr><th>SADDRESS</th><td>" + dto.getSaddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");

			} else {
				out.println("<h1 style='color:red; text-align:center;'>RECORD NOT FOUND FOR THE GIVEN ID :: " + id
						+ "</h1>");
			}
			out.close();
		}
		if(request.getRequestURI().endsWith("delete")) {
			String id=request.getParameter("studid");
			String status=stdservice.deleteRecord(Integer.parseInt(id));
			RequestDispatcher rd=null;
			if(status.equalsIgnoreCase(status)) {
				rd=request.getRequestDispatcher("../deletionsuccessfull.html");
				rd.forward(request, response);
			}else {
				rd=request.getRequestDispatcher("../deletionfailure.html");
				rd.forward(request, response);
			}
		}
		if(request.getRequestURI().endsWith("update")) {
			String sid = request.getParameter("sid");

			StudentDTO stdDB = stdservice.readRecord(Integer.parseInt(sid));
			PrintWriter out = null;
			if (stdDB != null) {
				// Display UI Page to render old details of the user
				out = response.getWriter();
				out.println("<body>");
				out.println("<center>");
				out.println("<form action='./controller/editrecord' method='post'>");
				out.println("<table>");
				out.println("<tr><th>SID</th><td><input type='text' name='sid' value='" + stdDB.getSid()
						+ "' readonly/></td></tr>");
				out.println("<tr><th>SNAME</th><td><input type='text' name='sname' value='" + stdDB.getSname()+ "' /></td></tr>");
				out.println("<tr><th>SAGE</th><td><input type='text' name='sage' value='" + stdDB.getSage()+ "' /></td></tr>");
				out.println("<tr><th>SADDRESS</th><td><input type='text' name='saddress' value='" + stdDB.getSaddress()+ "' /></td></tr>");
				out.println("<tr><th></th><th><input type='submit' value='update'/></th></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");

			} else {
				// display updation not possible
				out = response.getWriter();
				out.println("<body>");
				out.println("<h1 style='color:red; text-align:center;'>Record not available for the given id ::" + sid
						+ "</h1>");
				out.println("</body>");
			}
		}
		if(request.getRequestURI().endsWith("editrecord")) {
			String sid=request.getParameter("sid");
			String name=request.getParameter("sname");
			String age=request.getParameter("sage");
			String address=request.getParameter("saddress");
			
			StudentDTO dto=new StudentDTO();
			dto.setSid(Integer.parseInt(sid));
			dto.setSaddress(address);
			dto.setSage(Integer.parseInt(age));
			dto.setSname(name);
			
			String status=stdservice.updateRecord(dto);
			RequestDispatcher rd=null;
			if(status.equalsIgnoreCase("succesfully")) {
				System.out.println(status);
				rd=request.getRequestDispatcher("../../updationsuccessfull.html");
				rd.forward(request, response);
			}else {
				System.out.println(status);
				rd=request.getRequestDispatcher("../updationfailure.html");
				rd.forward(request, response);
			}
		
		}
	
	}

}
