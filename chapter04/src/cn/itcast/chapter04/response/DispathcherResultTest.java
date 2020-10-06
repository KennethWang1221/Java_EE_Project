package cn.itcast.chapter04.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispathcherResultTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//获取request请求对象中保存的数据
				String usninfo = (String)req.getAttribute("username");
				if(usninfo != null){
					out.println("该用户的账号是："+usninfo+"<br>");
				}
		
				String psdinfo = (String)req.getAttribute("password");
				if(psdinfo != null){
					out.println("该用户的密码是："+psdinfo+"<br>");
				}

	}



	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			this.doGet(req, resp);
		}
	}
