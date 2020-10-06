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
		 * �������˵ĳ��򣬶�ȡ�ͻ��˱����Cookie���ݡ�
		 * ����ʹ�����������л�ȡ��
		 * */
		
		//����Cookie����
		Cookie ck1=new Cookie("usname","longlong");
		Cookie ck2=new Cookie("address","xawlxy");
		
		//��������ֵ
		ck1.setMaxAge(300);
		ck2.setMaxAge(300);
		
		//��ͻ���д��Cookie
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		
		
		
		Cookie[] cks=req.getCookies();
		if(cks==null){
			out.println("<h1>��ʱû��Cookie���ݡ�</h1>");
			
		}
		else {
			//�������ݣ����key-value
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
