package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Statistics01Application {

	final static Logger log = Logger.getLogger(Statistics01Application.class);
	
	public static void main(String[] args) throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");

		// Optener el mayor valor de una lista
		Optional<Persona> adultoMayor = ExampleData.getPersonas().stream()
				.max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		if (adultoMayor.isPresent()) {
			log.info("La persona más mayor es " + adultoMayor.get().getNombre()+
					" con " + adultoMayor.get().getEdad() + " años de edad.");
		} else {
			log.info("No se han encontrado personas que cumplan el requisito");
		}

		// Optener el menor valor de una lista
		Optional<Persona> adultoMenor = ExampleData.getPersonas().stream()
				.min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		if (adultoMayor.isPresent()) {
			log.info("La persona más menor es " + adultoMenor.get().getNombre() +
					" con " + adultoMenor.get().getEdad() + " años de edad.");
		} else {
			log.info("No se han encontrado personas que cumplan el requisito");
		}

		// Optener las medias de las edades
		OptionalDouble mediaDeEdadesToDbl = ExampleData.getPersonas().stream()
				.mapToDouble(p -> p.getEdad())
				.average();

		OptionalDouble mediaDeEdadesToInt = ExampleData.getPersonas().stream()
				.mapToInt(p -> p.getEdad())
				.average();

		if (mediaDeEdadesToDbl.isPresent()) {
			log.info("(mediaDeEdadesToDbl) La media de las edades es " + mediaDeEdadesToDbl.getAsDouble());
		} else {
			log.info("No se puede calcular la media");
		}
		if (mediaDeEdadesToInt.isPresent()) {
			log.info("(mediaDeEdadesToInt) La media de las edades es " + mediaDeEdadesToInt.getAsDouble());
		} else {
			log.info("No se puede calcular la media");
		}

		log.info("MEDIA DE LAS EDADES MAYORES DE EDAD");
		OptionalDouble mediaDeEdadesDeAdultos = ExampleData.getPersonas().stream()
				.filter(p->p.getEdad() >= 18)
				.mapToDouble(p -> p.getEdad())
				.average();

		if (mediaDeEdadesDeAdultos.isPresent()) {
			log.info("(mediaDeEdadesDeAdultos) La media de las edades es " + mediaDeEdadesDeAdultos.getAsDouble());
		} else {
			log.info("No se puede calcular la media");
		}

	} // End Main
}

