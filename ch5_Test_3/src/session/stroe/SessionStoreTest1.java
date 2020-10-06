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

@WebServlet(urlPatterns="/SessionStoreTest1")
public class SessionStoreTest1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//在Test1程序中，给session保存数据
		HttpSession session=req.getSession();
		session.setMaxInactiveInterval(8);
		String msg="西安文理学院硕士点";
		
		session.setAttribute("msg", msg);
		Book book=new Book("001","三国演义连环画",218.0f);
		session.setAttribute("book", book);
		
		out.println("会话对象数据已经ok");
		
		out.println("<a href=\"SessionStoreTest2\">SessionStoreTest2</a>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
