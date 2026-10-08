package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Video")
public class VideoMp4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static {
    	 System.out.println("Loading of .class file");
     }
    public VideoMp4() {
       System.out.println("Intialization of .class file");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("Instatiation of .class file");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("video/mp4");
		ServletOutputStream out=response.getOutputStream();
		String path=getServletContext().getRealPath("MyVideo.mp4");
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		byte[] b=new byte[(int)f .length()];
		fis.read(b);
		out.write(b);
		out.flush();
		out.close();
		fis.close();
	}

}
