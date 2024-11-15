
package conexion;

import entidades.Alimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                boolean libreDeTACC = rs.getBoolean("libreDeTACC");
                boolean lacteo = rs.getBoolean("lacteo");
               

                // Crea un objeto Alimento con los datos obtenidos
                alimento = new Alimento( codComida, nombre,caloriasPorPorcion,tipo,detalle,baja,aptoVegetariano,libreDeTACC,lacteo);
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


}
