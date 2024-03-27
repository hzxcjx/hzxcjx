package saying.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import saying.Saying.Saying;
import saying.VO.ChartDCVO;



public class sayindao {
	/**
	 * 批量删除留言
	 * @param sids
	 */
	public void deleteBatch(String[] sids) {
		if(sids == null) return;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			PreparedStatement stmt = null;
			String sql = "delete from saying where sid=?";
			for(String sid : sids) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, sid);
				stmt.executeUpdate();
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 留言
	 * @param user 用户名
	 * @param content 留言内容
	 */
	public void insert(String user, String content) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "insert into saying(suser, scontent, stime) values(?,?, now())";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, content);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询留言列表
	 * @return
	 */
	public List<Saying> query(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "select * from saying order by sid desc";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Saying> list = this.map(rs);
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
	
	/**
	 * 分页查询留言
	 * @return
	 */
	public Map<String, Object> queryByPage(int curpage, int pagesize){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "select * from saying order by sid desc limit ?,? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (curpage - 1) * pagesize);
			stmt.setInt(2, pagesize);
			ResultSet rs = stmt.executeQuery();
			List<Saying> list = this.map(rs);
			//将list添加到map集合中
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			//计算总的记录数
			sql = "select count(*) c from saying";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt("c");
			map.put("total", total);
			
			rs.close();
			stmt.close();
			conn.close();
			
			return map;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将ResultSet转换成List
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Saying> map(ResultSet rs) throws SQLException {
		List<Saying> list = new ArrayList<>();
		while(rs.next()) {
			Saying saying = new Saying(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getTimestamp(4));
			list.add(saying);
		}
		return list;
	}
	
	/**
	 * 统计每日留言数
	 * @return
	 */
	public List<ChartDCVO> chartDc(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "select DATE_FORMAT(stime, '%Y-%m-%d') d, count(*) c from saying group by DATE_FORMAT(stime, '%Y-%m-%d')";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<ChartDCVO> list = new ArrayList<>();
			while(rs.next()) {
				ChartDCVO vo = new ChartDCVO(
					rs.getDate("d"),
					rs.getInt("c")
				);
				list.add(vo);
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
		sayindao dao = new sayindao();
		dao.insert("张三", "这个网站对我帮助很大。");
	}
}

