<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 判断是否登录
    String username = (String) session.getAttribute("username");
    if (username == null) {
        // 未登录，跳转到登录页面
        response.sendRedirect("b.jsp");
    } else {
        // 已登录，展示留言板
        out.println("<h2>当前用户：" + username + "</h2>");
        out.println("<h3>发表留言</h3>");
        out.println("<form action=\"d.jsp\" method=\"POST\">");
        out.println("<textarea name=\"content\" rows=\"5\" cols=\"50\" required></textarea><br>");
        out.println("<input type=\"submit\" value=\"提交留言\">");
        out.println("</form>");

        out.println("<h3>所有留言</h3>");

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/tr03802";
        String user = "root";
        String pass = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);

            // 查询所有留言
            String sql = "SELECT mag.content, users.username FROM mag INNER JOIN users ON mag.user_id = users.id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                do {
                    String content = rs.getString("content");
                    String author = rs.getString("username");
                    out.println("<p>" + author + ": " + content + "</p >");
                } while (rs.next());
            } else {
                out.println("暂无留言");
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