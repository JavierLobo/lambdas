package org.javierlobo.lambda.ejercicios;

import java.util.*;
import org.apache.log4j.Logger;

class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;
    
    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public int getEstreno()
    {
        return estreno;
    }
    
    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

public class Ejercicio03Application {
    /**
     * Sobre el código fuente que se te proporciona, aplica los siguientes cambios en el programa
     * principal "main", utilizando streams en todos los casos:
     *
     * Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive)
     *
     * Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg
     *
     * Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente
     *
     * Mostrar por pantalla el año de estreno más reciente
     *
     * Comprueba finalmente tu solución contrastándola con la solución que se proporciona como ejemplo,
     * para determinar si es correcta.
     */
    final static Logger log = Logger.getLogger(Ejercicio03Application.class);

    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));
        
    }
}
