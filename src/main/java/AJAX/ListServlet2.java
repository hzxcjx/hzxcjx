package AJAX;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

import saying.Saying.Saying;
import saying.dao.SayingDAO;
import saying.dao.sayindao;

/**
 * 留言列表
 */
@WebServlet("/saying/ListServlet2")
public class ListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SayingDAO sayingDAO = new SayingDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Saying> list = sayingDAO.query();
		//转换成json数组
		String array = JSONArray.toJSONString(list);
		//将json数组返回到客户端浏览器
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}

