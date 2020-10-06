package homeworkTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usn=req.getParameter("usn");
		if(usn==null) {
			usn="名称异常";
			
		}
		String age=req.getParameter("age");
		if(age==null) {
			age="0";
		}
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\"  text-align=\"center\" cellspacing=\"0\">");
		out.println("<tr height=\"50\">");
		out.println("<td width=\"100\">姓名</td>");
		out.println("<td width=\"100\">年龄</td>");
		out.println("<td width=\"100\">专业</td>");
		out.println("<td width=\"100\">班级</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=\"100\">"+this.getInitParameter("name")+"</td>");	
		out.println("<td width=\"100\">"+this.getInitParameter("age")+"</td>");	
		out.println("<td width=\"100\">"+getInitParameter("major")+"</td>");
		out.println("<td width=\"100\">"+getInitParameter("class")+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>"+this.getInitParameter("name")+"</td>");	
		out.println("<td>"+getInitParameter("age")+"</td>");	
		out.println("<td>"+getInitParameter("major")+"</td>");
		out.println("<td>"+getInitParameter("class")+"</td>");
		out.println("</tr>");
		
		
		
		
		out.println("<table>");
		out.println("<body>");
		out.println("<html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
