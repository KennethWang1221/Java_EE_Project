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
		//��HttpServletRequest�����getParameter����������ȡ�û���������
		String username=req.getParameter("usn");
		String password=req.getParameter("psw");
		
		if(username==null||"".equals(username)||password==null||"".equals(password)){
			//���ֳ����������·��ص���½ҳ�棬������
			out.print("<script>");
			out.print("alert(\"�û������벻��Ϊ��\");");	//���alert֮��ǵüӷֺţ����򲻵���
            out.print("window.location.href=\"Login.jsp\";");
			out.print("</script>");
			
		}
		
		
		//�����û���������ֱ�Ϊ wangxiang ��123
		if(("wangxiang").equals(username) &&("123").equals(password)) {
			//����û�����������ȷ�����¶��� welcome.html
			
            //resp.sendRedirect("welcome.jsp");
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/DispathcherResultTest");
			dispatcher.forward(req, resp);
		}
		else {
			//����û���������������¶���login.html
			//resp.sendRedirect("/chapter04/Login.html");
			
			
			out.println("<script>");
			out.println("alert(\"�û������������\");");
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




