package RefreshWebHomework;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceFileTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=utf-8");
		ServletContext context=this.getServletContext();
		PrintWriter out= resp.getWriter();
		//获取相对路径中的输入流对象
		InputStream in= context
				.getResourceAsStream("/WEB-INF/classes/ResourceFileTest.properties");
		Properties pros=new Properties();
		pros.load(in);
		out.println("StudentName="+pros.getProperty("StudentName")+"<br/>");
		out.println("StudentNumber="+pros.getProperty("StudentNumber")+"<br/>");
		out.println("School="+pros.getProperty("School")+"<br/>");
		out.println("Major="+pros.getProperty("Major")+"<br/>");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
