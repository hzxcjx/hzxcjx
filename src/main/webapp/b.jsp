<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 获取表单数据
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // 连接数据库
    String url = "jdbc:mysql://localhost:3306/tr03802";
    String user = "root";
    String pass = "123456";
    Connection conn = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);

        // 查询用户表验证登录
        String sql = "SELECT id FROM users WHERE username=? AND pass=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            // 登录成功，将用户名保存到Session中
            session.setAttribute("username", username);
            response.sendRedirect("c.jsp");
        } else {
            // 登录失败
            out.println("用户名或密码错误");
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
%>