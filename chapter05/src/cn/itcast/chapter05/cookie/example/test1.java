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

public class test1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out = resp.getWriter();
		
		String CurrentTime =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date ());
		String lastAccessTime=null;
		Cookie cookie =new Cookie("lastAccess",CurrentTime);
		resp.addCookie(cookie);
		Cookie[] cookies=req.getCookies();
		for(int i=0;cookies!=null&i<cookies.length;i++) {
			if("lastAccess".equals(cookies[i].getName())){
				lastAccessTime=cookies[i].getValue();
				break;
			}		
		}
		if(lastAccessTime==null) {
			resp.getWriter().println("���ǵ�һ�ε�¼");;
		}
		else {
			resp.getWriter().println("���ϴε�¼��ʱ����"+lastAccessTime);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
