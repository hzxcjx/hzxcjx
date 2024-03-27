package tr03802war;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ShopCartDB extends ShopCart {
	/**
	 *从商品 
	 */
	@Override
	public Product getProduct(int pid) {
		try {
			//定义登陆sql
			String sql ="select * from products where pid=?";

			//通过jdbc执行sql
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,pid);
			ResultSet rs = stmt.executeQuery();
			System.err.println(stmt);
			if(rs.next()){
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("pname"));
				p.setCount(1);
				p.setPrice(rs.getDouble("price"));
				return p;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return null;
	}
}	
