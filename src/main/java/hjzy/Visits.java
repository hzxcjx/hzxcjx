package hjzy;

import java.sql.Timestamp;

/**
* 来访登记表
*/
public class Visits {
	private Integer visit_id; //来访id
	private String cars_number; //车牌号
	private String visit_phone;//手机号
	private Timestamp reg_time; //注册时间
	private Timestamp start_time; //开始时间
	private Timestamp end_time; //结束时间
	private String reason_text; // 来访事由
	private String permission_text; // 访客权限
	private String state; //状态
	private String notes; //备注
	
	public Integer getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(Integer visit_id) {
		this.visit_id = visit_id;
	}
	public String getCars_number() {
		return cars_number;
	}
	public void setCars_number(String cars_number) {
		this.cars_number = cars_number;
	}
	public String getVisit_phone() {
		return visit_phone;
	}
	public void setVisit_phone(String visit_phone) {
		this.visit_phone = visit_phone;
	}
	public Timestamp getReg_time() {
		return reg_time;
	}
	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getReason_text() {
		return reason_text;
	}
	public void setReason_text(String reason_text) {
		this.reason_text = reason_text;
	}
	public String getPermission_text() {
		return permission_text;
	}
	public void setPermission_text(String permission_text) {
		this.permission_text = permission_text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Visits [visit_id=" + visit_id + ", cars_number=" + cars_number + ", visit_phone=" + visit_phone
				+ ", reg_time=" + reg_time + ", start_time=" + start_time + ", end_time=" + end_time + ", reason_text="
				+ reason_text + ", permission_text=" + permission_text + ", state=" + state + ", notes=" + notes + "]";
	}
	public Visits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visits(Integer visit_id ,String cars_number, String visit_phone,Timestamp reg_time, Timestamp start_time, Timestamp end_time,String state, String reason_text,
			String permission_text, String notes) {
		super();
		this.visit_id = visit_id;
		this.cars_number = cars_number;
		this.visit_phone = visit_phone;
		this.reg_time = reg_time;
		this.start_time = start_time;
		this.end_time = end_time;
		this.state = state;
		this.reason_text = reason_text;
		this.permission_text = permission_text;
		this.notes = notes;
	}
	
	
}

