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

    /// ACTUALIZAR PROFESORES ###############################

    public boolean actualizarProfesor(Profesor profesor){

        boolean actualizado = false;

        String sql = "UPDATE profesores SET nombreProfesor = ?, edadProfesor = ?, especialidad = ?, direccionProfesor = ?, antiguedadProfesor = ? WHERE dniProfesor = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setString(1, profesor.getNombreProfesor());
            stm.setInt(2, profesor.getEdadProfesor());
            stm.setString(3, profesor.getEspecialidad());
            stm.setString(4, profesor.getDireccionProfesor());
            stm.setInt(5, profesor.getAntiguedadProfesor());
            stm.setInt(6, profesor.getDniProfesor());

            int registrosAfectados = stm.executeUpdate();

            if(registrosAfectados > 0){

                actualizado = true;
                System.out.println("Profesor actualizado correctamente.");

            }else{

                System.out.println("No se encontró un profesor con ese DNI.");

            }

        }catch(SQLException err){

            System.out.println("ERROR AL ACTUALIZAR PROFESOR: " + err.getMessage());

        }

        return actualizado;
    }

    /// ELIMINAR PROFESORES ###############################

    public boolean eliminarProfesor(int dniProfesor){

        boolean eliminado = false;

        String sql = "DELETE FROM profesores WHERE dniProfesor = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, dniProfesor);

            int registrosAfectados = stm.executeUpdate();

            if(registrosAfectados > 0){

                eliminado = true;
                System.out.println("Profesor eliminado correctamente.");

            }else{

                System.out.println("No se encontró un profesor con ese DNI.");

            }

        }catch(SQLException err){

            System.out.println("ERROR AL ELIMINAR PROFESOR: " + err.getMessage());

        }

        return eliminado;

    }

    /// BUSCAR PROFESOR ###############################

    public Profesor buscarProfesor(int dniProfesor){

        Profesor profesor = null;

        String sql = "SELECT * FROM profesores WHERE dniProfesor = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, dniProfesor);

            ResultSet rs = stm.executeQuery();

            if(rs.next()){

                profesor = new Profesor();

                profesor.setDniProfesor(rs.getInt("dniProfesor"));
                profesor.setNombreProfesor(rs.getString("nombreProfesor"));
                profesor.setEdadProfesor(rs.getInt("edadProfesor"));
                profesor.setEspecialidad(rs.getString("especialidad"));
                profesor.setDireccionProfesor(rs.getString("direccionProfesor"));
                profesor.setAntiguedadProfesor(rs.getInt("antiguedadProfesor"));

            }

        }catch(SQLException err){

            System.out.println("ERROR AL BUSCAR PROFESOR: " + err.getMessage());

        }

        return profesor;

    }

}