package org.example;

public abstract class Contenido {

    private String titulo;
    private String genero;
    private int duracion;

    public Contenido() {
    }

    public Contenido(String titulo, String genero, int duracion) {
        setTitulo(titulo);
        setGenero(genero);
        setDuracion(duracion);
    }

    //Getters con formato
    public String getTitulo() {
        return titulo.toUpperCase();
    }

    public String getGenero() {
        return genero.toUpperCase();
    }

    public int getDuracion() {
        return duracion;
    }

    //Setters validados
    public void setTitulo(String titulo) {
        if (!titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public void setGenero(String genero) {
        if (!genero.isEmpty()) {
            this.genero = genero;
        }
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    public String obtenerDatosGenerales() {
        return "Título: " + getTitulo()
                + "\nGénero: " + getGenero()
                + "\nDuración: " + duracion + " min";
    }

    public int obtenerTiempoTotal() {
        return duracion;
    }

    public int numeroEpisodios() {
        return 0;
    }

    @Override
    public String toString() {
        return obtenerDatosGenerales();
    }

    public abstract String reproducir();

    public abstract String obtenerTipoContenido();

    public abstract String obtenerDatosParticulares();
}