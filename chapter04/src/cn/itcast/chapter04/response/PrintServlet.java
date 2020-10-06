package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data2="dog";
		PrintWriter out=resp.getWriter();
		out.println(data2);
		
		int data3=100;
		PrintWriter out1=resp.getWriter();
		out1.println(data3);
		
		String data="itcast";
		//获取字节输出流对象
		PrintWriter print= resp.getWriter();
		print.write(data);//输出信息
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
