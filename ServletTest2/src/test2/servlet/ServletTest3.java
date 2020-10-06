package test2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest3 extends HttpServlet {
	
	//对于父类中的方法，都是空实现，根据需要进行重写
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 处理客户端的get请求，根据业务需求，进行处理
		 * 这里任务是：从客户端请求中获取所需的数据，处理后显示
		 * 假设需要接收的有：usn,age
		 * 需要注意的是，如果请求中没有包含相关数据，则会获得null对象
		 * 一定要对null对象处理，否则容易产生空指针异常。
		 * */
		String usn=req.getParameter("usn");
		if(usn==null){
			usn="名称异常";
		}
		String age=req.getParameter("age");
		if(age==null){
			age="0";
		}
		
		String ieip=req.getRemoteAddr();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>GET方式</h1>");
		out.println("<h1>用户名："+usn+"</h1>");
		out.println("<h1>年龄："+age+"</h1>");
		out.println("<h1>客户端IP："+ieip+"</h1>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String usn=req.getParameter("usn");		
		if(usn==null){
			usn="名称异常";
		}
		//usn=new String(usn.getBytes("iso8859-1"), "utf-8");
		
		String age=req.getParameter("age");
		if(age==null){
			age="0";
		}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>POST方式</h1>");
		out.println("<h1>用户名："+usn+"</h1>");
		out.println("<h1>年龄："+age+"</h1>");
		
	}
	
	

}
