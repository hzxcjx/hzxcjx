package newspaper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import saying.Saying.Saying;
import saying.dao.Mapper;

public class newspaperDAO extends BaseDAO{
	
	
	public int save(String user,String bt, String content) {
		String sql = "insert into news(nid, nname ,nsource, timee) values(?,?,?, now())";
		return this.execute(sql, user,bt, content);
	}
	public int delete() {
		String sql = "delete from news where timee < DATE_SUB(NOW(), INTERVAL 1 MONTH)";
		return this.execute(sql);
	}
	public List<newspaper> query(){
		String sql = "select * from news order by nid desc";
		return this.executeQuery(sql, new Mapper<newspaper>() {
			@Override
			public List<newspaper> map(ResultSet rs) throws SQLException {
				List<newspaper> list = new ArrayList<>();
				while(rs.next()) {
					newspaper saying = new newspaper(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(saying);
				}
				return list;
			}
		});
	}
	public Map<String, Object> queryByPage(int curpage, int pagesize){
		String sql = "select * from news order by nid desc limit ?,?";
		List<newspaper> list = this.executeQuery(sql, new Mapper<newspaper>() {
			@Override
			public List<newspaper> map(ResultSet rs) throws SQLException {
				List<newspaper> list = new ArrayList<>();
				while(rs.next()) {
					newspaper saying = new newspaper(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(saying);
				}
				return list;
			}
		}, (curpage - 1) * pagesize, pagesize);
		
		String sql2 = "select count(*) c from news";
		Object obj = this.singleObject(sql2);
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", obj);
		return map;
	}
}
