package practicSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindImageThServer
 */
@WebServlet("/FindImageThServer")
public class FindImageThServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindImageThServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		ServletOutputStream out=response.getOutputStream();
		File f=new File("D:\\Nitin_Projects\\MyServletProjects\\CreateServletPracticeSet\\src\\main\\webapp\\Lovedeep.jpg");
		FileInputStream fis=new FileInputStream(f);
		byte[] arr=new byte[(int)f.length()];
		fis.read(arr);
		out.write(arr);
		fis.close();
		out.close();
	
	}

	

}
