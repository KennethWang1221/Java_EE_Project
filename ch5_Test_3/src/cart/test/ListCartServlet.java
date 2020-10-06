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

@WebServlet(urlPatterns="/ListCartServlet")
public class ListCartServlet extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		List<Book> cart=(List<Book>)session.getAttribute("cart");
		
		//判断购物车中有无数据
		if(cart==null || cart.size()==0){
			out.println("<h2>你还没有添加购物车。</h2>");
		}
		else {
			out.println("<h2>购物车的数据：</h2>");
			for(int i=0;i<cart.size();i++){
				Book bk2=cart.get(i);
				out.println("<h3>书名："+bk2.getName()+"&nbsp;&nbsp;"
						+ "价格："+bk2.getPrice()+"&nbsp;&nbsp;"
								+ "<a href=\"DelCartServlet?id="+bk2.getId()+"\">删除</a></h3>");
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
