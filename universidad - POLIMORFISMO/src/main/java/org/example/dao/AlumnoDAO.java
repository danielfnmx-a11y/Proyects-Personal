package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class AlumnoDAO {

    /// AGREGAR ALUMNOS #############################################
    public boolean nuevoAlumno(Alumno alumno) {

        boolean registrado = false;

        String sql = "INSERT INTO alumnos (numExpediente,nombre,curp,edad,carrera,cuatrimestre) VALUES(?,?,?,?,?,?)";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setInt(1, alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setString(3, alumno.getCurp());
            stm.setInt(4, alumno.getEdad());
            stm.setString(5, alumno.getCarrera());
            stm.setInt(6, alumno.getCuatrimestre());

            int filas = stm.executeUpdate();

            if (filas > 0) {
                registrado = true;
                System.out.println("Alumno agregado correctamente.");
            }

        } catch (SQLException err) {
            System.out.println("Error al agregar alumno: " + err.getMessage());
        }

        return registrado;
    }

    /// CONSULTAR ALUMNOS #############################################
    public ArrayList<Alumno> extraerAlumnos() {

        ArrayList<Alumno> alumnoBD = new ArrayList<>();

        String sql = "SELECT * FROM alumnos";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestre(rs.getInt("cuatrimestre"));

                alumnoBD.add(alumno);
            }

        } catch (SQLException err) {
            System.out.println("ERROR AL EXTRAER LOS DATOS: " + err.getMessage());
        }

        return alumnoBD;
    }

    /// ACTUALIZAR ALUMNOS #############################################
    public boolean actualizarAlumno(Alumno alumno) {

        boolean actualizado = false;

        String sql = "UPDATE alumnos SET nombre = ?, curp = ?, edad = ?, carrera = ?, cuatrimestre = ? WHERE numExpediente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {

            stm.setString(1, alumno.getNombre());
            stm.setString(2, alumno.getCurp());
            stm.setInt(3, alumno.getEdad());
            stm.setString(4, alumno.getCarrera());
            stm.setInt(5, alumno.getCuatrimestre());
            stm.setInt(6, alumno.getNumExpediente());

            int registrosAfectados = stm.executeUpdate();

            if (registrosAfectados > 0) {
                actualizado = true;
                System.out.println("Alumno actualizado correctamente.");
            } else {
                System.out.println("No se encontró un alumno con ese número de expediente.");
            }

        } catch (SQLException err) {
            System.out.println("ERROR AL ACTUALIZAR ALUMNO: " + err.getMessage());
        }

        return actualizado;
    }

    /// ELIMINAR ALUMNOS #############################################

    public boolean eliminarAlumno(int numExpediente){

        boolean eliminado = false;

        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, numExpediente);

            int registrosAfectados = stm.executeUpdate();

            if(registrosAfectados > 0){

                eliminado = true;
                System.out.println("Alumno eliminado correctamente.");

            }else{

                System.out.println("No se encontró un alumno con ese número de expediente.");

            }

        }catch(SQLException err){

            System.out.println("ERROR AL ELIMINAR ALUMNO: " + err.getMessage());

        }

        return eliminado;

    }

    /// BUSCAR ALUMNO #############################################

    public Alumno buscarAlumno(int numExpediente){

        Alumno alumno = null;

        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, numExpediente);

            ResultSet rs = stm.executeQuery();

            if(rs.next()){

                alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestre(rs.getInt("cuatrimestre"));

            }

        }catch(SQLException err){

            System.out.println("ERROR AL BUSCAR ALUMNO: " + err.getMessage());

        }

        return alumno;

    }


}