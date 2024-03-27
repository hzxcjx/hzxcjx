package	els;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/use")
public class Use extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置编码
		Map<String, Stu> map=new HashMap<String, Stu>();
		map.put("12345678902",new Stu(1, "张三", "430522200302126785","12345678902", 18, "image/7.png") );
		request.setAttribute("map", map);
		request.getRequestDispatcher("el/user.jsp").forward(request, response);
	
	}
}
