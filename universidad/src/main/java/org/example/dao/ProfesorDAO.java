package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {

    public boolean nuevoProfesor(Profesor profesor){

        boolean registrado = false;

        String sql = "INSERT INTO profesores(dniProfesor,nombreProfesor,edadProfesor,especialidad,direccionProfesor,antiguedadProfesor) VALUES(?,?,?,?,?,?)";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, profesor.getDniProfesor());
            stm.setString(2, profesor.getNombreProfesor());
            stm.setInt(3, profesor.getEdadProfesor());
            stm.setString(4, profesor.getEspecialidad());
            stm.setString(5, profesor.getDireccionProfesor());
            stm.setInt(6, profesor.getAntiguedadProfesor());

            int filas = stm.executeUpdate();

            if(filas>0){
                registrado = true;
                System.out.println("Profesor agregado correctamente.");
            }

        }catch(SQLException err){

            System.out.println("Error al registrar profesor: "+err.getMessage());

        }

        return registrado;

    }

}