package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//用HttpServletRequest对象的getParameter（）方法获取用户名和密码
		String username=req.getParameter("usn");
		String password=req.getParameter("psw");
		
		if(username==null||"".equals(username)||password==null||"".equals(password)){
			//出现常见错误，重新返回到登陆页面，并弹窗
			out.print("<script>");
			out.print("alert(\"用户名密码不能为空\");");	//这句alert之后记得加分号，否则不弹窗
            out.print("window.location.href=\"Login.jsp\";");
			out.print("</script>");
			
		}
		
		
		//假设用户名和密码分别为 wangxiang 和123
		if(("wangxiang").equals(username) &&("123").equals(password)) {
			//如果用户名和密码正确，重新定向到 welcome.html
			
            //resp.sendRedirect("welcome.jsp");
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/DispathcherResultTest");
			dispatcher.forward(req, resp);
		}
		else {
			//如果用户名和密码错误，重新定向到login.html
			//resp.sendRedirect("/chapter04/Login.html");
			
			
			out.println("<script>");
			out.println("alert(\"用户名或密码错误！\");");
			out.println("window.location.href=\"Login.jsp\";");
			out.println("</script>");

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}




