package cn.itcast.chapter05.cookie.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesTest1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		Cookie ck1=new Cookie("username","wangxiang");
		Cookie ck2=new Cookie("StudentID","1111");
		
		//设置生命值
		ck1.setMaxAge(300);
		ck1.setMaxAge(300);
		
		//向客户端写入cookie
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		
		Cookie[] cks=req.getCookies();
		if(cks==null) {
			out.println("<h1>暂时没有cookie数据</h1>");
		}else {
		for(int i=0;i<cks.length;i++) {
			out.println("<h1>name:"+cks[i].getName()+"</h1>");
			out.println("<h1>value:"+cks[i].getValue()+"</h1>");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
