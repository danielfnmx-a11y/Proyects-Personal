package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();

    static Alumno alumno = new Alumno();
    static Profesor profesor = new Profesor();

    /// ALUMNOS #############################################

    public static void inscribir() throws IOException{
        System.out.println("Numero expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre: ");
        alumno.setNombre(leer.readLine());

        System.out.println("Edad: ");
        alumno.setEdad(Integer.parseInt(leer.readLine()));

        System.out.println("Carrera: (TI, QUIM, MEC, MKT)");
        alumno.setCarrera(leer.readLine());

        System.out.println("Cuatrimestre: ");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));

        alumnoDAO.nuevoAlumno(alumno);
    }

    public static void mostrar(){

        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();

        System.out.println("----------- LISTA DE ALUMNOS INSCRITOS -------------");

        for(Alumno alumno : alumnos){

            System.out.println(alumno);

        }

    }

    public static void modificar() throws IOException{

        System.out.println("Modificar alumno por numero de expediente");

        System.out.println("Numero de expediente: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre: ");
        alumno.setNombre(leer.readLine());

        System.out.println("Edad: ");
        alumno.setEdad(Integer.parseInt(leer.readLine()));

        System.out.println("Carrera: (TI, QUIM, MEC, MKT)");
        alumno.setCarrera(leer.readLine());

        System.out.println("Cuatrimestre: ");
        alumno.setCuatrimestre(Integer.parseInt(leer.readLine()));

        alumnoDAO.actualizarAlumno(alumno);

    }

    public static void eliminar(){}

    public static void buscar(){}

    /// AGREGAR MAESTROS #############################################

    public static void agregarProfesor() throws IOException{

        System.out.println("DNI:");
        profesor.setDniProfesor(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        profesor.setNombreProfesor(leer.readLine());

        System.out.println("Edad:");
        profesor.setEdadProfesor(Integer.parseInt(leer.readLine()));

        System.out.println("Especialidad (LIC, MTR, DOC):");
        profesor.setEspecialidad(leer.readLine());

        System.out.println("Direccion:");
        profesor.setDireccionProfesor(leer.readLine());

        System.out.println("Antiguedad:");
        profesor.setAntiguedadProfesor(Integer.parseInt(leer.readLine()));

        profesorDAO.nuevoProfesor(profesor);

    }

    /// MOSTRAR MAESTROS #############################################

    public static void mostrarProfesores(){

        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        System.out.println("----------- LISTA DE PROFESORES -------------");

        for(Profesor profesor : profesores){

            System.out.println(profesor);

        }

    }

    /// ACTUALIZAR MAESTROS #############################################

    public static void modificarProfesor() throws IOException{

        System.out.println("Modificar profesor por DNI");

        System.out.println("DNI:");
        profesor.setDniProfesor(Integer.parseInt(leer.readLine()));

        System.out.println("Nombre:");
        profesor.setNombreProfesor(leer.readLine());

        System.out.println("Edad:");
        profesor.setEdadProfesor(Integer.parseInt(leer.readLine()));

        System.out.println("Especialidad (LIC, MTR, DOC):");
        profesor.setEspecialidad(leer.readLine());

        System.out.println("Direccion:");
        profesor.setDireccionProfesor(leer.readLine());

        System.out.println("Antiguedad:");
        profesor.setAntiguedadProfesor(Integer.parseInt(leer.readLine()));

        profesorDAO.actualizarProfesor(profesor);

    }

    /// MENU PRINCIPAL #############################################

    public static void menu() throws IOException{

        int salir = 0;

        while(salir != 9){

            System.out.println("1. Inscribir nuevo alumno");
            System.out.println("2. Mostrar todos los alumnos");
            System.out.println("3. Modificar un alumno");
            System.out.println("4. Borrar un alumno");
            System.out.println("5. Buscar un alumno");
            System.out.println("6. Agregar profesor");
            System.out.println("7. Mostrar profesores");
            System.out.println("8. Modificar profesor");
            System.out.println("9. Salir");

            salir = Integer.parseInt(leer.readLine());

            switch (salir){

                case 1:
                    inscribir();
                    break;

                case 2:
                    mostrar();
                    break;

                case 3:
                    modificar();
                    break;

                case 4:
                    eliminar();
                    break;

                case 5:
                    buscar();
                    break;

                case 6:
                    agregarProfesor();
                    break;

                case 7:
                    mostrarProfesores();
                    break;

                case 8:
                    modificarProfesor();
                    break;

                case 9:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;

            }

        }

    }

}