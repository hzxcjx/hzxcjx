package jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicationDAO {
	public List<Medication> queryAll(){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		PreparedStatement stmt = conn.prepareStatement("select * from timer");
		ResultSet rs = stmt.executeQuery();
		List<Medication> list = new ArrayList<>();
		while(rs.next()) {
			
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
}
