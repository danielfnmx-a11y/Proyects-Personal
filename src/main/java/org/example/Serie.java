package org.example;

public class Serie extends Contenido {

    private int numeroTemporadas;
    private int numeroEpisodios;

    public Serie(String titulo, String genero, int duracion,
                 int numeroTemporadas, int numeroEpisodios) {

        super(titulo, genero, duracion);

        setNumeroTemporadas(numeroTemporadas);
        setNumeroEpisodios(numeroEpisodios);
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        if (numeroTemporadas > 0) {
            this.numeroTemporadas = numeroTemporadas;
        }
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        if (numeroEpisodios > 0) {
            this.numeroEpisodios = numeroEpisodios;
        }
    }

    @Override
    public String reproducir() {
        return "Reproduciendo serie...";
    }

    @Override
    public String obtenerTipoContenido() {
        return "Serie";
    }

    @Override
    public int numeroEpisodios() {
        return numeroEpisodios;
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Temporadas: " + numeroTemporadas
                + "\nEpisodios: " + numeroEpisodios;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nTemporadas: " + numeroTemporadas
                + "\nEpisodios: " + numeroEpisodios;
    }
}