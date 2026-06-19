package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Contenido> contenidos = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        int op = 0;

        while (op != 6) {

            System.out.println("\n1. Registrar película");
            System.out.println("2. Registrar serie");
            System.out.println("3. Registrar podcast");
            System.out.println("4. Mostrar todo el contenido");
            System.out.println("5. Reproducir todo el contenido");
            System.out.println("6. Salir");

            System.out.print("Opción: ");
            op = Integer.parseInt(leer.readLine());

            switch (op) {

                case 1:
                    nuevaPelicula();
                    break;

                case 2:
                    nuevaSerie();
                    break;

                case 3:
                    nuevoPodcast();
                    break;

                case 4:
                    mostrarContenido();
                    break;

                case 5:
                    reproducirContenido();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    static void nuevaPelicula() {
        Contenido pelicula =
                new Pelicula("Titanic", "Drama", 195, "James Cameron");

        contenidos.add(pelicula);

        System.out.println("Película registrada.");
    }

    static void nuevaSerie() {
        Contenido serie =
                new Serie("Breaking Bad", "Drama", 50, 5, 62);

        contenidos.add(serie);

        System.out.println("Serie registrada.");
    }

    static void nuevoPodcast() {
        Contenido podcast =
                new Podcast("Tecnología Hoy", "Educativo", 40, "Carlos Pérez");

        contenidos.add(podcast);

        System.out.println("Podcast registrado.");
    }

    static void mostrarContenido() {

        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido registrado.");
            return;
        }

        System.out.println("\n===== CONTENIDO REGISTRADO =====");

        for (Contenido contenido : contenidos) {

            System.out.println(contenido);
            System.out.println("---------------------");
        }
    }

    static void reproducirContenido() {

        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido registrado.");
            return;
        }

        for (Contenido contenido : contenidos) {

            System.out.println(contenido.getTitulo());
            System.out.println(contenido.reproducir());
            System.out.println("---------------------");
        }
    }
}