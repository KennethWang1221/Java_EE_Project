package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownManagerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		//获取referer的值
		String referer=req.getHeader("referer");
		String sitePart="http://"+req.getServerName();
		//判断referer 头是否为空，这个头的首地址是否以sitePart开始的
		if(referer!=null && referer.startsWith(sitePart)) {
			//处理正在下载的请求
			out.println("dealing download...");
		}
		else {
			//非法下载请求跳转到download.html 页面
			RequestDispatcher rd=req.getRequestDispatcher("/download.html");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
 
}
