package org.javierlobo.lambda.streams;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.pojos.Persona;

public class Arrays01Application {

  final static Logger log = Logger.getLogger(Arrays01Application.class);

  Predicate<Persona> porMayoriaDeEdad = p -> p.getEdad() >= 18;

  public static void main(String[] args) throws ParseException {
    DateFormat formateador = new SimpleDateFormat("dd/M/yy");

    Persona[] arryPersonas = new Persona[5];
    arryPersonas[0] = new Persona("Nacho", 42, null, null, null, null);
    arryPersonas[1] = new Persona("Juan", 78, null, null, null, null);
    arryPersonas[2] = new Persona("Mario", 7, null, null, null, null);
    arryPersonas[3] = new Persona("Laura", 4, null, null, null, null);
    arryPersonas[4] = new Persona("May", 41, null, null, null, null);

    Predicate<Persona> porMayoriaDeEdad = p -> p.getEdad() >= 18;

    List<Persona> listaDeAdultos = Arrays.stream(arryPersonas)
        .filter(porMayoriaDeEdad)
        .collect(Collectors.toList());

    Persona[] arrayDeAdultos = Arrays.stream(arryPersonas)
        .filter(porMayoriaDeEdad)
        .toArray(tam -> new Persona[tam]);

    log.info("Personas adultas en la lista");
    listaDeAdultos.forEach(log::info);

    log.info("Personas adultas en el array");
    for (Persona p : arrayDeAdultos) {
      log.info(p);
    }

    // Array to Map
    Map<String, Persona> mapaPersonas = new HashMap<>();
    mapaPersonas.put("11111111A", new Persona("Nacho", 42, null, null, null, null));
    mapaPersonas.put("22222222B", new Persona("Juan", 78, null, null, null, null));
    mapaPersonas.put("33333333C", new Persona("Mario", 7, null, null, null, null));
    mapaPersonas.put("44444444D", new Persona("Laura", 4, null, null, null, null));
    mapaPersonas.put("55555555E", new Persona("May", 41, null, null, null, null));

    List<Persona> mapaDeAdultos = mapaPersonas.values().stream()
        .filter(porMayoriaDeEdad)
        .collect(Collectors.toList());

    log.info("Personas adultas en el mapa: ");
    mapaDeAdultos.forEach(log::info);

    List<String> dniAdultos = mapaPersonas.entrySet().stream()
        .filter(p -> p.getValue().getEdad() >= 18)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

    log.info("DNI's de personas adultas: ");
    dniAdultos.forEach(log::info);

  } // End Main
}

