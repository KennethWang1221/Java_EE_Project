package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownManagerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//��ȡreferer��ֵ
		String referer=req.getHeader("referer");
		String sitePart="http://"+req.getServerName();
		//�ж�referer ͷ�Ƿ�Ϊ�գ����ͷ���׵�ַ�Ƿ���sitePart��ʼ��
		if(referer!=null && referer.startsWith(sitePart)) {
			//�����������ص�����
			out.println("dealing download...");
		}
		else {
			//�Ƿ�����������ת��download.html ҳ��
			RequestDispatcher rd=req.getRequestDispatcher("/download.html");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
 
}
