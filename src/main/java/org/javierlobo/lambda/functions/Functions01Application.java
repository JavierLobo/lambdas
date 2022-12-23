package org.javierlobo.lambda.functions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Functions01Application {

	final static Logger log = Logger.getLogger(Functions01Application.class);
	
	public static void main(String[] args) throws ParseException {
		List<Persona> listaPersonas = ExampleData.getPersonas();
		
		BiFunction<List<Persona>, Integer, List<Persona>> minEdad = (lista, edad) -> {
			List<Persona> resultado = new ArrayList<>();
			lista.forEach(p -> {
				if (p.getEdad() >= edad) {
					resultado.add(p);
				}
			});
			return resultado;			
		};
		
		Function<List<Persona>, String> listaAString = lista -> {			
			String resultado = "";
			for(int i = 0; i < lista.size(); i++) {
				if (i < lista.size() - 1) {
					resultado += lista.get(i).getNombre() + ", ";
				} else {
					resultado += lista.get(i).getNombre();
				}
			}
			return resultado;
		};
		
		
		List<Persona> mayoresDe5 = minEdad.apply(listaPersonas, 5);
		log.info("Personas con al menos 5 años: ");
		mayoresDe5.forEach(p -> {
			log.info(p);
		});
		
		log.info("Nombres separados por comas: ");
		log.info(listaAString.apply(listaPersonas));		
		
		// Combinacion de funciones
		
		BiFunction<List<Persona>, Integer, String> nombresAdultos = minEdad.andThen(listaAString);
		log.info("Nombres de personas adultas: ");
		log.info(nombresAdultos.apply(listaPersonas, 18));
		
	} // End Main
}

