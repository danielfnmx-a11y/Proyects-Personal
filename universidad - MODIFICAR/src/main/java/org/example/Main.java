package org.example;
import org.example.config.Conexion;
import org.example.dao.AlumnoDAO;
import org.example.modelo.Alumno;
import org.example.vista.Menu;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static void main() throws IOException {
        /// alumnoDAO.nuevoAlumno(new Alumno(2025201514, "Juancho", 20, "TI",3));
        Menu.menu();
    }
}
