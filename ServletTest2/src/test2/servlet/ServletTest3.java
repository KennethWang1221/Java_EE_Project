package test2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest3 extends HttpServlet {
	
	//���ڸ����еķ��������ǿ�ʵ�֣�������Ҫ������д
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * ����ͻ��˵�get���󣬸���ҵ�����󣬽��д���
		 * ���������ǣ��ӿͻ��������л�ȡ��������ݣ��������ʾ
		 * ������Ҫ���յ��У�usn,age
		 * ��Ҫע����ǣ����������û�а���������ݣ������null����
		 * һ��Ҫ��null�������������ײ�����ָ���쳣��
		 * */
		String usn=req.getParameter("usn");
		if(usn==null){
			usn="�����쳣";
		}
		String age=req.getParameter("age");
		if(age==null){
			age="0";
		}
		
		String ieip=req.getRemoteAddr();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>GET��ʽ</h1>");
		out.println("<h1>�û�����"+usn+"</h1>");
		out.println("<h1>���䣺"+age+"</h1>");
		out.println("<h1>�ͻ���IP��"+ieip+"</h1>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String usn=req.getParameter("usn");		
		if(usn==null){
			usn="�����쳣";
		}
		//usn=new String(usn.getBytes("iso8859-1"), "utf-8");
		
		String age=req.getParameter("age");
		if(age==null){
			age="0";
		}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>POST��ʽ</h1>");
		out.println("<h1>�û�����"+usn+"</h1>");
		out.println("<h1>���䣺"+age+"</h1>");
		
	}
	
	

}
