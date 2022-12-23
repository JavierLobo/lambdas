package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Sorted02Application {

	final static Logger log = Logger.getLogger(Sorted02Application.class);
	
	public static void main(String[] args) throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");

		log.info("Personas ordenadas de mayor a menor edad: ");
		Comparator<Persona> cEdad = (p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad());
		Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());

		ExampleData.getPersonas().stream()
				.sorted(cEdad)
				.limit(3)
				.map( p -> p.getNombre())
				.forEach(log::info);

	} // End Main
}

