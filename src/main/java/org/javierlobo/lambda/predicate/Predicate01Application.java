package org.javierlobo.lambda.predicate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Predicate01Application {

	final static Logger log = Logger.getLogger(Predicate01Application.class);
	
	static List<Persona> filtrar(List<Persona> personas, Predicate<Persona> predicado) {
		List<Persona> resultado = new ArrayList<>();
		
		personas.forEach(p -> {
			if (predicado.test(p)) {
				resultado.add(p);
			}
		});
		return resultado;		
	}
	
	public static void main(String[] args)  {
		BasicConfigurator.configure();
		Predicate01Application app = new Predicate01Application();
		try {
			app.runMe("texto de ejemplo");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void runMe(String parameters) throws ParseException {
				
		List<Persona> listaPersonas = ExampleData.getPersonas();
		
		// Metodo anonimo
		Predicate<Persona> adultos = new Predicate<Persona>() {
			@Override
			public boolean test(Persona p) {
				return p.getEdad() >= 18;
			}
		};
		
		// Lambda
		List<Persona> menores = filtrar(listaPersonas, p -> p.getEdad() < 18);
		log.info("Listado de personas menores");
		menores.forEach(p -> {
//			System.out.println(p);
			log.info(p.toString());
		});
		
		// Filtrado complejo
		Predicate<Persona> pAdulto  = p -> p.getEdad() >= 18;
		Predicate<Persona> pNombreM = p -> p.getNombre().startsWith("M");
//		Predicate<Persona> pCasados = p -> p.getEstadoCivil() == 1;

		log.info("Listado de personas menores");
		List<Persona> adultosMayorEdad = filtrar(listaPersonas, pAdulto.and(pNombreM));
		adultosMayorEdad.forEach(p -> {
			log.info(p);
		});
	} // End Main
}

