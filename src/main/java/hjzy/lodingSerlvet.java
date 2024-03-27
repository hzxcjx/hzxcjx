package hjzy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class lodingSerlvet
 */
@WebServlet (urlPatterns = "/loding")
public class lodingSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO类 aDao = new DAO类();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Administrators admin = aDao.serachAdmin(name, pass);
		
		if (admin!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("user", admin);
//			request.getRequestDispatcher("page").forward(request, response);
			response.sendRedirect("page");
		}
		else {
			response.sendRedirect("Loding/lodingloss.jsp");
		}
	}

}

