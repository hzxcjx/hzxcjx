package tr03802war;

import java.util.ArrayList;
import java.util.List;


public class ShopCart {
	//将购买的商品保存到List集合中
	private List<Product> list = new ArrayList<>();
	
	/**
	 * 商品在List中是否存在？
	 * @param p
	 * @return 如果商品存在，则返回该商品，如果不存在，则返回null
	 */
	private Product contains(int pid) {
		for(Product o: list) {
			if(o.getPid() == pid)
				return o;
		}
		return null;
	}
	
	public Product getProduct(int pid) {
		System.err.println(pid+"11");
		for(Product p:Store.products) {
			if(p.getPid()==pid) {
				System.err.println(pid);
				return p;
			}
		}
		return null;
	}
	
	
	/**
	 * 新增商品
	 * 如果List中已经存在该商品，则修改数量，如果不存在，则添加
	 * @param p
	 */
	public void addNew(Integer pid) {
		Product tmp = this.contains(pid);//从购物车中找到对应的商品
		Product p = this.getProduct(pid);//从仓库中找到对应的商品
		if(tmp == null) {
			//商品不存在，则新增商品
			Product np = new Product();//创建新商品
			np.setPid(p.getPid());
			np.setName(p.getName());
			np.setCount(1);
			np.setPrice(p.getPrice());
			np.setTotal(np.getPrice()*np.getCount());
			this.list.add(np);
		}else {
			//商品存在，则修改数量
			tmp.setCount(tmp.getCount() + 1);//数量加1
			tmp.setTotal(tmp.getPrice() * tmp.getCount());
		}
	}
	
	/**
	 * 移除商品
	 * @param pid
	 */
	public void remove(int pid) {
		for(Product p: this.list) {
			if(p.getPid() == pid) {
				this.list.remove(p);
				break;
			}
		}
	}
	
	/**
	 * 清空
	 */
	public void clear() {
		this.list.clear();
	}
	
	/**
	 * 修改商品数量
	 * @param pid
	 * @param newCount
	 */
	public void modify(int pid, int newCount) {
		Product p = this.contains(pid);//根据pid找到商品对象
		p.setCount(newCount);//修改数量
		p.setTotal(p.getPrice() * p.getCount());
	}
	
	/**
	 * 获得所有的商品
	 * @return
	 */
	public List<Product> getAll(){
		return this.list;
	}
}
