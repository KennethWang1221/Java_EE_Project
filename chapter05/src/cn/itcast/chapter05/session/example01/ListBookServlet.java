package cn.itcast.chapter05.session.example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
// javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//(urlPatterns="/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		Collection<Book> books=BookDB.getAll();
		out.write("本站提供的图书有：<br/>");
		for(Book book :books) {
			String url ="/chapter05/PurchaseServlet?id="+book.getId();
		 
			out.write(book.getName()+"<a href='"+url
					+"'>点击购买</a><br/>");
		}
	}
}
