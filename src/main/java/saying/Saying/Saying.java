package saying.Saying;

import java.util.Date;

public class Saying {
	private int sid;
	private String user;
	private String content;
	private Date time;

	public Saying() {
		// TODO Auto-generated constructor stub
	}

	public Saying(int sid, String user, String content, Date time) {
		super();
		this.sid = sid;
		this.user = user;
		this.content = content;
		this.time = time;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
