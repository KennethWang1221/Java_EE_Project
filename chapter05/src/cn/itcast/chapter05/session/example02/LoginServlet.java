package cn.itcast.chapter05.session.example02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String checkCode=req.getParameter("check_code");
		String saveCode=(String) req.getSession().getAttribute("check_code");
		
		PrintWriter pw=resp.getWriter();
		//假设正确的用户名 是 wangxiang  123
		if(("wangxiang").equals(username)&&("123").equals(password)) {
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("/chapter05/IndexServlet");
			
		}
		else if(checkCode.equals(saveCode)){
			pw.write("用户名或密码错误，登录失败");
			
		}else {
			pw.write("验证码错误");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
