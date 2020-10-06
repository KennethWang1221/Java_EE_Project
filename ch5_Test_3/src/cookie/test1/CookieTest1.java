package cookie.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/CookieTest1")
public class CookieTest1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		/*
		 * 服务器端的程序，读取客户端保存的Cookie数据。
		 * 必须使用请求对象进行获取。
		 * */
		
		//创建Cookie对象
		Cookie ck1=new Cookie("usname","longlong");
		Cookie ck2=new Cookie("address","xawlxy");
		
		//设置生命值
		ck1.setMaxAge(300);
		ck2.setMaxAge(300);
		
		//向客户端写入Cookie
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		
		
		
		Cookie[] cks=req.getCookies();
		if(cks==null){
			out.println("<h1>暂时没有Cookie数据。</h1>");
			
		}
		else {
			//遍历数据，输出key-value
			for(Cookie ck:cks){
				out.println("<h1>name:"+ck.getName()+"</h1>");
				out.println("<h1>vlaue:"+ck.getValue()+"</h1>");
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		
		
	}
	

}
