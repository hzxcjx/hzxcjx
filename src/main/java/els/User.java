package els;

import java.util.Date;

/**
* @Description: 
* @author: 惠
* @date 2024年1月15日 上午9:12:53
*/
public class User {
	private int uid;
	private String name;
	private Date birthday;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(int uid, String name, Date birthday) {
		super();
		this.uid = uid;
		this.name = name;
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
