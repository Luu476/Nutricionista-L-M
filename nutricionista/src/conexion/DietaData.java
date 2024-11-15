package conexion;

import conexion.Conexion;
import entidades.Dieta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DietaData {

    private Connection con;

    public DietaData() {
        con = Conexion.getConexion();
    }

    public void agregarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (codDieta, nombreD, fechaIni, fechaFin, pesoIni, pesoFinal,  estado, nroPaciente, tipoDeDieta) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getCodDieta());
            ps.setString(2, dieta.getNombre());
            ps.setDate(3, new Date(dieta.getFechaInicio().getTime()));
            ps.setDate(4, new Date(dieta.getFechaFin().getTime()));
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setBoolean(7, dieta.isEstado());
            ps.setInt(8, dieta.getPaciente().getNroPaciente()); // Asumiendo que Paciente tiene un método getId()
            ps.setString(9, dieta.getTipoDeDieta());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                dieta.setCodDieta(rs.getString(1));
                JOptionPane.showMessageDialog(null, "Dieta añadida con éxito.");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
    }
}
