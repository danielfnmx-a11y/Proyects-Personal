package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class ProfesorDAO {

    /// AGREGAR PROFESORES ###############################
    public boolean nuevoProfesor(Profesor profesor){

        boolean registrado = false;

        String sql = "INSERT INTO profesores (dniProfesor, nombreProfesor, edadProfesor, especialidad, direccionProfesor, antiguedadProfesor) VALUES (?,?,?,?,?,?)";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, profesor.getDniProfesor());
            stm.setString(2, profesor.getNombreProfesor());
            stm.setInt(3, profesor.getEdadProfesor());
            stm.setString(4, profesor.getEspecialidad());
            stm.setString(5, profesor.getDireccionProfesor());
            stm.setInt(6, profesor.getAntiguedadProfesor());

            int filas = stm.executeUpdate();

            if(filas > 0){
                registrado = true;
                System.out.println("Profesor agregado correctamente.");
            }

        }catch(SQLException err){

            System.out.println("Error al agregar profesor: " + err.getMessage());

        }

        return registrado;

    }

    /// CONSULTAR PROFESORES ###############################
    public ArrayList<Profesor> extraerProfesores(){

        ArrayList<Profesor> profesorBD = new ArrayList<>();

        String sql = "SELECT * FROM profesores";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql);
            ResultSet rs = stm.executeQuery()){

            while(rs.next()){

                Profesor profesor = new Profesor();

                profesor.setDniProfesor(rs.getInt("dniProfesor"));
                profesor.setNombreProfesor(rs.getString("nombreProfesor"));
                profesor.setEdadProfesor(rs.getInt("edadProfesor"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setDireccionProfesor(rs.getString("direccionProfesor"));
                profesor.setAntiguedadProfesor(rs.getInt("antiguedadProfesor"));

                profesorBD.add(profesor);

            }

        }catch(SQLException err){

            System.out.println("ERROR AL EXTRAER LOS PROFESORES: " + err.getMessage());

        }

        return profesorBD;

    }

}