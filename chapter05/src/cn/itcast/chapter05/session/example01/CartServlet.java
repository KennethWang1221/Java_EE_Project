package cn.itcast.chapter05.session.example01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(urlPatterns="/CartServlet")

public class CartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//����cart�����û����ﳵ
		List<Book> cart =null;
		//����pruFlag ����û��Ƿ������Ʒ
		boolean purFlag = true;
		//����û���Session
		HttpSession session =req.getSession(false);
		//���session Ϊnull ��purFlag��Ϊflase
		if(session ==null) {
			purFlag=false;
					
		}
		else {
			//����û����ﳵ
			cart =(List) session.getAttribute("cart");
			//����õĹ��ﳵΪnull purFlag��Ϊfalse
			if(cart==null) {
				purFlag=false;
			}
		}
		/*
		 * ���purFlag Ϊfalse�������û�û�й���ͼ��
		 *  �ض���ListServletҳ�� 
		 * */
		if(!purFlag) {
			  out.write("�Բ�������û�빺���κ���Ʒ��<br/>");
		}
		else {
			//������ʾ�û�����ͼ�����Ϣ
			out.write("�������ͼ���У�<br/>");
			double price=0;
			for(Book book :cart) {
				out.write(book .getName()+"<br/>");
			}
		}
	}
}
