package org.example;

public class Pelicula extends Contenido {

    private String director;

    public Pelicula(String titulo, String genero, int duracion, String director) {
        super(titulo, genero, duracion);
        setDirector(director);
    }

    public String getDirector() {
        return director.toUpperCase();
    }

    public void setDirector(String director) {
        if (!director.isEmpty()) {
            this.director = director;
        }
    }

    @Override
    public String reproducir() {
        return "Reproduciendo película...";
    }

    @Override
    public String obtenerTipoContenido() {
        return "Película";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Director: " + getDirector();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDirector: " + getDirector();
    }
}