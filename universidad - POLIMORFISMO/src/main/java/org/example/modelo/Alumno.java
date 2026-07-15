package org.example.modelo;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {

    private int numExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestre;

    private boolean registroCorrecto = false;

    private static final String[] CARRERAS_VALIDAS = {"TI", "QUIM", "MEC", "MKT"};

    public Alumno() {
    }

    public Alumno(int numExpediente, String nombre, String curp, int edad, String carrera, int cuatrimestre) {

        super(nombre, curp);

        setNumExpediente(numExpediente);
        setEdad(edad);
        setCarrera(carrera);
        setCuatrimestre(cuatrimestre);

    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        if (edad > 15 && edad < 110) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe estar entre 16 y 109 años");
        }

    }

    public String getCarrera() {
        return carrera.toUpperCase();
    }

    public void setCarrera(String carrera) {

        if (validarCarreras(carrera)) {
            this.carrera = carrera;
        } else {
            System.out.println("Carrera no valida");
        }

    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {

        if (cuatrimestre > 0 && cuatrimestre < 12) {
            this.cuatrimestre = cuatrimestre;
        } else {
            System.out.println("El cuatrimestre debe ser entre 1 y 11");
        }

    }

    public boolean validarCarreras(String carrera) {

        boolean carreraValida = false;

        for (String validar : CARRERAS_VALIDAS) {

            if (carrera.equalsIgnoreCase(validar)) {
                return true;
            }

        }

        return carreraValida;

    }

    /// POLIMORFISMO PARA ALUMNOS ============================

    @Override
    public String mostrarTipoPersona() {
        return "Alumno";
    }

    /// INTERFACES PARA ALUMNOS ============================

    @Override
    public void aprender() {
        System.out.println("El alumno está aprendiendo.");
    }

    @Override
    public void recibirEvaluacion() {
        System.out.println("El alumno recibe una evaluación.");
    }

    /// TOSTRING PARA ALUMNOS ============================

    @Override
    public String toString() {

        return "Tipo:            " + mostrarTipoPersona() + '\n' +
                "numExpediente:   " + numExpediente + '\n' +
                "nombre:          " + getNombre() + '\n' +
                "curp:            " + getCurp() + '\n' +
                "edad:            " + edad + '\n' +
                "carrera:         " + carrera + '\n' +
                "cuatrimestre:    " + cuatrimestre + '\n' +
                "----------------------------------------";

    }

}