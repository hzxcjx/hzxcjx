package hjzy;

public class DAO类 extends BaseDAO{
	//查询管理员表
		public Administrators serachAdmin(String name,String pass) {
			String sql = "SELECT * FROM administrators WHERE admin_name= ? AND admin_pass = ?";
			try {
				stmt=getConn().prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, pass);
				rs = stmt.executeQuery();
				if (rs.next()) {
					Administrators adm = new Administrators(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3));
					return adm;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} finally {
				closeAll();
			}
			
			return null;
		}
}
