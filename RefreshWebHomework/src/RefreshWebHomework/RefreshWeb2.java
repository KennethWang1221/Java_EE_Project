package RefreshWebHomework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshWeb2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		ServletContext context=this.getServletContext();
		Integer num=(Integer) context.getAttribute("refresh");
		
		int temp=0;
		if(num==null) {
			temp=1;
			context.setAttribute("refresh", 1);
		}
		else {
			temp=num+1;
			context.setAttribute("refresh", temp);
		}
		out.println("<h1>当前网页已刷新了"+temp+"</h1>");
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
