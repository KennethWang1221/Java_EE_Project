package cn.itcast.chapter05.session.example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns="/PurchaseServlet")

public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		//����û��������Ʒ
		String id=req.getParameter("id");
		if(id==null) {
			//��� id==null �ض���ListBookServlet
			/*out.println("<script>");
			out.println("alert(\"id Ϊ�� ������ѡ��id\");");
			out.println("window.location.href=\"ListBookServlet.java\";");
			out.println("</script>");*/
			String url="/chapter05/ListBookServlet";
			resp.sendRedirect(url);
			return;
		}
		
		Book book=BookDB.getBook(id);
		//�������߻���û���Session����
		HttpSession session=req.getSession();
		//�������߻���û��Ĺ��ﳵ
		List<Book> cart=(List) session.getAttribute("cart");
		if(cart==null ) {
			//�״ι��� Ϊ�û�����һ�����ﳵ��List����ģ��һ�����ﳵ��
			cart=new ArrayList<Book>();
			//�����ﳵ���� Session����
			session.setAttribute("cart", cart);
		}
		//����Ʒ���빺�ﳵ
		cart.add(book);
		//����cookie ���session�ı�ʶ��
		Cookie cookie =new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/chapter05");
		resp.addCookie(cookie);
//		���¶��򵽹��ﳵҳ��
		String url="/chapter05/CartServlet";
				resp.sendRedirect(url);
		/*out.println("<script>");
		out.println("alert(\"id Ϊ�� ������ѡ��id\");");
		out.println("window.location.href=\"CartServlet.java\";");
		out.println("</script>");*/
	}
}
