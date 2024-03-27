package els;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class call
 */
@WebServlet("/EL/callServlet")
public class call extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String o = request.getParameter("o");
		
		double r = 0;
		if("+".equals(o)) {
			r = a + b;
		}
		else if("-".equals(o)){
			r = a - b;
		}
		else if("*".equals(o)) {
			r = a * b;
		}
		else if("/".equals(o)) {
			
		}
		else if("%".equals(o)) {
			r = a % b;
		}
		
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("o", o);
		request.setAttribute("r", r);
		request.getRequestDispatcher("call.jsp").forward(request, response);
	}

}
