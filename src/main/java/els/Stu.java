package els;

public class Stu {
	private int sid;
	private String sname;
	private String idCard;
	private String tel;
	private int age;
	private String img;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param sid
	 * @param sname
	 * @param idCard
	 * @param tel
	 * @param age
	 * @param img
	 */
	public Stu(int sid, String sname, String idCard, String tel, int age, String img) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.idCard = idCard;
		this.tel = tel;
		this.age = age;
		this.img = img;
	}
	/**
	 * 
	 */
	public Stu() {
		super();
	}
	
}
