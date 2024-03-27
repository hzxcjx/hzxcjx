package els;

public class Pro {
	private int id;
	private String name;
	private String img;
	private double price;
	private String add;
	private String color;
	private String guige;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * @param id
	 * @param name
	 * @param img
	 * @param price
	 * @param add
	 * @param color
	 * @param guige
	 */
	public Pro(int id, String name, String img, double price, String add, String color, String guige) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.add = add;
		this.color = color;
		this.guige = guige;
	}
	/**
	 * 
	 */
	public Pro() {
		super();
	}
	
	
}
