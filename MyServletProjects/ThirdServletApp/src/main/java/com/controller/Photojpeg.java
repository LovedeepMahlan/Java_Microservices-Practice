package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

@WebServlet(description = "Take photo from server", urlPatterns = { "/Image" })
public class Photojpeg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static {
    	System.out.println("Loading of Image.class");
    }
    public Photojpeg() {
        System.out.println("Initialization of image class");
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("Instatiation of Image class");
    }
    @Override
    public void destroy() {
    	System.out.println("De-instantation of Image class");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Respond a image to client");
		response.setContentType("Image/jpeg");
		ServletOutputStream out=response.getOutputStream();
		String path=getServletContext().getRealPath("Lovedeep.jpg");
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		byte[] b=new byte[(int)f.length()];
		fis.read(b);
		out.write(b);
		out.flush();
		out.close();
		fis.close();
	}

}
