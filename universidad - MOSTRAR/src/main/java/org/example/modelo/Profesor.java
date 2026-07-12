package org.example.modelo;

public class Profesor {

    private int dniProfesor;
    private String nombreProfesor;
    private int edadProfesor;
    private String especialidad;
    private String direccionProfesor;
    private int antiguedadProfesor;

    private static final String[] ESPECIALIDADES_VALIDAS = {
            "LIC", "MTR", "DOC"
    };

    public Profesor() {
    }

    public Profesor(int dniProfesor, String nombreProfesor, int edadProfesor,
                    String especialidad, String direccionProfesor,
                    int antiguedadProfesor) {

        setDniProfesor(dniProfesor);
        setNombreProfesor(nombreProfesor);
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

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {

        if(nombreProfesor.isBlank() || nombreProfesor.isEmpty()){
            System.out.println("El nombre es obligatorio");
        }else{
            this.nombreProfesor = nombreProfesor;
        }

    }

    public int getEdadProfesor() {
        return edadProfesor;
    }

    public void setEdadProfesor(int edadProfesor) {

        if(edadProfesor>=18 && edadProfesor<=100){
            this.edadProfesor = edadProfesor;
        }else{
            System.out.println("Edad no válida.");
        }

    }

    public String getEspecialidad() {
        return especialidad.toUpperCase();
    }

    public void setEspecialidad(String especialidad) {

        if(validarEspecialidad(especialidad)){
            this.especialidad = especialidad;
        }else{
            System.out.println("Especialidad inválida.");
        }

    }

    public String getDireccionProfesor() {
        return direccionProfesor;
    }

    public void setDireccionProfesor(String direccionProfesor) {

        if(direccionProfesor.isBlank() || direccionProfesor.isEmpty()){
            System.out.println("La dirección es obligatoria.");
        }else{
            this.direccionProfesor = direccionProfesor;
        }

    }

    public int getAntiguedadProfesor() {
        return antiguedadProfesor;
    }

    public void setAntiguedadProfesor(int antiguedadProfesor) {

        if(antiguedadProfesor>=0 && antiguedadProfesor<=50){
            this.antiguedadProfesor = antiguedadProfesor;
        }else{
            System.out.println("Antigüedad inválida.");
        }

    }

    public boolean validarEspecialidad(String especialidad){

        for(String esp : ESPECIALIDADES_VALIDAS){

            if(esp.equalsIgnoreCase(especialidad)){
                return true;
            }

        }

        return false;

    }

    @Override
    public String toString() {
        return "DNI: " + dniProfesor + "\n" +
                "Nombre: " + nombreProfesor + "\n" +
                "Edad: " + edadProfesor + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "Dirección: " + direccionProfesor + "\n" +
                "Antigüedad: " + antiguedadProfesor + " años\n" +
                "--------------------------------------";
    }

}