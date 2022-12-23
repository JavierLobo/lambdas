package org.javierlobo.lambda;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.javierlobo.lambda.pojos.Persona;
import org.javierlobo.lambda.pojos.Product;

public class ExampleData {

	public static List<Product> getProducts() {
		return Arrays.asList(
			new Product(Category.FOOD, "Oranges", new BigDecimal("1.65")),
			new Product(Category.FOOD, "Gouda cheese", new BigDecimal("6.79")),
			new Product(Category.UTENSILS, "Plates", new BigDecimal("12.95")),
			new Product(Category.FOOD, "peras", new BigDecimal("1.75")),
			new Product(Category.FOOD, "manzanas", new BigDecimal("1.95")) 
		);
	}
	
	public static List<Persona> getPersonas() throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");
		
		return Arrays.asList(
			new Persona("NACHO", 42, "05/04/1957" , null, null, null),
			new Persona("JUAN", 78, "05/04/1957" , null, null, null),
			new Persona("MARIO", 7, "05/04/1957" , null, null, null),
			new Persona("LAURA", 4, "05/04/1957" , null, null, null),
			new Persona("Enrique", 42, "05/04/1957" , null, null, null),
			new Persona("MAY", 41, "05/04/1957" , null, null, null)
		);

	}
}
