package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//用HttpServletRequest对象的getParameter（）方法获取用户名和密码
		String username=req.getParameter("usnss");
		String password=req.getParameter("pswss");
		//假设用户名和密码分别为 wangxiang 和123
		if(("wangxiang").equals(username) &&("123").equals(password)) {
			//如果用户名和密码正确，重新定向到 welcome.html
			//resp.sendRedirect("/chapter04/welcome.html");
			
			out.println("<script>");
			out.println("alert(\"用户名密码登录成功：\");");
			out.println("window.location.href=\"welcome.html\";");
			out.println("</script>");
		}
		else {
			//如果用户名和密码错误，重新定向到login.html
			//resp.sendRedirect("/chapter04/login.html");
			
			
			out.println("<script>");
			out.println("alert(\"用户名密码不能为空：\");");
			out.println("window.location.href=\"login.html\";");
			out.println("</script>");

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
