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
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../insertion.jsp");
				rd.forward(request, response);
			} else {
				System.out.println(status);
				request.setAttribute("status", "failure");
				rd = request.getRequestDispatcher("../insertion.jsp");
				rd.forward(request, response);
			}
			
		}
		if(request.getRequestURI().endsWith("search")) {
			String id=request.getParameter("studid");
			StudentDTO dto=null;
			dto=stdservice.readRecord(Integer.parseInt(id));
			request.setAttribute("student", dto);
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("../Search.jsp");
			rd.forward(request, response);
		}
		if(request.getRequestURI().endsWith("delete")) {
			String id=request.getParameter("studid");
			String status=stdservice.deleteRecord(Integer.parseInt(id));
			RequestDispatcher rd=null;
			System.out.println(status);
			if(status.equalsIgnoreCase("success")) {
				request.setAttribute("status", status);
				rd=request.getRequestDispatcher("../deletion.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getRequestURI().endsWith("update")) {
			String sid = request.getParameter("sid");

			StudentDTO stdDB = stdservice.readRecord(Integer.parseInt(sid));
			request.setAttribute("Student", stdDB);
			RequestDispatcher rd=request.getRequestDispatcher("../updateform.jsp");
			rd.forward(request, response);
			
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
			request.setAttribute("status", status);
			System.out.println(status);
			rd=request.getRequestDispatcher("../../updation.jsp");
			rd.forward(request, response);	
		}
	
	}

}
