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
		//�������߻�ȡ�����û���Ϣ��session����
		HttpSession session =req.getSession();
		User user= (User) session.getAttribute("user");
		if(user==null) {
			resp.getWriter().print(
			"����û�е�¼����<a href='/chapter05/SessionLogin.html'>��¼</a>");
			
		}
		else {
			resp.getWriter().print("���Ѿ���¼����ӭ�㣬"
					+user.getUsername()+"!");
			resp.getWriter().print(
					"<a href='/chapter05/LogoutServlet'>�˳�</a>");
			//����cookie ���Session �ı�ʶ��
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
