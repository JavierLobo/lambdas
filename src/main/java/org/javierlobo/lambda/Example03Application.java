//package org.javierlobo.lambda;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import org.javierlobo.lambda.pojos.Product;
//
//public class Example03Application {
//	
//	interface ProductFilter {
//		boolean accept(Product product);
//	}
//	
//	static void printProducts(List<Product> products, BigDecimal priceLimit) {
//		for(Product product: products) {
//			if(product.getPrice().compareTo(priceLimit) < 0) {
//				System.out.println(product);
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		List<Product> products = ExampleData.getProducts();
//		BigDecimal priceLimit = new BigDecimal("5.00");
//		printProducts(products, priceLimit);
//
//		priceLimit = new BigDecimal("6.00");
//		ProductFilter filter = product -> product.getPrice().compareTo(priceLimit) < 0;
//		printProducts(products, priceLimit);
//		
//	}
//}
//
