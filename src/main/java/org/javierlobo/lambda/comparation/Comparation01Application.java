package org.javierlobo.lambda.comparation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.javierlobo.lambda.pojos.Persona;

public class Comparation01Application {
	
	public static void main(String[] args) {
		List<Persona> listaPersonas = new ArrayList<>();

		listaPersonas.add(new Persona("NACHO", 42, null, null, null, null));
		listaPersonas.add(new Persona("JUAN", 78, null, null, null, null));
		listaPersonas.add(new Persona("MARIO", 7, null, null, null, null));
		listaPersonas.add(new Persona("LAURA", 4, null, null, null, null));
		listaPersonas.add(new Persona("MAY", 41, null, null, null, null));
		listaPersonas.add(new Persona("Enrique", 42, null, null, null, null));
		
		// Ordenar de menor a mayor edad usando una clase tradicional
		ComparadorPersonas cp = new ComparadorPersonas();
		listaPersonas.sort(cp);
		System.out.println("Personas Ordenadas de menor a mayor edad: ");
		
		for(Persona p: listaPersonas) {
			System.out.println(p);
		}
		
		// Ordenar de mayor a menor edad usando una clase anónima
		listaPersonas.sort(new Comparator<Persona>() {
			@Override
			public int compare(Persona o1, Persona o2) {
				return o2.getEdad() - o1.getEdad();
			}
		});

		System.out.println("Personas Ordenadas de menor a mayor edad: ");
		for(Persona p: listaPersonas) {
			System.out.println(p);
		}
		
		// Ordenar por nombre (de menor a mayor) usando una expresion lambda
		listaPersonas.sort((o1, o2)-> o1.getNombre().compareTo(o2.getNombre()));

		System.out.println("Personas Ordenadas de menor a mayor edad: ");
		for(Persona p: listaPersonas) {
			System.out.println(p.toString());
		}
		
		// Ordenar por nombre (de menor a mayor) usando una expresion lambda
		listaPersonas.sort((o2, o1)-> o1.getNombre().compareTo(o2.getNombre()));
		listaPersonas.forEach(persona -> {
			System.out.println(persona);
		});

		// Ordenar por edad ascendente y en caso de igualdad, por nombre
		Comparator<Persona> cEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();
		Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()); 
		
		listaPersonas.sort(cEdad.thenComparing(cNombre));
		System.out.println("Personas por edad y luego por nombre");
		listaPersonas.forEach(persona -> {
			System.out.println(persona);
		});
	} // End Main
}

