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
		//��HttpServletRequest�����getParameter����������ȡ�û���������
		String username=req.getParameter("usnss");
		String password=req.getParameter("pswss");
		//�����û���������ֱ�Ϊ wangxiang ��123
		if(("wangxiang").equals(username) &&("123").equals(password)) {
			//����û�����������ȷ�����¶��� welcome.html
			//resp.sendRedirect("/chapter04/welcome.html");
			
			out.println("<script>");
			out.println("alert(\"�û��������¼�ɹ���\");");
			out.println("window.location.href=\"welcome.html\";");
			out.println("</script>");
		}
		else {
			//����û���������������¶���login.html
			//resp.sendRedirect("/chapter04/login.html");
			
			
			out.println("<script>");
			out.println("alert(\"�û������벻��Ϊ�գ�\");");
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
