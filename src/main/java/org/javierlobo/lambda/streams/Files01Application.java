package org.javierlobo.lambda.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.javierlobo.lambda.pojos.Persona;

public class Files01Application {

  final static Logger log = Logger.getLogger(Files01Application.class);
  public static final String PERSONAS_TXT = "src/main/resources/personas.txt";
  public static final String PERSONAS2_TXT = "src/main/resources/personas2.txt";

  DateFormat formateador = new SimpleDateFormat("dd/M/yy");
  Predicate<Persona> porMayoriaDeEdad = p -> p.getEdad() >= 18;

  public static void main(String[] args) throws ParseException {

    try {
      List<Persona> fPersonas = Files.lines(Paths.get(PERSONAS_TXT))
          .map(linea -> new Persona(
              linea.split(":")[0],
              Integer.parseInt(linea.split(":")[1]),
              null, null, null, null))
          .collect(Collectors.toList());

      log.info("Personas leidas del fichero: ");
      fPersonas.forEach(log::info);

      fPersonas.add(new Persona("Fulano", 17, null, null, null, null));

      Files.write(Paths.get(PERSONAS2_TXT), fPersonas.stream()
          .map(Persona::toFile)
          .collect(Collectors.toList()));

      log.info("Personas guardadas en el nuevo fichero!");

    } catch (IOException e) {
      log.info("Error procesando archivos: " + e.getMessage());
//      e.printStackTrace();
    }


  } // End Main
}

