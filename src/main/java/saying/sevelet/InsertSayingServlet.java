package saying.sevelet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.sayindao;

@WebServlet(urlPatterns = "/insert")
public class InsertSayingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private sayindao sdao = new sayindao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户输入的留言
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String content = request.getParameter("content");
		//保存留言
		sdao.insert(user, content);
		//跳转到留言列表
		response.sendRedirect("");
	}

}
