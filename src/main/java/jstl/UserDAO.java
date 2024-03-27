package jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jstl.User;

/**
 * 封装用户的数据访问操作
 * @author LiZanhong
 *
 */
public class UserDAO {
	/**
	 * 返回所有的用户
	 * @return
	 */
	public List<User> queryAll(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			PreparedStatement stmt = conn.prepareStatement("select * from user");
			ResultSet rs = stmt.executeQuery();
			List<User> list = new ArrayList<>();
			while(rs.next()) {
				User user = new User(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getTimestamp(4));
				list.add(user);
			}
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new UserDAO().queryAll());
	}
}