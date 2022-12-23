package org.javierlobo.lambda.pojos;

import java.math.BigDecimal;
import java.util.Objects;

import org.javierlobo.lambda.Category;

public class Product {

	private final Category category;
	private final String name;
	private final BigDecimal price;
	
	public Product() {
		this.name = "";
		this.price = null;
		this.category = null;
	}

	public Product(Category category, String name, BigDecimal price) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("Product [category=%-10s, name=%-16s, price=%6.2f]", category, name, price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Product other = (Product) obj;
		
		return category == other.category && Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	

	
	
	
}
