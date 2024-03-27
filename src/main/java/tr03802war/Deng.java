package tr03802war;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deng")
public class Deng extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Connection conn;
		PreparedStatement stmt;
		String sql;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			sql = "select * from userr where username = ? and `password` = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, name);
			stmt.setObject(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				request.setAttribute("name", name);
				request.getRequestDispatcher("Servlet/Work/manager.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("Servlet/Work/LodingQuestion.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
