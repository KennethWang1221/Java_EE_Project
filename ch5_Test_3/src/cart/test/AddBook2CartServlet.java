package cart.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/addBook2CartServlet")
public class AddBook2CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		String id=req.getParameter("id");
		if(id==null){
			out.println("<script>");
			out.println("alert(\"参数有误，请重新添加。\");");
			out.println("window.location.href=\"ListAllBooks\";");
			out.println("</script>");
			return;   //将程序结束
		}
		Book bk=BookDB.getBook(id);
		
		//获取session对象，用来实现购物车的容器
		HttpSession session=req.getSession();
		//尝试获取购物车的对象，就是存放图书的list容器
		List<Book> cart=(List)session.getAttribute("cart");
		
		if(cart==null){
			//第一次使用
			cart=new ArrayList<Book>();			
		}
		cart.add(bk);
		
		//要讲购物车list的对象保存在服务器，并且每个访问者单独保存。
		session.setAttribute("cart", cart);
		
		out.println("<a href=\"ListCartServlet\">查看购物车</a>");
		out.println("<a href=\"ListAllBooks\">继续添加</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
