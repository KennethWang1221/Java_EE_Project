package session.stroe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.test.Book;

@WebServlet(urlPatterns="/SessionStoreTest2")
public class SessionStoreTest2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//在Test2程序中，从sessin对象获取数据
		HttpSession session=req.getSession();
		
		String msg=(String)session.getAttribute("msg");
		Book book=(Book)session.getAttribute("book");
		
		out.println("<h1>msg:"+msg+"</h1>");
		out.println("<h1>book:"+book.getName()+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
