
package conexion;

import entidades.Alimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlimentoData {
    
    private Connection con = null;
    
    public AlimentoData(){
        con = Conexion.getConexion();
    }
    
    public List<String> obtenerAlimentos() {
      List<String> alimentos = new ArrayList<>();
      String query = "SELECT nombre FROM alimento";

      try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(query);
           ResultSet rs = stmt.executeQuery()) {

          while (rs.next()) {
              alimentos.add(rs.getString("nombre"));
          }
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error al obtener alimentos: " + e.getMessage());
      }

      return alimentos;
  }
   
    public Alimento obtenerAlimentoPorNombre(String nombre1) {
        Alimento alimento = null; // Inicializar como null en caso de que no se encuentre el alimento
        String query = "SELECT * FROM alimento WHERE nombre = ?"; 
        try (PreparedStatement stmt = Conexion.getConexion().prepareStatement(query)) {
            stmt.setString(1, nombre1); // Establece el nombre en el parámetro de la consulta
            ResultSet rs = stmt.executeQuery();

            // Verifica si hay un resultado
            if (rs.next()) {
                int codComida = rs.getInt("codComida");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipoComida");
                int caloriasPorPorcion = rs.getInt("caloriasPor100g");
                String detalle = rs.getString("detalle");
                boolean baja = rs.getBoolean("baja");
                boolean aptoVegetariano = rs.getBoolean("aptoVegetariano");
                boolean libreDeTACC = rs.getBoolean("libredeTACC");
                boolean lacteo = rs.getBoolean("lacteo");
               

                // Crea un objeto Alimento con los datos obtenidos
                alimento = new Alimento(nombre,caloriasPorPorcion,tipo,detalle,baja,aptoVegetariano,libreDeTACC,lacteo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el alimento: " + e.getMessage());
        }

        return alimento; // Devuelve el objeto Alimento o null si no se encontró
    }

    
    
   
    
    public int obtenerCaloriasPor100g(String nombreAlimento) {
        String query = "SELECT caloriasPor100g FROM alimento WHERE nombre = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nombreAlimento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("caloriasPor100g");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener calorías: " + e.getMessage());
        }
        return 0; // Retornar 0 si no se encuentran las calorías
    }

    public void agregarAlimento(Alimento alimento){
        String sql = "INSERT INTO `alimento`(codComida, nombre, tipoComida, caloriasPor100g, detalle, baja, aptoVegetariano, libreTACC, lacteo) VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(2, alimento.getNombre());
            ps.setString(3, alimento.getTipo());
            ps.setInt(4, (int) alimento.getCaloriasPorPorcion());
            ps.setString(5, alimento.getDetalle());
            ps.setBoolean(6, alimento.isBaja());
            ps.setBoolean(6, alimento.isAptoVegetariano());
            ps.setBoolean(6, alimento.isLibreDeTACC());
            ps.setBoolean(6, alimento.isLacteo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                alimento.setCodComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null," - Alimento añadido con exito.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alimento "+ex.getMessage());
        }                   
    }

}
