package org.javierlobo.lambda.comparation;

import java.util.Comparator;

import org.javierlobo.lambda.pojos.Persona;

public class ComparadorPersonas implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getEdad() - o2.getEdad();
	}

}
