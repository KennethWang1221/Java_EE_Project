package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		//��ȡprintwriter �������������Ϣ
		PrintWriter out=resp.getWriter();
		//��ȡrequest ��������б��������
		String university =(String) req.getAttribute("university");
		if(university !=null) {
			out.println("��ѧ���ƣ�"+university+"<br>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
