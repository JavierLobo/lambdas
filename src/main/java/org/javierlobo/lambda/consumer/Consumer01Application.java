package org.javierlobo.lambda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.javierlobo.lambda.pojos.Persona;

public class Consumer01Application {

	final static Logger log = Logger.getLogger(Consumer01Application.class);

	static void procesar(List<Persona> personas, Consumer<Persona> c) {
		personas.forEach(c::accept);
	}
	
	public static void main(String[] args) {
		List<Persona> listaPersonas = new ArrayList<>();

		listaPersonas.add(new Persona("NACHO", 42, null, null, null, null));
		listaPersonas.add(new Persona("JUAN", 78, null, null, null, null));
		listaPersonas.add(new Persona("MARIO", 7, null, null, null, null));
		listaPersonas.add(new Persona("LAURA", 4, null, null, null, null));
		listaPersonas.add(new Persona("MAY", 41, null, null, null, null));
		listaPersonas.add(new Persona("Enrique", 42, null, null, null, null));
		
		Consumer<Persona> imprimir = log::info;
		procesar(listaPersonas, imprimir);
		
//		Consumer<Persona> imprimir = p -> log.info(p);
//		listaPersonas.forEach(p -> {
//			log.info(p);
//		});
		
	} // End Main
}

