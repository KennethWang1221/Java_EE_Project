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
			
			//在Test1程序中，给session保存数据
			HttpSession session=req.getSession();
			session.setMaxInactiveInterval(60);
			String msg="学校名称";
			
			session.setAttribute("msg", msg);
			out.println("会话对象数据已经ok");
			out.println("<a href=\"sessionTest2\">sessionTest2</a>");*/
			
			resp.setCharacterEncoding("gbk");
			resp.setContentType("text/html;charset=gbk");
			PrintWriter out=resp.getWriter();
			//在 Test1 中 给 session保存数据
			HttpSession session=req.getSession();
			session.setMaxInactiveInterval(60);
			String msg="学校名称";
			
			session.setAttribute("msg", msg);
			out.println("会话对象数据已经OK");
			out.println("<a href=\"sessionTest2\">sessionTest2</a>");
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		}

}
