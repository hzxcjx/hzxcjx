package hjzy;

public class Administrators {
	private Integer admin_id; //管理员id
	private String admin_name; //管理员用户名
	private String admin_pass; //管理员密码
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pass() {
		return admin_pass;
	}
	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}
	@Override
	public String toString() {
		return "Administrators [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_pass=" + admin_pass
				+ "]";
	}
	public Administrators(Integer admin_id, String admin_name, String admin_pass) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_pass = admin_pass;
	}
	public Administrators() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
