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

public class LastAccessServlettest1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;chaeset=gbk");
		PrintWriter out=resp.getWriter();
		
		String currentTime =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date());
        Cookie cookie=new Cookie ("lastAccess",currentTime);
        resp.addCookie(cookie);
        
        String lastAccessTime = null;
        
		Cookie[] cookies =req.getCookies();
		/*for (int i=0;cookies!=null&& i<cookies.length;i++) {
			if("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
			
		}*/
		for (Cookie cks:cookies) {
			if("lastAccess".equals(cks.getName())) {
				lastAccessTime = cks.getValue();
				break;
			}
			
		}
		if(lastAccessTime==null) {
			resp.getWriter().print("您是首次访问本站！！！");
		}
		else {
			resp.getWriter().print("您上次访问的时间是："+ lastAccessTime);
		}
		
		/*String currentTime =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date());
        Cookie cookie=new Cookie ("lastAccess",currentTime);
        resp.addCookie(cookie);	*/
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
