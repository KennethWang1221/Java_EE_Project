package cn.itcast.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet06 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		ServletContext context=this.getServletContext();
		PrintWriter out= resp.getWriter();
		//获取相对路径中的输入流对象
		InputStream in= context
				.getResourceAsStream("/WEB-INF/classes/itcast.properties");
		Properties pros=new Properties();
		pros.load(in);
		out.println("Company="+pros.getProperty("Company")+"<br/>");
		out.println("Address="+pros.getProperty("Address")+"<br/>");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
