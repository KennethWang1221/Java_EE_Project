package cn.itcast.chapter05.session.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class sessionTest2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		
		//��Test2�����У���session�����ȡ����
		/*HttpSession session=req.getSession();
		String msg=(String) session.getAttribute("msg");
		
		out.println("<h1>msg:"+msg+"</h1>");*/
		//��Test2�����У���session�����ȡ����
		HttpSession session =req.getSession();
		String msg=(String) session.getAttribute("msg");
		out.println("<h1>msg:"+msg+"</h1>");
		
		
		
	}
}
