package org.example;

public class Podcast extends Contenido {

    private String nombrePresentador;

    public Podcast(String titulo, String genero, int duracion, String nombrePresentador) {
        super(titulo, genero, duracion);
        setNombrePresentador(nombrePresentador);
    }

    public String getNombrePresentador() {
        return nombrePresentador.toUpperCase();
    }

    public void setNombrePresentador(String nombrePresentador) {
        if (!nombrePresentador.isEmpty()) {
            this.nombrePresentador = nombrePresentador;
        }
    }

    @Override
    public String reproducir() {
        return "Reproduciendo podcast...";
    }

    @Override
    public String obtenerTipoContenido() {
        return "Podcast";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Presentador: " + getNombrePresentador();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPresentador: " + getNombrePresentador();
    }
}