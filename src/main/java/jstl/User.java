package jstl;

import java.util.Date;

public class User {
	private int uid;
	private String name;
	private String pwd;
	private Date regtime;

	public User() {
	}

	public User(int uid, String name, String pwd, Date regtime) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.regtime = regtime;
	}

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
}
