package test2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest5 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 读取Servlet对象的配置信息，使用ServletConfig对象
		 * */
		
		ServletConfig config=this.getServletConfig();
		String danwei=config.getInitParameter("danwei");
		String encoding =config.getInitParameter("bianma");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		
		PrintWriter out=resp.getWriter();
		
		out.println("<h1>单位名称："+danwei+"</h1>");
		out.println("<h1>编码："+encoding+"</h1>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
