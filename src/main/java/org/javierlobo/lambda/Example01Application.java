package org.javierlobo.lambda;

import java.util.Comparator;
import java.util.List;

import org.javierlobo.lambda.pojos.Product;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class Example01Application {

	public static void main(String[] args) {
//		SpringApplication.run(Example01Application.class, args);
		List<Product> products = ExampleData.getProducts();
		
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getPrice().compareTo(p2.getPrice());
			}
		});
		
		for(Product product: products) {
			System.out.println(product);
		}
		
	}

}
