package org.example.modelo;

public abstract class PersonaUT {

    private String nombre;
    private String curp;

    public PersonaUT() {
    }

    public PersonaUT(String nombre, String curp) {
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {

        if(nombre == null || nombre.isBlank() || nombre.isEmpty()){
            System.out.println("Error el nombre es requerido");
        }else{
            this.nombre = nombre;
        }

    }

    public String getCurp() {
        return curp.toUpperCase();
    }

    public void setCurp(String curp){

        if(curp == null || curp.isBlank() || curp.isEmpty()){
            System.out.println("El curp es requerido");
        }else{
            this.curp = curp;
        }

    }

    public abstract String mostrarTipoPersona();

}