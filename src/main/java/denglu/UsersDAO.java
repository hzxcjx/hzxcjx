package denglu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersDAO extends BaseDAO{
	//登录
	public List<Users> dengLv(String name,String passwrod) {
		String sql = "select * from userr where username =? and passwordd = ?";
		return this.executeQuery(sql, new Mapper<Users>() {

			public List<Users> map(ResultSet rs) throws SQLException {

				List<Users> list = new ArrayList<Users>();
				if(rs.next()) {
					list.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				}
				return list;
			}
		}, name,passwrod);
	}
	
	//修改图片路径
	public Integer headUpdate(Integer uid,String head) {
		String sql = "update userr set avatar = ? where id = ?";
		List<Users> list = new ArrayList<Users>();
		return this.execute(sql, head,uid);
	}
	//添加用户
	public Integer insert(Users user) {
		String sql = "INSERT INTO userr VALUES (null,?,?,?,?,?)";
		List<Users> list = new ArrayList<Users>();
		return this.execute(sql,user.getUsername(),user.getAddress(),user.getPhone(),user.getAddress(),user.getAvatar());
	}
}

