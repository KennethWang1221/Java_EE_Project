package cn.itcast.chapter05.cookie.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LastAccessServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		Date date=new Date();
		//��ʽ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = sdf.format(date);
		//����Cookie����
		Cookie ck=new Cookie("lastAccess", currentTime);
		
		ck.setMaxAge(600);
		
		resp.addCookie(ck);
		
		String lastAccessTime="��һ�η��ʱ�վ��";
		//��ȡ�ͻ�����Cookie
		Cookie[] cks=req.getCookies();
		
		if(cks!=null){
			for(Cookie ck1:cks){
				if("lastAccess".equals(ck1.getName())){
					lastAccessTime=ck1.getValue();
					break;
				}
			}
		}
		
		out.println("<h1>�ϴη���ʱ�䣺"+lastAccessTime+"</h1>");
		
		/*
		 * ���ڱ��η����Ѿ���Ϊ����ķ����ˣ���Ҫ���·���ʱ��
		 * 
		 * */
		
		
		
		//�۲�session��id
		HttpSession session=req.getSession();
		out.println("<h1>"+session.getId()+"</h1>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
