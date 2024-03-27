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

@WebServlet(urlPatterns = "/zhu")
public class zhu extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String nickname = request.getParameter("nickname");
		String tel = request.getParameter("tel");
		String sql;
		Connection conn;
		PreparedStatement stmt;
		PreparedStatement stmm;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			sql = "SELECT * FROM userr  WHERE username = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setObject(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				response.sendRedirect("Servlet/Work/geiquestion.jsp");
			}
			else {
				sql = "INSERT INTO userr VALUES(NULL,?,?,?,?)";
				stmm = conn.prepareStatement(sql);
				stmm.setObject(1, nickname);
				stmm.setObject(2, name);
				stmm.setObject(3, pwd);
				stmm.setObject(4, tel);
				stmm.executeUpdate();
				response.sendRedirect("Servlet/Work/Loding.jsp");
			}
			
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
