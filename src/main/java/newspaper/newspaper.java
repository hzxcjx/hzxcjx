package newspaper;

import java.util.Date;
import java.util.Objects;

import com.alibaba.fastjson2.JSONObject;

public class newspaper {
	private int sid;
	private String user;
	private String bt;
	private String content;
	private Date time;
	public int getSid() {
		return sid;
	}
	
	public newspaper() {
		super();
	}

	public newspaper(int sid, String user, String bt, String content, Date time) {
		super();
		this.sid = sid;
		this.user = user;
		this.bt = bt;
		this.content = content;
		this.time = time;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
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
	@Override
	public int hashCode() {
		return Objects.hash(bt, content, sid, time, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		newspaper other = (newspaper) obj;
		return Objects.equals(bt, other.bt) && Objects.equals(content, other.content) && sid == other.sid
				&& Objects.equals(time, other.time) && Objects.equals(user, other.user);
	}
	public newspaper(int sid, String user, String content, Date time) {
		super();
		this.sid = sid;
		this.user = user; 
		this.content = content;
		this.time = time;
	}
	@Override
	public String toString() {
		return "newspaper [sid=" + sid + ", user=" + user + ", bt=" + bt + ", content=" + content + ", time=" + time
				+ "]";
	}
	public static void main(String[] args) {
		newspaper news=new newspaper(0, null, null, null);
		System.out.println(JSONObject.toJSONString(news));
	}
	
}
