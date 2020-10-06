package cart.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ListAllBooks")
public class ListAllBooksServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		/*
		 * 在客户端浏览器上显示可供选择的所有图书，每本图书后面
		 * 跟上，操作的超链接。
		 * */
		
		Collection<Book> books=BookDB.getAll();
		
		out.println("<h1>目前提供出售的图书有：</h1>");
		
		for(Book bk:books){
			out.println("<h2>"+bk.getName()+"&nbsp;<a href=\"addBook2CartServlet?id="+bk.getId()+"\">添加购物车</a></h2>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
