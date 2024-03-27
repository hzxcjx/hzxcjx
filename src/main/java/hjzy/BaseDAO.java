package hjzy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**JDBC封装的基本结构
 * 1、三个对象和四个字符串
 * 2、一个静态块（加载驱动）
 * 3、获取连接对象
 * 4、关闭资源
 */

public class BaseDAO {
	//①连接对象
		protected Connection conn;
		//②预编译执行对象
		protected PreparedStatement stmt;
		//③结果集对象
		protected ResultSet rs;
		//第一个字符串：mysql驱动包的全类名
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	//第二个字符串：mysql服务器的连接地址
	private final String URL="jdbc:mysql://127.0.0.1:3306/tr03802?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8";
	//第三个字符串：mysql服务器的用户名
	private final String USER="root";
	//第四个字符串：mysql服务器的密码
	private final String PWD="123456";
	static {
		//利用静态块加载驱动（自动执行且执行一次，类对象创建之前）
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败，请确认是否导入了mysql的jar包");
			e.printStackTrace();
		}
	}
	//获取连接对象
	public Connection getConn() throws SQLException {
		if (conn==null || conn.isClosed()) {
			conn = DriverManager.getConnection(URL, USER, PWD);
		}
		return conn;
	}
	//关闭连接，释放资源
	public void closeAll() {
		if (rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("结果集已被关闭...");
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

