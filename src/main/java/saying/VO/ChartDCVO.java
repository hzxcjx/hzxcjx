package saying.VO;

import java.util.Date;

public class ChartDCVO {
	private Date date;
	private int count;
	
	public ChartDCVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ChartDCVO(Date date, int count) {
		super();
		this.date = date;
		this.count = count;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
