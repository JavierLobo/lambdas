package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.ExampleData;
import org.javierlobo.lambda.pojos.Persona;

public class Map01Application {

	final static Logger log = Logger.getLogger(Map01Application.class);
	
	public static void main(String[] args) throws ParseException {
		DateFormat formateador= new SimpleDateFormat("dd/M/yy");

		log.info("Personas adultas: ");
		ExampleData.getPersonas().stream()
				.map(p -> p.getNombre())
				.forEach(log::info);

		List<String> datosPersonas = new ArrayList<>();
		datosPersonas.add("Adrian:21:01/03/2001:21000:Basicos:1");
		datosPersonas.add("Julia:49:01/03/1973:49000:Superior:2");
		datosPersonas.add("Filipa:15::::");

		datosPersonas.stream()
				.map(s -> new Persona(
							s.split(":")[0],
							Integer.parseInt(s.split(":")[1]),
							s.split(":")[3],
							Integer.parseInt(s.split(":")[3]),
							s.split(":")[4],
							Integer.parseInt(s.split(":")[5])))
							.forEach(log::info);

	} // End Main
}

