package denglu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regServlet
 */

@WebServlet(urlPatterns = "/denglu/reg")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersDAO dao = new UsersDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Users user = new Users(0, name, pwd, phone, address, address);
		if (dao.insert(user)>0) {
			request.getRequestDispatcher("deng.jsp").forward(request, response);
		}
	}

}
