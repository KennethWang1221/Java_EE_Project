package cn.itcast.chapter05.session.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class sessionTest1 extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			/*resp.setCharacterEncoding("gbk");
			resp.setContentType("text/html;charset=gbk");
			PrintWriter out=resp.getWriter();
			
			//��Test1�����У���session��������
			HttpSession session=req.getSession();
			session.setMaxInactiveInterval(60);
			String msg="ѧУ����";
			
			session.setAttribute("msg", msg);
			out.println("�Ự���������Ѿ�ok");
			out.println("<a href=\"sessionTest2\">sessionTest2</a>");*/
			
			resp.setCharacterEncoding("gbk");
			resp.setContentType("text/html;charset=gbk");
			PrintWriter out=resp.getWriter();
			//�� Test1 �� �� session��������
			HttpSession session=req.getSession();
			session.setMaxInactiveInterval(60);
			String msg="ѧУ����";
			
			session.setAttribute("msg", msg);
			out.println("�Ự���������Ѿ�OK");
			out.println("<a href=\"sessionTest2\">sessionTest2</a>");
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		}

}
