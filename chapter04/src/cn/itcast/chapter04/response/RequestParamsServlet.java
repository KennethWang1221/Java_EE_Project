package cn.itcast.chapter04.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParamsServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		String name=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("用户名："+name);
		System.out.println("密码："+password);
		//获取参数名为“hobby”的值
		String [] hobbys=req.getParameterValues("hobby");
		System.out.println("爱好");
		for(int i=0;i<hobbys.length;i++) {
			System.out.println(hobbys[i]+",");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
}
