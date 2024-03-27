package AJAX;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 学生
 * 
 * @author LiZanhong
 *
 */
public class Student {
	private int sid;
	@JSONField(name = "n")
	private String name;
	private String sex;
	private String phone;
	@JSONField(format = "yyyy-MM-dd")
	private Date birthday;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, String sex, String phone) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}



	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public static void main(String[] args) {
		//定义学生对象
		//java对象
		Student stu = 
			new Student(1, "张三", "男", "1897654355");
		stu.setBirthday(new Date());
		
		Student stu2 = 
				new Student(2, "李四", "男", "1897654355");
		
		String json = "{sid:" + stu.getSid() 
			+ ",name:'" + stu.getName() 
			+ "',sex:'" + stu.getSex()
			+ "',phone:'" +stu.getPhone() + "'}";
		
		System.out.println(json);
		
		//1、将java对象和集合转换成json字符串
		//对象
		System.out.println(JSONObject.toJSONString(stu));
		//集合
		List<Student> list = new ArrayList<>();
		list.add(stu);
		list.add(stu2);
		System.out.println(JSONArray.toJSONString(list));
		
	}
}







