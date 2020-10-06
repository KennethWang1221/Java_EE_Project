package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatchertest1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = resp.getWriter();
		String usn=req.getParameter("usss");
		String psw=req.getParameter("pass");
		
		
		if(usn==null||"".equals(usn)||psw==null||"".equals(psw)) {
			out.print("<script>");
			out.print("alert(\"用户名或者密码不能为空\");");
			out.print("window.loaction.href=\"logintest.jsp\";");
			out.print("</script>");
		}
		if(("wangxiang").equals(usn)&&("123").equals(psw)) {
			req.setAttribute("username",usn );
			req.setAttribute("password", psw);
			RequestDispatcher rd=
					req.getRequestDispatcher("/Dispatchertest1Result");
			        rd.forward(req, resp);
		}
		else {
			out.println("<script>");
			out.println("alert(\"用户名或者密码错误！！！\");");
			out.println("window.location.href=\"logintest.jsp\";");
			out.println("</script>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
