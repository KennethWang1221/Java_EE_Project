package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatchertest1Result extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//��ȡrequest�����б��������
		String usninfo=(String) req.getAttribute("username");
		if(usninfo!=null) {
			out.println("���û����û���Ϊ��"+usninfo+"<br>");
		}
		String pswinfo=(String) req.getAttribute("password");
		if(pswinfo!=null) {
			out.println("���û�������Ϊ:"+pswinfo+"<br>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}

