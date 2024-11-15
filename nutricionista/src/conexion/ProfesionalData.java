
package conexion;

import entidades.Profesional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;


public class ProfesionalData {

    private Connection con = null;
    
    public ProfesionalData() {
        con = Conexion.getConexion();
    }
    
    public void agregarProfesional(Profesional profesional){
        String sql = "INSERT INTO `paciente`(nombre, apellido, correo, telefono) VALUES"
                + " (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, profesional.getNombre());
            ps.setString(2, profesional.getApellido());
            ps.setString(3, profesional.getCorreo());
            ps.setFloat(4, profesional.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla paciente "+ex.getMessage());
        }                   
    }
    

    
}
