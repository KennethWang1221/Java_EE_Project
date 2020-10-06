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
		//变量cart引用用户购物车
		List<Book> cart =null;
		//变量pruFlag 标记用户是否买过商品
		boolean purFlag = true;
		//获得用户的Session
		HttpSession session =req.getSession(false);
		//如果session 为null ，purFlag置为flase
		if(session ==null) {
			purFlag=false;
					
		}
		else {
			//获得用户购物车
			cart =(List) session.getAttribute("cart");
			//如果用的购物车为null purFlag置为false
			if(cart==null) {
				purFlag=false;
			}
		}
		/*
		 * 如果purFlag 为false，表明用户没有购买图书
		 *  重定向到ListServlet页面 
		 * */
		if(!purFlag) {
			  out.write("对不起！您还没与购买任何商品！<br/>");
		}
		else {
			//否则显示用户购买图书的信息
			out.write("您购买的图书有：<br/>");
			double price=0;
			for(Book book :cart) {
				out.write(book .getName()+"<br/>");
			}
		}
	}
}
