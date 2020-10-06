package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charaset=gbk");
		PrintWriter out=resp.getWriter();
		//获取请求消息中所有头字段
		Enumeration headerNames=req.getHeaderNames();
		//使用循环遍历所有请求头，并通过getHeader()方法获取一个指定名称的头字段
		while(headerNames.hasMoreElements()) {
			String headerName=(String) headerNames.nextElement();
			out.println(headerName +":"+req.getHeader(headerName)+"<br/>");
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
