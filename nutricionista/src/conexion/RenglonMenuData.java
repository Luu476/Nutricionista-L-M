package conexion;

import entidades.RenglonMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RenglonMenuData {
    
    private Connection con = null;
    
    public RenglonMenuData() {
        con = Conexion.getConexion();
    }
    
    public void agregarRenglon(RenglonMenu renglonmenu){
        String sql = "INSERT INTO `renglonmenu`(nroRenglon, alimento_id , cantidad, subtotalCalorias) VALUES"
                + " (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, renglonmenu.getNroRenglon());
            ps.setInt(2, renglonmenu.getAlimento().getCodComida());
            ps.setInt(3, renglonmenu.getCantidad());
            ps.setInt(4, renglonmenu.getSubtotalCalorias());
        
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                renglonmenu.setIdRenglon(rs.getInt(1));
                JOptionPane.showMessageDialog(null," - Paciente renglon añadido con exito.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla renglonMenu "+ex.getMessage());
        }                   
    }    
    
    
    
}
