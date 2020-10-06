package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludedServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������Ӧʱʹ�õ��ַ�����
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		out.println("�й�"+"<br/>");
		out.println("URL:"+req.getRequestURL()+"<br/>");
		out.println("QueryString:"+req.getQueryString()+"<br/>");
		out.println("Parameter p1:"+
					req.getParameter("p1")+"<br/>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

}
