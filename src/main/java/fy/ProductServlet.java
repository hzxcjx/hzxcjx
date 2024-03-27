package fy;

import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import tr03802war.Product; 
@WebServlet(urlPatterns = "/fy/list") 
public class ProductServlet extends HttpServlet{ 
@Override 
protected void doGet(HttpServletRequest request,  
HttpServletResponse response) throws ServletException, IOException { 
request.setCharacterEncoding("utf-8"); 
int curpage = Integer.parseInt(request.getParameter("curpage")); 
int pagesize = Integer.parseInt(request.getParameter("pagesize")); 
try { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
   Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456"); 
   //获取当前页的数据 
   String sql = " select * from products limit ?, ?"; 
   PreparedStatement stmt = conn.prepareStatement(sql); 
   stmt.setInt(1, (curpage - 1) * pagesize); 
   stmt.setInt(2, pagesize); 
   ResultSet rs = stmt.executeQuery(); 
    
   //转换成Product的List集合 
   List<fy.Product> list = new ArrayList<>(); 
   while(rs.next()) { 
	   list.add(new fy.Product(rs.getInt(1), rs.getString(2),  
			      rs.getDouble(3)));
     
   } 
    
   //获得表中所有记录的条数 
   sql = "select count(*) from products"; 
   ResultSet rs2 = stmt.executeQuery(sql); 
   rs2.next(); 
   int total = rs2.getInt(1); //总记录数 
    
   //将数据保存到request中以便转发jsp显示  
   request.setAttribute("list", list); 
   request.setAttribute("total", total); 
    
   stmt.close(); 
   conn.close(); 
  } catch (ClassNotFoundException e) { 
   e.printStackTrace(); 
  } catch (SQLException e) { 
   e.printStackTrace(); 
  } 
   
  //转到jsp 
  request.getRequestDispatcher("list.jsp") 
   .forward(request, response); 
 } 
} 
