package cn.itcast.chapter04.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParamsServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("�û�����"+name);
		System.out.println("���룺"+password);
		//��ȡ������Ϊ��hobby����ֵ
		String [] hobbys=req.getParameterValues("hobby");
		System.out.println("����");
		for(int i=0;i<hobbys.length;i++) {
			System.out.println(hobbys[i]+",");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
}
