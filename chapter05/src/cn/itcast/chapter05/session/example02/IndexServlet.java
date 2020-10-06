package cn.itcast.chapter05.session.example02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/IndexServlet")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		//创建或者获取保存用户信息的session对象
		HttpSession session =req.getSession();
		User user= (User) session.getAttribute("user");
		if(user==null) {
			resp.getWriter().print(
			"您还没有登录，请<a href='/chapter05/SessionLogin.html'>登录</a>");
			
		}
		else {
			resp.getWriter().print("您已经登录，欢迎你，"
					+user.getUsername()+"!");
			resp.getWriter().print(
					"<a href='/chapter05/LogoutServlet'>退出</a>");
			//创建cookie 存放Session 的标识号
			Cookie cookie =new Cookie("JESSIONID",session.getId());
			cookie.setMaxAge(60*30);
			cookie.setPath("/chapter05");
			resp.addCookie(cookie);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
