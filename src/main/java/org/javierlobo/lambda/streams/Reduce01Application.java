package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Reduce01Application {

	final static Logger log = Logger.getLogger(Reduce01Application.class);
	
	public static void main(String[] args) throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");

		log.info("Personas ordenadas de mayor a menor edad: ");
		//Oobtenemos una cadena de texto larga con los nombres
		Integer sumaDeEdades = ExampleData.getPersonas().stream()
				.mapToInt( p -> p.getEdad() )
				.reduce(0, (e1, e2) -> e1 + e2);

		log.info("Suma total de edades: " + sumaDeEdades);

		if  (ExampleData.getPersonas().stream().allMatch(p->p.getEdad() >= 18)) {
			log.info("Hay al menos un adulto en el grupo!!");
		} else {
			log.info("No hay un adulto en el grupo");
		}
	} // End Main
}

