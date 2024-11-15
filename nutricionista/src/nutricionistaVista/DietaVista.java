package nutricionistaVista;

import conexion.AlimentoData;
import conexion.Conexion;
import conexion.DietaData;
import conexion.MenuDiarioData;
import conexion.pacienteData;
import conexion.RenglonMenuData;
import entidades.Alimento;
import entidades.Dieta;
import entidades.MenuDiario;
import entidades.Paciente;
import entidades.Profesional;
import entidades.RenglonMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class DietaVista extends javax.swing.JFrame {
    
    
    private AlimentoData alimentoData;
    private pacienteData pacienteData;
    private RenglonMenuData renglonmenuData;
    private DietaData dietadata;
    private java.sql.Connection con = null;
    private List<RenglonMenu> listaDeRenglones= new ArrayList<>();
    Profesional nutri = new Profesional();
    private int contadorClics = 0;

    
     public DietaVista(){
     initComponents();
     con = Conexion.getConexion();
     cargarDatosProfesional();
     anularDatosPaciente();
     pacienteData = new pacienteData();
     alimentoData = new AlimentoData();
     renglonmenuData = new RenglonMenuData();
     dietadata = new DietaData();
     
     
     
     
     
     
        /// Metodo para cargar alimentos en los ComboBox
        List<String> alimentos = alimentoData.obtenerAlimentos();
           if (alimentos.isEmpty()) {
               System.out.println("No se encontraron alimentos en la base de datos.");
           } else {
               System.out.println("Alimentos obtenidos:");
               for (String alimento : alimentos) {
                   System.out.println(alimento); 
                    CBDesayuno.addItem(alimento);
                    CBAlmuerzo.addItem(alimento);
                    CBMerienda.addItem(alimento);
                    CBCena.addItem(alimento);
                    CBColaciones.addItem(alimento);
               }
           }
           setupCaloriasListeners(); // Agregar listeners de calorías
     
        pacienteData.rellenarComboBox("paciente", "nombre", CBPaciente);
           CBPaciente.addItemListener(new ItemListener() {
               @Override
                   public void itemStateChanged(ItemEvent e) {
                       if (e.getStateChange() == ItemEvent.SELECTED) {
                           String selectedPaciente = CBPaciente.getSelectedItem().toString();
                           cargarDatosPaciente(selectedPaciente);
                       }
                   }
           });
    
     }
     
    private void setupCaloriasListeners() {
        CBDesayuno.addActionListener(e -> mostrarCalorias(CBDesayuno, JTDesayuno));
        CBAlmuerzo.addActionListener(e -> mostrarCalorias(CBAlmuerzo, JTAlmuerzo));
        CBMerienda.addActionListener(e -> mostrarCalorias(CBMerienda, JTMerienda));
        CBCena.addActionListener(e -> mostrarCalorias(CBCena, JTCena));
        CBColaciones.addActionListener(e -> mostrarCalorias(CBColaciones, JTColaciones));
        
        // Cuando se cambia el valor de un Spinner, actualizamos las calorías totales
        jSpinnerDesayuno.addChangeListener(e -> actualizarCaloriasTotales());
        jSpinnerAlmuerzo.addChangeListener(e -> actualizarCaloriasTotales());
        jSpinnerMerienda.addChangeListener(e -> actualizarCaloriasTotales());
        jSpinnerCena.addChangeListener(e -> actualizarCaloriasTotales());
        jSpinnerColaciones.addChangeListener(e -> actualizarCaloriasTotales());
    }

      // Método para mostrar las calorías en el JTextField correspondiente
    private void mostrarCalorias(JComboBox<String> comboBox, JTextField textField) {
            String alimentoSeleccionado = (String) comboBox.getSelectedItem();
            if (alimentoSeleccionado != null && !alimentoSeleccionado.isEmpty()) {
                int calorias = alimentoData.obtenerCaloriasPor100g(alimentoSeleccionado);
                textField.setText(String.valueOf(calorias));
            }
        }
        
    private void actualizarCaloriasTotales() {
        int totalCalorias = 0;
        totalCalorias += obtenerCaloriasConPorciones(CBDesayuno, jSpinnerDesayuno, JTDesayuno);
        totalCalorias += obtenerCaloriasConPorciones(CBAlmuerzo, jSpinnerAlmuerzo, JTAlmuerzo);
        totalCalorias += obtenerCaloriasConPorciones(CBMerienda, jSpinnerMerienda, JTMerienda);
        totalCalorias += obtenerCaloriasConPorciones(CBCena, jSpinnerCena, JTCena);
        totalCalorias += obtenerCaloriasConPorciones(CBColaciones, jSpinnerColaciones, JTColaciones);
        JTCaloriasTotales.setText(String.valueOf(totalCalorias));
     }

      // Función para obtener las calorías multiplicadas por las porciones
    private int obtenerCaloriasConPorciones(JComboBox<String> comboBox, JSpinner spinner, JTextField textField) {
            String alimentoSeleccionado = (String) comboBox.getSelectedItem();
            if (alimentoSeleccionado != null && !alimentoSeleccionado.isEmpty()) {
                int caloriasPor100g = alimentoData.obtenerCaloriasPor100g(alimentoSeleccionado);
                int porciones = (Integer) spinner.getValue();
                int caloriasTotales = caloriasPor100g * porciones;
                textField.setText(String.valueOf(caloriasTotales));
                return caloriasTotales;
            }
            // Retornar 0 si no se ha seleccionado un alimento
            return 0;
        }

        
     //Funcion para cargar datos del profesional.
     public void cargarDatosProfesional(){
     
        String nombrex = nutri.getNombre();
        String apellidox = nutri.getApellido();
        String correo = nutri.getCorreo();
        String telefono = String.valueOf(nutri.getTelefono());

        nutriNombre.setText(nombrex);
        nutriApellido.setText(apellidox);
        nutriEmail.setText(correo);
        nutriTelefono.setText(telefono);

        nutriNombre.setEditable(false);
        nutriApellido.setEditable(false);
        nutriTelefono.setEditable(false);
        nutriEmail.setEditable(false);
     }
     
     public void anularDatosPaciente(){
     
         //Anular modificacion de datos en tasa metabolica
         JTTasaMB.setEditable(false);
         
         //Anular modificacion de datos en datos del paciente
            outputNombre.setEditable(false);
            outputApellido.setEditable(false);
            outputEdad.setEditable(false);
            outputAltura.setEditable(false);
            outputPesoActual.setEditable(false);
            outputPesoBuscado.setEditable(false);
            outputGenero.setEditable(false);
            outputCondicion.setEditable(false);
     }
     
     public void cargarDatosPaciente(String nombrePaciente) {
    String sql = "SELECT * FROM paciente WHERE nombre = ?";
    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, nombrePaciente);
        ResultSet rs = ps.executeQuery();


        if (rs.next()) {
  
            outputNombre.setText(rs.getString("nombre"));
            outputApellido.setText(rs.getString("apellido"));
            outputEdad.setText(rs.getString("edad"));
            outputAltura.setText(rs.getString("altura"));
            outputPesoActual.setText(rs.getString("pesoActual"));
            outputPesoBuscado.setText(rs.getString("pesoBuscado"));
            outputGenero.setText(rs.getString("sexo"));
            outputCondicion.setText(rs.getString("condicionEspecial"));
            
            
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos del paciente: " + e.toString());
    }
}
     
     private void calcularTasaMetabolica() {
        try {
            // Convierte los valores de los JTextFields a float, después de verificar que no están vacíos
            float tmb = 0;
            float pesoActualSeleccionado = Float.parseFloat(outputPesoActual.getText().trim());
            float edadSeleccionado = Float.parseFloat(outputEdad.getText().trim());
            float alturaSeleccionado = Float.parseFloat(outputAltura.getText().trim());

            // Compara el género usando equals
            if (outputGenero.getText().equalsIgnoreCase("hombre")) {
                tmb = (float) (88.362 + (13.397 * pesoActualSeleccionado) + (4.799 * alturaSeleccionado) - (5.677 * edadSeleccionado));
            } else if (outputGenero.getText().equalsIgnoreCase("mujer")) {
                tmb = (float) (447.593 + (9.247 * pesoActualSeleccionado) + (3.098 * alturaSeleccionado) - (4.330 * edadSeleccionado));
            } else {
                JOptionPane.showMessageDialog(this, "No hay pacientes seleccionados, asegurese de ingresar un genero valido");
            }

            // Establece el valor calculado en JTTasaMB
            JTTasaMB.setText(String.valueOf(tmb));

        } catch (NumberFormatException e) {
            System.out.println("Error: Asegurate de que todos los campos de peso, edad y altura contienen valores numericos.");
        }
    }
          
     private void crearRenglonMenu(){
           String selectedItemDes = (String) CBDesayuno.getSelectedItem();
           int valorSpinnerDesayuno = (Integer) jSpinnerDesayuno.getValue();
           int valorJTCaloriasDesayuno = Integer.parseInt(JTDesayuno.getText());
           alimentoData.obtenerAlimentoPorNombre(selectedItemDes);
           RenglonMenu renglonDesayuno = new RenglonMenu(1,alimentoData.obtenerAlimentoPorNombre(selectedItemDes),valorSpinnerDesayuno, valorJTCaloriasDesayuno);
           renglonmenuData.agregarRenglon(renglonDesayuno);
           
           String selectedItemAlm = (String) CBAlmuerzo.getSelectedItem();
           int valorSpinnerAlmuerzo = (Integer) jSpinnerAlmuerzo.getValue();
           int valorJTCaloriasAlmuerzo = Integer.parseInt(JTAlmuerzo.getText());
           alimentoData.obtenerAlimentoPorNombre(selectedItemAlm);
           RenglonMenu renglonAlmuerzo = new RenglonMenu(2,alimentoData.obtenerAlimentoPorNombre(selectedItemAlm),valorSpinnerAlmuerzo, valorJTCaloriasAlmuerzo);
           renglonmenuData.agregarRenglon(renglonAlmuerzo);
           
           String selectedItemMer = (String) CBMerienda.getSelectedItem();
           int valorSpinnerMerienda = (Integer) jSpinnerMerienda.getValue();
           int valorJTCaloriasMerienda = Integer.parseInt(JTMerienda.getText());
           alimentoData.obtenerAlimentoPorNombre(selectedItemMer);
           RenglonMenu renglonMerienda = new RenglonMenu(3,alimentoData.obtenerAlimentoPorNombre(selectedItemMer),valorSpinnerMerienda, valorJTCaloriasMerienda);
           renglonmenuData.agregarRenglon(renglonMerienda);
           
           String selectedItemCena = (String) CBCena.getSelectedItem();
           int valorSpinnerCena = (Integer) jSpinnerCena.getValue();
           int valorJTCaloriasCena = Integer.parseInt(JTCena.getText());
           alimentoData.obtenerAlimentoPorNombre(selectedItemCena);
           RenglonMenu renglonCena = new RenglonMenu(4,alimentoData.obtenerAlimentoPorNombre(selectedItemCena),valorSpinnerCena, valorJTCaloriasCena);
           renglonmenuData.agregarRenglon(renglonCena);
           
           String selectedItemCol = (String) CBColaciones.getSelectedItem();
           int valorSpinnerColacion = (Integer) jSpinnerColaciones.getValue();
           int valorJTCaloriasColacion = Integer.parseInt(JTColaciones.getText());
           alimentoData.obtenerAlimentoPorNombre(selectedItemCol);
           RenglonMenu renglonColacion = new RenglonMenu(5,alimentoData.obtenerAlimentoPorNombre(selectedItemCol),valorSpinnerColacion, valorJTCaloriasColacion);
           renglonmenuData.agregarRenglon(renglonColacion);
           
           listaDeRenglones.add(renglonDesayuno);
           listaDeRenglones.add(renglonAlmuerzo);
           listaDeRenglones.add(renglonMerienda);
           listaDeRenglones.add(renglonCena);
           listaDeRenglones.add(renglonColacion);
            
           
    }

   
          
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tituloDatosPaciente = new java.awt.Label();
        jLNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLEdad = new javax.swing.JLabel();
        jLAltura = new javax.swing.JLabel();
        jLPActual = new javax.swing.JLabel();
        jLPBuscado = new javax.swing.JLabel();
        jLGenero = new javax.swing.JLabel();
        jCondiAlimenticia = new javax.swing.JLabel();
        CBPaciente = new javax.swing.JComboBox<>();
        jLPaciente = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        DatosNutricionista = new java.awt.Label();
        jLNombreNutri = new javax.swing.JLabel();
        jLApellidoNutri = new javax.swing.JLabel();
        jLTelefono = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        outputNombre = new javax.swing.JTextField();
        outputApellido = new javax.swing.JTextField();
        outputEdad = new javax.swing.JTextField();
        outputAltura = new javax.swing.JTextField();
        outputPesoActual = new javax.swing.JTextField();
        outputPesoBuscado = new javax.swing.JTextField();
        outputGenero = new javax.swing.JTextField();
        outputCondicion = new javax.swing.JTextField();
        nutriNombre = new javax.swing.JTextField();
        nutriApellido = new javax.swing.JTextField();
        nutriTelefono = new javax.swing.JTextField();
        nutriEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CBAlmuerzo = new javax.swing.JComboBox<>();
        jSpinnerAlmuerzo = new javax.swing.JSpinner();
        JTAlmuerzo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CBDesayuno = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        CBMerienda = new javax.swing.JComboBox<>();
        jSpinnerMerienda = new javax.swing.JSpinner();
        JTMerienda = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        CBCena = new javax.swing.JComboBox<>();
        jSpinnerCena = new javax.swing.JSpinner();
        JTCena = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        CBColaciones = new javax.swing.JComboBox<>();
        jSpinnerColaciones = new javax.swing.JSpinner();
        JTColaciones = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        JTTasaMB = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonSalirDIA2 = new javax.swing.JButton();
        jButtonSalirDIA1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jSpinnerDesayuno = new javax.swing.JSpinner();
        JTDesayuno = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        JTCaloriasTotales = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        DietaPersonalizada = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tituloDatosPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloDatosPaciente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tituloDatosPaciente.setName(""); // NOI18N
        tituloDatosPaciente.setText("DATOS PACIENTE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(tituloDatosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloDatosPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLNombre.setText("Nombre:");

        jLApellido.setText("Apellido:");

        jLEdad.setText("Edad:");

        jLAltura.setText("Altura:");

        jLPActual.setText("Peso Actual:");

        jLPBuscado.setText("Peso Buscado:");

        jLGenero.setText("Genero:");

        jCondiAlimenticia.setText("Condicion alimenticia:");

        CBPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPacienteActionPerformed(evt);
            }
        });

        jLPaciente.setText("Paciente");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DatosNutricionista.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DatosNutricionista.setText("DATOS NUTRICIONISTA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(DatosNutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DatosNutricionista, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLNombreNutri.setText("Nombre:");

        jLApellidoNutri.setText("Apellido:");

        jLTelefono.setText("Telefono:");

        jLEmail.setText("Email:");

        outputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNombreActionPerformed(evt);
            }
        });

        outputCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCondicionActionPerformed(evt);
            }
        });

        nutriNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriNombreActionPerformed(evt);
            }
        });

        nutriApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriApellidoActionPerformed(evt);
            }
        });

        nutriTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriTelefonoActionPerformed(evt);
            }
        });

        nutriEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLPBuscado)
                                                    .addComponent(jLPActual)
                                                    .addComponent(jLAltura)
                                                    .addComponent(jLEdad)
                                                    .addComponent(jLApellido)
                                                    .addComponent(jLNombre)
                                                    .addComponent(jLGenero))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(outputPesoActual)
                                                    .addComponent(outputAltura)
                                                    .addComponent(outputPesoBuscado)
                                                    .addComponent(outputEdad)
                                                    .addComponent(outputApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                                    .addComponent(outputNombre)
                                                    .addComponent(outputGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(outputCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLEmail)
                                            .addComponent(jLTelefono)
                                            .addComponent(jLApellidoNutri)
                                            .addComponent(jLNombreNutri))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nutriNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(nutriApellido)
                                            .addComponent(nutriTelefono)
                                            .addComponent(nutriEmail))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jCondiAlimenticia)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(outputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido)
                    .addComponent(outputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEdad)
                    .addComponent(outputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAltura)
                    .addComponent(outputAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPActual)
                    .addComponent(outputPesoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPBuscado)
                    .addComponent(outputPesoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGenero)
                    .addComponent(outputGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCondiAlimenticia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombreNutri)
                    .addComponent(nutriNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLApellidoNutri)
                    .addComponent(nutriApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono)
                    .addComponent(nutriTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmail)
                    .addComponent(nutriEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Desayuno:");

        CBAlmuerzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBAlmuerzoActionPerformed(evt);
            }
        });

        JTAlmuerzo.setText("kcal");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jSpinnerAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTAlmuerzo)))
                .addGap(9, 9, 9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Almuerzo:");

        CBDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBDesayunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Cena:");

        CBMerienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMeriendaActionPerformed(evt);
            }
        });

        JTMerienda.setText("kcal");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jSpinnerMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(CBMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        CBCena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBCenaActionPerformed(evt);
            }
        });

        JTCena.setText("kcal");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBCena, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jSpinnerCena, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTCena, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(CBCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Colaciones:");

        CBColaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBColacionesActionPerformed(evt);
            }
        });

        JTColaciones.setText("kcal");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jSpinnerColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(CBColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(CBColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTColaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTTasaMB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTTasaMB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTTasaMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTTasaMBActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel16.setText("Tasa Metabólica Basal");

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(JTTasaMB, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel16))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTTasaMB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jButtonSalirDIA2.setText("Continuar");
        jButtonSalirDIA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirDIA2ActionPerformed(evt);
            }
        });

        jButtonSalirDIA1.setText("Salir");
        jButtonSalirDIA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirDIA1ActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Merienda:");

        JTDesayuno.setText("kcal");
        JTDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTDesayunoActionPerformed(evt);
            }
        });

        JTCaloriasTotales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTCaloriasTotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTCaloriasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTCaloriasTotalesActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel21.setText("Calorias totales por dia");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(JTCaloriasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTCaloriasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel17)
                .addGap(186, 186, 186)
                .addComponent(jLabel18)
                .addGap(171, 171, 171)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jSpinnerDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(JTDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel23)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButtonSalirDIA1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonSalirDIA2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addGap(167, 167, 167))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(548, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinnerDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSalirDIA2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSalirDIA1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(202, 202, 202)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DietaPersonalizada.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DietaPersonalizada.setText("DIETA PERSONALIZADA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DietaPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DietaPersonalizada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirDIA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirDIA1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalirDIA1ActionPerformed

    private void jButtonSalirDIA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirDIA2ActionPerformed
        crearRenglonMenu();
        /*   contadorClics++;

           if (contadorClics == 5) {
             Dieta dieta = new Dieta("Dieta de ejemplo",new Date(), new Date(),new Paciente(123), 
                   70.0, // Peso inicial
                   68.0, // Peso final
                   true, // Estado
                   "Baja en carbohidratos" // Tipo de dieta
               );

   
               MenuDiario menuDiario = new MenuDiario(1,Integer.parseInt(JTCaloriasTotales.getText()), (ArrayList<RenglonMenu>) listaDeRenglones,"Activa",dieta);

              dietadata.agregarDieta(dieta);

               MenuDiarioData menuDiarioData = new MenuDiarioData();
              menuDiarioData.agregarMenuDiario(menuDiario);
               contadorClics = 0;
               JOptionPane.showMessageDialog(null, "Dieta y Menú Diario creados con éxito.");
               
           }*/
        
    }//GEN-LAST:event_jButtonSalirDIA2ActionPerformed

    private void CBDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBDesayunoActionPerformed

    }//GEN-LAST:event_CBDesayunoActionPerformed

    private void JTTasaMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTTasaMBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTTasaMBActionPerformed

    private void outputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombreActionPerformed

    private void outputCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCondicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCondicionActionPerformed

    private void CBPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPacienteActionPerformed
       //Rellenar combobox con pacientes desde la base de datos
       
       
       
    }//GEN-LAST:event_CBPacienteActionPerformed

    private void nutriNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriNombreActionPerformed

    }//GEN-LAST:event_nutriNombreActionPerformed

    private void nutriApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriApellidoActionPerformed
        nutriApellido.setText("Profe");
    }//GEN-LAST:event_nutriApellidoActionPerformed

    private void nutriTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriTelefonoActionPerformed
        nutriTelefono.setText("265728425");
    }//GEN-LAST:event_nutriTelefonoActionPerformed

    private void nutriEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriEmailActionPerformed
        nutriEmail.setText("juanjo_el+capo@gmail.com");
    }//GEN-LAST:event_nutriEmailActionPerformed

    private void JTCaloriasTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTCaloriasTotalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTCaloriasTotalesActionPerformed

    private void CBAlmuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBAlmuerzoActionPerformed
 
    }//GEN-LAST:event_CBAlmuerzoActionPerformed

    private void CBMeriendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMeriendaActionPerformed
       
    }//GEN-LAST:event_CBMeriendaActionPerformed

    private void CBCenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBCenaActionPerformed

    }//GEN-LAST:event_CBCenaActionPerformed

    private void CBColacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBColacionesActionPerformed

    }//GEN-LAST:event_CBColacionesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       calcularTasaMetabolica();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTDesayunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTDesayunoActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DietaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DietaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DietaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DietaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DietaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBAlmuerzo;
    private javax.swing.JComboBox<String> CBCena;
    private javax.swing.JComboBox<String> CBColaciones;
    private javax.swing.JComboBox<String> CBDesayuno;
    private javax.swing.JComboBox<String> CBMerienda;
    private javax.swing.JComboBox<String> CBPaciente;
    private java.awt.Label DatosNutricionista;
    private java.awt.Label DietaPersonalizada;
    private javax.swing.JTextField JTAlmuerzo;
    private javax.swing.JTextField JTCaloriasTotales;
    private javax.swing.JTextField JTCena;
    private javax.swing.JTextField JTColaciones;
    private javax.swing.JTextField JTDesayuno;
    private javax.swing.JTextField JTMerienda;
    private javax.swing.JTextField JTTasaMB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSalirDIA1;
    private javax.swing.JButton jButtonSalirDIA2;
    private javax.swing.JLabel jCondiAlimenticia;
    private javax.swing.JLabel jLAltura;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLApellidoNutri;
    private javax.swing.JLabel jLEdad;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLGenero;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLNombreNutri;
    private javax.swing.JLabel jLPActual;
    private javax.swing.JLabel jLPBuscado;
    private javax.swing.JLabel jLPaciente;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner jSpinnerAlmuerzo;
    private javax.swing.JSpinner jSpinnerCena;
    private javax.swing.JSpinner jSpinnerColaciones;
    private javax.swing.JSpinner jSpinnerDesayuno;
    private javax.swing.JSpinner jSpinnerMerienda;
    private javax.swing.JTextField nutriApellido;
    private javax.swing.JTextField nutriEmail;
    private javax.swing.JTextField nutriNombre;
    private javax.swing.JTextField nutriTelefono;
    private javax.swing.JTextField outputAltura;
    private javax.swing.JTextField outputApellido;
    private javax.swing.JTextField outputCondicion;
    private javax.swing.JTextField outputEdad;
    private javax.swing.JTextField outputGenero;
    private javax.swing.JTextField outputNombre;
    private javax.swing.JTextField outputPesoActual;
    private javax.swing.JTextField outputPesoBuscado;
    private java.awt.Label tituloDatosPaciente;
    // End of variables declaration//GEN-END:variables

    private void cargarPacientesEnComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
