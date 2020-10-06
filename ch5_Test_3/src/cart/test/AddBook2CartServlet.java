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
			out.println("alert(\"����������������ӡ�\");");
			out.println("window.location.href=\"ListAllBooks\";");
			out.println("</script>");
			return;   //���������
		}
		Book bk=BookDB.getBook(id);
		
		//��ȡsession��������ʵ�ֹ��ﳵ������
		HttpSession session=req.getSession();
		//���Ի�ȡ���ﳵ�Ķ��󣬾��Ǵ��ͼ���list����
		List<Book> cart=(List)session.getAttribute("cart");
		
		if(cart==null){
			//��һ��ʹ��
			cart=new ArrayList<Book>();			
		}
		cart.add(bk);
		
		//Ҫ�����ﳵlist�Ķ��󱣴��ڷ�����������ÿ�������ߵ������档
		session.setAttribute("cart", cart);
		
		out.println("<a href=\"ListCartServlet\">�鿴���ﳵ</a>");
		out.println("<a href=\"ListAllBooks\">�������</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
