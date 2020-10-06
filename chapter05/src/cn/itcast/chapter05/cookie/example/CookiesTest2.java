package cn.itcast.chapter05.cookie.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/CookiesTest2")
public class CookiesTest2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		
		String currentTime=new SimpleDateFormat("yyyy-MM-mm hh:mm:ss").format(new Date());
        Cookie cookie=new Cookie("lastAccess",currentTime);
		
		
		cookie.setMaxAge(100);
		resp.addCookie(cookie);
		String lastAccessTime="��һ�η��ʱ���վ������";
		
		String username=req.getParameter("usn");
		String password=req.getParameter("psd");
		
		if(username==null||"".equals(username)||password==null||"".equals(password)) {
			out.print("<script>");
			out.print("alert(\"�û����������벻��Ϊ��\");");
			out.print("window.loaction.href=\"CookiesTest2Login.jsp\";");
			out.print("</script>");
		}
		if(("wangxiang").equals(username)&&("123").equals(password)) {
			out.print("<script>");
			out.print("alert(\"��½�ɹ�\");");
			//out.print("window.loaction.href=\"CookiesTest2Login.jsp\";");
			out.print("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert(\"�û�������������󣡣���\");");
			out.println("window.location.href=\"CookiesTest2Login.jsp\";");
			out.println("</script>");
		}
		
		
		
		
		Cookie[] cks=req.getCookies();
		if(cks==null){
			out.println("<h1>"+lastAccessTime+"</h1>");
		}else{
			//�������飬���key-value
			/*for(Cookie ck1:cks){
				if("lastAccess".equals(ck1.getName())){
					out.println("<h1>�ϴη���ʱ�䣺"+ck1.getValue()+"</h1>");
					//break;
				}
				if("name".equals(ck1.getName())){
					out.println("<h1>������"+username+"</h1>");
				}
				
				if("psd".equals(ck1.getName())){
					out.println("<h1>���룺"+password+"</h1>");
				}
			}*/
			for(int i=0;cks!=null&&i<cks.length;i++){
				if("lastAccess".equals(cks[i].getName())){
					lastAccessTime=cks[i].getValue();
					out.println("<h1>�ϴη���ʱ�䣺"+lastAccessTime+"</h1>");
					//break;
				}
				if("name".equals(cks[i].getName())){
					out.println("<h1>������"+username+"</h1>");
				}
				
				if("psd".equals(cks[i].getName())){
					out.println("<h1>���룺"+password+"</h1>");
				}
				
			}
		}
		
//		out.println("<h1>�ϴη���ʱ�䣺"+lastAccess+"</h1>");
		
		/*String name=req.getParameter("username");
		String psd=req.getParameter("psdword");*/
		//����Cookie����
		/*Cookie ck1=new Cookie("name",username);
		Cookie ck2=new Cookie("psd",password);
		//System.out.println(ck1);
		//��������ֵ
		ck1.setMaxAge(1200);
		ck2.setMaxAge(1200);

		//��ͻ���д��Cookie
		resp.addCookie(ck1);
		resp.addCookie(ck2);*/
		
		//Date date=new Date();
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-mm hh:mm:ss");
		//lastAccess = sdf.format(date);
		
		/*Cookie ck=new Cookie("lastAccess",lastAccess);
		
		
		ck.setMaxAge(1200);
		resp.addCookie(ck);*/
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}