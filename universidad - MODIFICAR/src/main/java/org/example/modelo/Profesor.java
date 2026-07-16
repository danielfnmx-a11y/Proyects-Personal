package org.example.modelo;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {

    private int dniProfesor;
    private int edadProfesor;
    private String especialidad;
    private String direccionProfesor;
    private int antiguedadProfesor;

    private static final String[] ESPECIALIDADES_VALIDAS = {
            "LIC", "MTR", "DOC"
    };

    public Profesor() {
    }

    public Profesor(int dniProfesor, String nombre, String curp,
                    int edadProfesor, String especialidad,
                    String direccionProfesor,
                    int antiguedadProfesor) {

        super(nombre, curp);

        setDniProfesor(dniProfesor);
        setEdadProfesor(edadProfesor);
        setEspecialidad(especialidad);
        setDireccionProfesor(direccionProfesor);
        setAntiguedadProfesor(antiguedadProfesor);
    }

    public int getDniProfesor() {
        return dniProfesor;
    }

    public void setDniProfesor(int dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    public int getEdadProfesor() {
        return edadProfesor;
    }

    public void setEdadProfesor(int edadProfesor) {

        if (edadProfesor >= 18 && edadProfesor <= 100) {
            this.edadProfesor = edadProfesor;
        } else {
            System.out.println("Edad no válida.");
        }

    }

    public String getEspecialidad() {
        return especialidad.toUpperCase();
    }

    public void setEspecialidad(String especialidad) {

        if (validarEspecialidad(especialidad)) {
            this.especialidad = especialidad;
        } else {
            System.out.println("Especialidad inválida.");
        }

    }

    public String getDireccionProfesor() {
        return direccionProfesor;
    }

    public void setDireccionProfesor(String direccionProfesor) {

        if (direccionProfesor.isBlank() || direccionProfesor.isEmpty()) {
            System.out.println("La dirección es obligatoria.");
        } else {
            this.direccionProfesor = direccionProfesor;
        }

    }

    public int getAntiguedadProfesor() {
        return antiguedadProfesor;
    }

    public void setAntiguedadProfesor(int antiguedadProfesor) {

        if (antiguedadProfesor >= 0 && antiguedadProfesor <= 50) {
            this.antiguedadProfesor = antiguedadProfesor;
        } else {
            System.out.println("Antigüedad inválida.");
        }

    }

    public boolean validarEspecialidad(String especialidad) {

        for (String esp : ESPECIALIDADES_VALIDAS) {

            if (esp.equalsIgnoreCase(especialidad)) {
                return true;
            }

        }

        return false;

    }

    /// POLIMORFISMO PARA PROFESORES ============================

    @Override
    public String mostrarTipoPersona() {
        return "Profesor";
    }

    /// INTERFACES PARA PROFESORES ============================

    @Override
    public void ensenar() {
        System.out.println("El profesor está enseñando.");
    }

    @Override
    public void evaluar() {
        System.out.println("El profesor está evaluando.");
    }

    /// TOSTRING PARA PROFESORES ============================

    @Override
    public String toString() {

        return "Tipo:            " + mostrarTipoPersona() + "\n" +
                "DNI:             " + getDniProfesor() + "\n" +
                "Nombre:          " + getNombre() + "\n" +
                "CURP:            " + getCurp() + "\n" +
                "Edad:            " + getEdadProfesor() + "\n" +
                "Especialidad:    " + getEspecialidad() + "\n" +
                "Dirección:       " + getDireccionProfesor() + "\n" +
                "Antigüedad:      " + getAntiguedadProfesor() + " años\n" +
                "--------------------------------------";

    }
}