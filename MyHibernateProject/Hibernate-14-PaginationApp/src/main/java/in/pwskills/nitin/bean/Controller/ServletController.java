package in.pwskills.nitin.bean.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import in.pwskills.nitin.bean.InsurancePolicyDTO;
import in.pwskills.nitin.service.InsurancePolicyMgmtServiceImpl;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	InsurancePolicyMgmtServiceImpl impl=null;
	@Override
		public void init() throws ServletException {
			impl=new InsurancePolicyMgmtServiceImpl();
		}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     long pagecount=0;
		     int pagesize=3;
		     int pageNo=0;
		     HttpSession session=null;
		     String input=request.getParameter("s1");
		     List<InsurancePolicyDTO> dto=null;
		     RequestDispatcher rd=null;
		     session=request.getSession(true);
		     if(input.equalsIgnoreCase("generateReport")){
		    	 pagesize=Integer.parseInt(request.getParameter("pageSize"));
		    	 
		    	 pageNo=1;
		    	 if(session!=null) {
		    		 session.setAttribute("pagesize", pagesize);
		    	 }else {
		    		 pageNo=Integer.parseInt(request.getParameter("pageNo"));
		    	 }
		     }try {
		    	 pagecount=impl.fetchPagesCount(pagesize);
		    	 
		    	 dto=impl.fetchPageData(pagesize,pageNo);
		    	 
		    	 request.setAttribute("policyList", dto);
		    	 request.setAttribute("pagesCount", pagecount);
		    	 request.setAttribute("pageNo", pageNo);
		    	 
		     }catch(HibernateException hie) {
		    	 hie.printStackTrace();
		     }catch(Exception e) {
		    	 e.printStackTrace();
		     }
		     rd=request.getRequestDispatcher("./report.jsp");
		     rd.forward(request, response);
	
	}

}
