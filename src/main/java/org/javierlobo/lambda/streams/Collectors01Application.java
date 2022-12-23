package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Collectors01Application {

	final static Logger log = Logger.getLogger(Collectors01Application.class);
	
	public static void main(String[] args) throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");

		log.info("Personas ordenadas de mayor a menor edad: ");
		List<Persona> adultos = ExampleData.getPersonas().stream()
				.filter(p -> p.getEdad() >= 18)
				.collect(Collectors.toList());

		log.info("Listado de personas adultas: ");
		adultos.forEach(log::info);

		//Oobtenemos una cadena de texto larga con los nombres
		String nombresDeAdultos = ExampleData.getPersonas().stream()
				.filter(p -> p.getEdad() >= 18)
				.map( p -> p.getNombre() )
				.collect(Collectors.joining(", ", "Los nombres de todos los adultos son: ", ". Fin!"));

		log.info(nombresDeAdultos);
	} // End Main
}

