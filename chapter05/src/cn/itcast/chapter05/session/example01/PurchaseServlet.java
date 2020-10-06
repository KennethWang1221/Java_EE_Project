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
		
		//获得用户购买的商品
		String id=req.getParameter("id");
		if(id==null) {
			//如果 id==null 重定向到ListBookServlet
			/*out.println("<script>");
			out.println("alert(\"id 为空 请重新选择id\");");
			out.println("window.location.href=\"ListBookServlet.java\";");
			out.println("</script>");*/
			String url="/chapter05/ListBookServlet";
			resp.sendRedirect(url);
			return;
		}
		
		Book book=BookDB.getBook(id);
		//创建或者获得用户的Session对象
		HttpSession session=req.getSession();
		//创建或者获得用户的购物车
		List<Book> cart=(List) session.getAttribute("cart");
		if(cart==null ) {
			//首次购买 为用户创建一个购物车（List集合模拟一个购物车）
			cart=new ArrayList<Book>();
			//将购物车存入 Session对象
			session.setAttribute("cart", cart);
		}
		//将商品放入购物车
		cart.add(book);
		//创建cookie 存放session的标识号
		Cookie cookie =new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/chapter05");
		resp.addCookie(cookie);
//		重新定向到购物车页面
		String url="/chapter05/CartServlet";
				resp.sendRedirect(url);
		/*out.println("<script>");
		out.println("alert(\"id 为空 请重新选择id\");");
		out.println("window.location.href=\"CartServlet.java\";");
		out.println("</script>");*/
	}
}
