package saying.sevelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.VO.ChartDCVO;
import saying.dao.sayindao;



/**
 * Servlet implementation class ChartDCServlet
 */
@WebServlet("/saying/ChartDCServlet")
public class ChartDCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private sayindao sayingDAO = new sayindao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChartDCVO> list = sayingDAO.chartDc();
		
		//��������
		int total = 0;
		for(ChartDCVO vo: list) {
			total += vo.getCount();
		}
		request.setAttribute("total", total);
		request.setAttribute("list", list);
		request.getRequestDispatcher("chart.jsp")
			.forward(request, response);
	}

}






