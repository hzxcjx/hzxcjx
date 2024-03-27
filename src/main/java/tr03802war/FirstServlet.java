package tr03802war;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置编码
		String name = request.getParameter("name");//获取请求参数
		response.setContentType("text/html;charset=utf-8");
		
		//将数据保存到request中
		request.setAttribute("name", name);
		//转到jsp
		request.getRequestDispatcher("Servlet/r.jsp").forward(request, response);
		
//		PrintWriter out = response.getWriter();//获取输出对象
//		out.print(name+",你好!");//输出到浏览器
//		out.close();
	}
}
