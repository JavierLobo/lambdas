package org.javierlobo.lambda.streams;

import java.text.ParseException;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.BiFunction;
//import java.util.function.Function;
//import java.util.stream.Stream;
//import org.javierlobo.lambda.pojos.Persona;

public class Streams01Application {

	final static Logger log = Logger.getLogger(Streams01Application.class);
	
	public static void main(String[] args) throws ParseException {
//		Stream<Persona> streamPersonas = ExampleData.getPersonas().stream();
//		Stream<Persona> adultos = streamPersonas.filter(p -> p.getEdad() >= 18);
//
//		log.info("Personas adultas: ");
//		adultos.forEach( p -> {
//			log.info(p);
//		});

//		log.info("Personas adultas: ");
//		ExampleData.getPersonas().stream()
//				.filter(p -> p.getEdad() >= 18)
//				.filter(p -> p.getNombre().startsWith("M"))
//				.forEach(p -> log.info(p));

		log.info("Personas adultas: ");
		ExampleData.getPersonas().stream()
				.filter(p -> p.getEdad() >= 18 && p.getNombre().startsWith("M"))
				.forEach(p -> log.info(p));

	} // End Main
}

