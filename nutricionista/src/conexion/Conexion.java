package conexion;

import java.sql.*;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class Conexion {

    private static final String DATABASE_URL = "jdbc:mariadb://";
    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_PUERTO = ":3306";
    private static final String DATABASE_DB = "/nutricionista_2024";
    private static final String DATABASE_USUARIO = "root";
    private static final String DATABASE_PASSWORD = "";
    private static Conexion conexion = null;
    private static Connection con = null;

    private Conexion() {
        try {
            // Cargar drivers
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver" + ex);
        }
    }

    public static Connection getConexion() {
        if (con == null) {
            try {
                con = (Connection) DriverManager.getConnection(
                        DATABASE_URL + DATABASE_HOST + DATABASE_PUERTO + DATABASE_DB
                        + "?useLegacyDatetimeCode=false&serverTimezone=UTC",
                        DATABASE_USUARIO, DATABASE_PASSWORD
                );
                System.out.println("Conectado exitosamente");
            } catch (SQLException ex) {
                System.out.println("Error en la conexión: " + ex.getMessage());
            }
        }
        return con;
    }


    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();
    }
}
