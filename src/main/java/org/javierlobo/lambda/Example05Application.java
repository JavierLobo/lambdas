package org.javierlobo.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.javierlobo.lambda.pojos.Product;

public class Example05Application {
		
	public static void main(String[] args) {
		List<Product> products = ExampleData.getProducts();
		
		BigDecimal priceLimit = new BigDecimal("5.00");
		
		List<Product> cheapProducts = new ArrayList();
		products.forEach(product -> {
			if (product.getPrice().compareTo(priceLimit) < 0) {
				cheapProducts.add(product);
			}
		});
		
		cheapProducts.forEach(product -> System.out.println(product));
	}
}

