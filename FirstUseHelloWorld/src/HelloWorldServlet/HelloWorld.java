package HelloWorldServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SecureCacheResponse;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.omg.CORBA.ServerRequest;

public class HelloWorld extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = res.getWriter();
		
		out.println("Hello World aggaaahhh");
		out.println("First USe !!!");
	}

	
}
