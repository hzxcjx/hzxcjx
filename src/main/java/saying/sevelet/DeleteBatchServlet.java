package saying.sevelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.sayindao;



/**
 * Servlet implementation class DeleteBatchServlet
 */
@WebServlet("/saying/DeleteBatchServlet")
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private sayindao sayingDAO = new sayindao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?sid=1&sid=2&sid=3&sid=4
		String[] sids = request.getParameterValues("sid");
		sayingDAO.deleteBatch(sids);
		request.getRequestDispatcher("ListPageServlet?curpage=1&pagesize=3&")
			.forward(request, response);
	}


}
