package tr03802war;

import java.util.ArrayList;
import java.util.List;


public class Store{
	public static List<Product> products;
	
	static {
		products = new ArrayList<>();
		products.add(new Product(1, "双倍648", 648, 98));
		products.add(new Product(2, "双倍328", 328, 68));
		products.add(new Product(3, "双倍168", 168, 100));
		products.add(new Product(4, "双倍98", 98, 88));
		products.add(new Product(5, "双倍30", 30, 120));
		products.add(new Product(6, "双倍6", 6, 1000));
	}
}
