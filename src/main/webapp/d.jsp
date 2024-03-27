<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
    // 判断是否登录
    String username = (String) session.getAttribute("username");
    if (username == null) {
        // 未登录，跳转到登录页面
        response.sendRedirect("b.jsp");
    } else {
        // 已登录，处理添加留言请求
        String content = request.getParameter("content");

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/tr03802";
        String user = "root";
        String pass = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);

            // 查询当前用户ID
            String sql = "SELECT id FROM users WHERE username=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");

                // 插入留言数据
                sql = "INSERT INTO mag (user_id, content, create_time) VALUES (?, ?, NOW())";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, userId);
                stmt.setString(2, content);
                stmt.executeUpdate();

                response.sendRedirect("c.jsp");
            } else {
                out.println("未找到用户");
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
%>