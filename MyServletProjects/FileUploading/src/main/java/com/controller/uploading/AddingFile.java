package com.controller.uploading;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;


/**
 * Servlet implementation class AddingFile
 */
@WebServlet("/Upload")
public class AddingFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_INSERT_QUERY = "insert into person_profile(`pname`,`paddress`,`resumeloc`,`photoloc`) values(?,?,?,?)";

	@Resource(name = "JNDC")
	private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello..!");
		String resumeLocation="C:\\UserResume";
		String photoLocation="C:\\userPhoto";
		PrintWriter out=response.getWriter();
		Boolean flag=false;
		String username = null, useraddr = null, resumeFilePath = null, photoFilePath = null;

		try {
			// collecting request object which holds resume and photo as streams
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(request);
			username=nreq.getParameter("username");
			useraddr=nreq.getParameter("useraddress");
			// Using UploadBean to work with FileSystem
			UploadBean bean=new UploadBean();
			bean.setMaxfiles(12);
			bean.setOverwrite(true);
			// Specify the location of server machine where file needs to uploaded
			bean.setFolderstore(resumeLocation);
			bean.store(nreq,"userresume");
			// Specify the location of server machine where file needs to uploaded
			bean.setFolderstore(photoLocation);
			bean.store(nreq,"userphoto");
			@SuppressWarnings("rawtypes")
			Vector vector = bean.getHistory();
			resumeFilePath = resumeLocation + ((UploadParameters) vector.get(0)).getFilename();
			System.out.println(resumeFilePath);
			photoFilePath = photoLocation + ((UploadParameters) vector.get(1)).getFilename();
			System.out.println(photoFilePath);

			flag = true;
			out.println("<h1 style='color:green; text-align:center;'>UPLOADING THE FILE INTO SERVER....</h1>");

			
		} catch (UploadException e) {
			out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
			e.printStackTrace();
		} catch (IOException e) {
			out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
			e.printStackTrace();
		}
		if (flag) {
			// JDBC CODE
			try (Connection con = ds.getConnection()) {

				try (PreparedStatement pstm = con.prepareStatement(SQL_INSERT_QUERY)) {
					// set the values collected from the user
					pstm.setString(1, username);
					pstm.setString(2, useraddr);
					pstm.setString(3, resumeFilePath);
					pstm.setString(4, photoFilePath);

					int rowCount = pstm.executeUpdate();
					if (rowCount == 0) {
						out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
					} else {
						out.println("<h1 style='color:green;text-align:center;'>REGISTRATION COMPLETED</h1>");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
			}

		} else {
			out.println("<h1 style='color:green; text-align:center;'>UPLOADING THE FILE INTO SERVER....</h1>");
		}
		out.println("<h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>");
	
	}

}
