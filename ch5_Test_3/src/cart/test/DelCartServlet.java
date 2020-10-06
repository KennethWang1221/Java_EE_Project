package cart.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/DelCartServlet")
public class DelCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		String id=req.getParameter("id");
		//对id进行检测
		
		//获取对应的Book对象
		Book bk=BookDB.getBook(id);
		
		HttpSession session=req.getSession();
		List<Book> cart=(List<Book>)session.getAttribute("cart");
		
		if(cart!=null && cart.size()>0){
			cart.remove(bk);
			session.setAttribute("cart", cart);
		}
		
		resp.sendRedirect("ListCartServlet");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	

}
