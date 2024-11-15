/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package nutricionistaVista;

import conexion.Conexion;
import conexion.pacienteData;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class menuDiariosYDieta extends javax.swing.JPanel {

   private java.sql.Connection con = null;
   private pacienteData pacienteData;
   
    public menuDiariosYDieta() {
        initComponents();
        con = Conexion.getConexion();
        pacienteData = new pacienteData();
        cargarDatosProfesional();
        anularDatosPaciente();
        
        
        //Rellenar comboBox con pacientes
         /// Metodo para cargar alimentos en los ComboBo
     
        pacienteData.rellenarComboBox("paciente", "nombre", CBPaciente2);
           CBPaciente2.addItemListener(new ItemListener() {
               @Override
                   public void itemStateChanged(ItemEvent e) {
                       if (e.getStateChange() == ItemEvent.SELECTED) {
                           String selectedPaciente = CBPaciente2.getSelectedItem().toString();
                           cargarDatosPaciente(selectedPaciente);
                       }
                   }
           });
        
    }

   public void cargarDatosPaciente(String nombrePaciente) {
        String sql = "SELECT * FROM paciente WHERE nombre = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombrePaciente);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {

                outputNombre2.setText(rs.getString("nombre"));
                outputApellido2.setText(rs.getString("apellido"));
                outputEdad2.setText(rs.getString("edad"));
                outputAltura2.setText(rs.getString("altura"));
                outputPesoActual2.setText(rs.getString("pesoActual"));
                outputPesoBuscado2.setText(rs.getString("pesoBuscado"));
                outputGenero2.setText(rs.getString("sexo"));
                outputCondicion2.setText(rs.getString("condicionEspecial"));



            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del paciente: " + e.toString());
        }
   }
    
    public void cargarDatosProfesional(){
   
        nutriNombre2.setText("Juanjo");
        nutriApellido2.setText("Profe");
        nutriTelefono2.setText("2657305212");
        nutriEmail2.setText("CorreoJuanjo123@hotmail.com");
   }
   
    public void anularDatosPaciente(){       
         //Anular modificacion de datos en datos del paciente
            outputNombre2.setEditable(false);
            outputApellido2.setEditable(false);
            outputEdad2.setEditable(false);
            outputAltura2.setEditable(false);
            outputPesoActual2.setEditable(false);
            outputPesoBuscado2.setEditable(false);
            outputGenero2.setEditable(false);
            outputCondicion2.setEditable(false);
            nutriNombre2.setEditable(false);
            nutriApellido2.setEditable(false);
            nutriTelefono2.setEditable(false);
            nutriEmail2.setEditable(false);
            outputDesayuno1.setEditable(false);
            outputDesayuno2.setEditable(false);
            outputDesayuno3.setEditable(false);
            outputDesayuno4.setEditable(false);
            outputDesayuno5.setEditable(false);
            outputAlmuerzo1.setEditable(false);
            outputAlmuerzo2.setEditable(false);
            outputAlmuerzo3.setEditable(false);
            outputAlmuerzo4.setEditable(false);
            outputAlmuerzo5.setEditable(false);
            outputMerienda1.setEditable(false);
            outputMerienda2.setEditable(false);
            outputMerienda3.setEditable(false);
            outputMerienda4.setEditable(false);
            outputMerienda5.setEditable(false);
            outputCena1.setEditable(false);
            outputCena2.setEditable(false);
            outputCena3.setEditable(false);
            outputCena4.setEditable(false);
            outputCena5.setEditable(false);
            outputColacion1.setEditable(false);
            outputColacion2.setEditable(false);
            outputColacion3.setEditable(false);
            outputColacion4.setEditable(false);
            outputColacion5.setEditable(false);
               
     }
    
    public void rellenarMenuDiario(){
            outputDesayuno1.setText("");
            outputDesayuno2.setText("");
            outputDesayuno3.setText("");
            outputDesayuno4.setText("");
            outputDesayuno5.setText("");
            outputAlmuerzo1.setText("");
            outputAlmuerzo2.setText("");
            outputAlmuerzo3.setText("");
            outputAlmuerzo4.setText("");
            outputAlmuerzo5.setText("");
            outputMerienda1.setText("");
            outputMerienda2.setText("");
            outputMerienda3.setText("");
            outputMerienda4.setText("");
            outputMerienda5.setText("");
            outputCena1.setText("");
            outputCena2.setText("");
            outputCena3.setText("");
            outputCena4.setText("");
            outputCena5.setText("");
            outputColacion1.setText("");
            outputColacion2.setText("");
            outputColacion3.setText("");
            outputColacion4.setText("");
            outputColacion5.setText("");
    
    
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tituloDatosPaciente2 = new java.awt.Label();
        jLNombre2 = new javax.swing.JLabel();
        jLApellido2 = new javax.swing.JLabel();
        jLEdad2 = new javax.swing.JLabel();
        jLAltura2 = new javax.swing.JLabel();
        jLPActual2 = new javax.swing.JLabel();
        jLPBuscado2 = new javax.swing.JLabel();
        jLGenero2 = new javax.swing.JLabel();
        jCondiAlimenticia2 = new javax.swing.JLabel();
        CBPaciente2 = new javax.swing.JComboBox<>();
        jLPaciente2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        DatosNutricionista2 = new java.awt.Label();
        jLNombreNutri2 = new javax.swing.JLabel();
        jLApellidoNutri2 = new javax.swing.JLabel();
        jLTelefono2 = new javax.swing.JLabel();
        jLEmail2 = new javax.swing.JLabel();
        outputNombre2 = new javax.swing.JTextField();
        outputApellido2 = new javax.swing.JTextField();
        outputEdad2 = new javax.swing.JTextField();
        outputAltura2 = new javax.swing.JTextField();
        outputPesoActual2 = new javax.swing.JTextField();
        outputPesoBuscado2 = new javax.swing.JTextField();
        outputGenero2 = new javax.swing.JTextField();
        outputCondicion2 = new javax.swing.JTextField();
        nutriNombre2 = new javax.swing.JTextField();
        nutriApellido2 = new javax.swing.JTextField();
        nutriTelefono2 = new javax.swing.JTextField();
        nutriEmail2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        outputDesayuno1 = new javax.swing.JTextField();
        outputAlmuerzo1 = new javax.swing.JTextField();
        outputMerienda1 = new javax.swing.JTextField();
        outputColacion1 = new javax.swing.JTextField();
        outputCena1 = new javax.swing.JTextField();
        outputColacion2 = new javax.swing.JTextField();
        outputCena2 = new javax.swing.JTextField();
        outputMerienda2 = new javax.swing.JTextField();
        outputAlmuerzo2 = new javax.swing.JTextField();
        outputDesayuno2 = new javax.swing.JTextField();
        outputColacion3 = new javax.swing.JTextField();
        outputCena3 = new javax.swing.JTextField();
        outputMerienda3 = new javax.swing.JTextField();
        outputAlmuerzo3 = new javax.swing.JTextField();
        outputDesayuno3 = new javax.swing.JTextField();
        outputColacion4 = new javax.swing.JTextField();
        outputCena4 = new javax.swing.JTextField();
        outputMerienda4 = new javax.swing.JTextField();
        outputAlmuerzo4 = new javax.swing.JTextField();
        outputDesayuno4 = new javax.swing.JTextField();
        outputColacion5 = new javax.swing.JTextField();
        outputCena5 = new javax.swing.JTextField();
        outputMerienda5 = new javax.swing.JTextField();
        outputAlmuerzo5 = new javax.swing.JTextField();
        outputDesayuno5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tituloDatosPaciente2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloDatosPaciente2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tituloDatosPaciente2.setName(""); // NOI18N
        tituloDatosPaciente2.setText("DATOS PACIENTE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(tituloDatosPaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloDatosPaciente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLNombre2.setText("Nombre:");

        jLApellido2.setText("Apellido:");

        jLEdad2.setText("Edad:");

        jLAltura2.setText("Altura:");

        jLPActual2.setText("Peso Actual:");

        jLPBuscado2.setText("Peso Buscado:");

        jLGenero2.setText("Genero:");

        jCondiAlimenticia2.setText("Condicion alimenticia:");

        CBPaciente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPaciente2ActionPerformed(evt);
            }
        });

        jLPaciente2.setText("Paciente");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DatosNutricionista2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DatosNutricionista2.setText("DATOS NUTRICIONISTA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(DatosNutricionista2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DatosNutricionista2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLNombreNutri2.setText("Nombre:");

        jLApellidoNutri2.setText("Apellido:");

        jLTelefono2.setText("Telefono:");

        jLEmail2.setText("Email:");

        outputNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputNombre2ActionPerformed(evt);
            }
        });

        outputCondicion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCondicion2ActionPerformed(evt);
            }
        });

        nutriNombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriNombre2ActionPerformed(evt);
            }
        });

        nutriApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriApellido2ActionPerformed(evt);
            }
        });

        nutriTelefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriTelefono2ActionPerformed(evt);
            }
        });

        nutriEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutriEmail2ActionPerformed(evt);
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
                        .addComponent(jLPaciente2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBPaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                    .addComponent(jLPBuscado2)
                                                    .addComponent(jLPActual2)
                                                    .addComponent(jLAltura2)
                                                    .addComponent(jLEdad2)
                                                    .addComponent(jLApellido2)
                                                    .addComponent(jLNombre2)
                                                    .addComponent(jLGenero2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(outputPesoActual2)
                                                    .addComponent(outputAltura2)
                                                    .addComponent(outputPesoBuscado2)
                                                    .addComponent(outputEdad2)
                                                    .addComponent(outputApellido2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                                    .addComponent(outputNombre2)
                                                    .addComponent(outputGenero2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(outputCondicion2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLEmail2)
                                            .addComponent(jLTelefono2)
                                            .addComponent(jLApellidoNutri2)
                                            .addComponent(jLNombreNutri2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nutriNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(nutriApellido2)
                                            .addComponent(nutriTelefono2)
                                            .addComponent(nutriEmail2))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jCondiAlimenticia2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBPaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPaciente2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre2)
                    .addComponent(outputNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido2)
                    .addComponent(outputApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEdad2)
                    .addComponent(outputEdad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAltura2)
                    .addComponent(outputAltura2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPActual2)
                    .addComponent(outputPesoActual2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPBuscado2)
                    .addComponent(outputPesoBuscado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGenero2)
                    .addComponent(outputGenero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCondiAlimenticia2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputCondicion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombreNutri2)
                    .addComponent(nutriNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLApellidoNutri2)
                    .addComponent(nutriApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono2)
                    .addComponent(nutriTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmail2)
                    .addComponent(nutriEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Desayuno:");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Almuerzo:");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Merienda:");

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Cena:");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Colaciones:");

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Desayuno:");

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Almuerzo:");

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Merienda:");

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Cena:");

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Colaciones:");

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Desayuno:");

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Almuerzo:");

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Merienda:");

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Cena:");

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Colaciones:");

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Desayuno:");

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Almuerzo:");

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Merienda:");

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Cena:");

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Colaciones:");

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Desayuno:");

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Almuerzo:");

        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Merienda:");

        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Cena:");

        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Colaciones:");

        outputDesayuno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDesayuno1ActionPerformed(evt);
            }
        });

        outputAlmuerzo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputAlmuerzo1ActionPerformed(evt);
            }
        });

        outputMerienda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputMerienda1ActionPerformed(evt);
            }
        });

        outputColacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputColacion1ActionPerformed(evt);
            }
        });

        outputCena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCena1ActionPerformed(evt);
            }
        });

        outputColacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputColacion2ActionPerformed(evt);
            }
        });

        outputCena2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCena2ActionPerformed(evt);
            }
        });

        outputMerienda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputMerienda2ActionPerformed(evt);
            }
        });

        outputAlmuerzo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputAlmuerzo2ActionPerformed(evt);
            }
        });

        outputDesayuno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDesayuno2ActionPerformed(evt);
            }
        });

        outputColacion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputColacion3ActionPerformed(evt);
            }
        });

        outputCena3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCena3ActionPerformed(evt);
            }
        });

        outputMerienda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputMerienda3ActionPerformed(evt);
            }
        });

        outputAlmuerzo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputAlmuerzo3ActionPerformed(evt);
            }
        });

        outputDesayuno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDesayuno3ActionPerformed(evt);
            }
        });

        outputColacion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputColacion4ActionPerformed(evt);
            }
        });

        outputCena4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCena4ActionPerformed(evt);
            }
        });

        outputMerienda4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputMerienda4ActionPerformed(evt);
            }
        });

        outputAlmuerzo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputAlmuerzo4ActionPerformed(evt);
            }
        });

        outputDesayuno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDesayuno4ActionPerformed(evt);
            }
        });

        outputColacion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputColacion5ActionPerformed(evt);
            }
        });

        outputCena5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputCena5ActionPerformed(evt);
            }
        });

        outputMerienda5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputMerienda5ActionPerformed(evt);
            }
        });

        outputAlmuerzo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputAlmuerzo5ActionPerformed(evt);
            }
        });

        outputDesayuno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputDesayuno5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Dia 1");

        jLabel2.setText("Dia 2");

        jLabel3.setText("Dia 3");

        jLabel4.setText("Dia 4");

        jLabel5.setText("Dia 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(50, 50, 50)
                                        .addComponent(outputDesayuno4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(jLabel27)
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel28)
                                        .addGap(85, 85, 85)
                                        .addComponent(jLabel29)
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel30)
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel31)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22)
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel24)
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel25)
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel26)
                                        .addGap(23, 23, 23))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addGap(86, 86, 86)
                                                        .addComponent(jLabel18)
                                                        .addGap(28, 28, 28))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(outputDesayuno1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(outputDesayuno5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(42, 42, 42)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(outputAlmuerzo5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(outputAlmuerzo1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 12, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(outputDesayuno2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(outputAlmuerzo2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(outputDesayuno3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(outputAlmuerzo3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(outputAlmuerzo4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel19)
                                                .addGap(121, 121, 121)
                                                .addComponent(jLabel20)
                                                .addGap(103, 103, 103)
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(outputMerienda5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(outputCena5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(outputMerienda4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(outputCena4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(outputMerienda3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(outputCena3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(outputMerienda2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(outputCena2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(outputMerienda1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(outputCena1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(outputColacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(outputColacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(outputColacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(outputColacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(outputColacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(161, 161, 161))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel33)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel34)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel35)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel36))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel37)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel38)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel39)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel40)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel41)))
                        .addGap(185, 185, 185))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputDesayuno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputAlmuerzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputMerienda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputColacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputCena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputDesayuno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputAlmuerzo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputMerienda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputCena2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputColacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputDesayuno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputAlmuerzo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputMerienda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputColacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputCena3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputDesayuno4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputAlmuerzo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputMerienda4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputColacion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputCena4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputDesayuno5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputAlmuerzo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputMerienda5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputColacion5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputCena5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CBPaciente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPaciente2ActionPerformed
        //Rellenar combobox con pacientes desde la base de datos

    }//GEN-LAST:event_CBPaciente2ActionPerformed

    private void outputNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputNombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputNombre2ActionPerformed

    private void outputCondicion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCondicion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCondicion2ActionPerformed

    private void nutriNombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriNombre2ActionPerformed
       
    }//GEN-LAST:event_nutriNombre2ActionPerformed

    private void nutriApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriApellido2ActionPerformed
     
    }//GEN-LAST:event_nutriApellido2ActionPerformed

    private void nutriTelefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriTelefono2ActionPerformed
    
    }//GEN-LAST:event_nutriTelefono2ActionPerformed

    private void nutriEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutriEmail2ActionPerformed
          
    }//GEN-LAST:event_nutriEmail2ActionPerformed

    private void outputDesayuno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDesayuno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputDesayuno1ActionPerformed

    private void outputAlmuerzo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputAlmuerzo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputAlmuerzo1ActionPerformed

    private void outputMerienda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputMerienda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputMerienda1ActionPerformed

    private void outputColacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputColacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputColacion1ActionPerformed

    private void outputCena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCena1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCena1ActionPerformed

    private void outputColacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputColacion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputColacion2ActionPerformed

    private void outputCena2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCena2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCena2ActionPerformed

    private void outputMerienda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputMerienda2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputMerienda2ActionPerformed

    private void outputAlmuerzo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputAlmuerzo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputAlmuerzo2ActionPerformed

    private void outputDesayuno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDesayuno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputDesayuno2ActionPerformed

    private void outputColacion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputColacion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputColacion3ActionPerformed

    private void outputCena3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCena3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCena3ActionPerformed

    private void outputMerienda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputMerienda3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputMerienda3ActionPerformed

    private void outputAlmuerzo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputAlmuerzo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputAlmuerzo3ActionPerformed

    private void outputDesayuno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDesayuno3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputDesayuno3ActionPerformed

    private void outputColacion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputColacion4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputColacion4ActionPerformed

    private void outputCena4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCena4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCena4ActionPerformed

    private void outputMerienda4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputMerienda4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputMerienda4ActionPerformed

    private void outputAlmuerzo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputAlmuerzo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputAlmuerzo4ActionPerformed

    private void outputDesayuno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDesayuno4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputDesayuno4ActionPerformed

    private void outputColacion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputColacion5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputColacion5ActionPerformed

    private void outputCena5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputCena5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputCena5ActionPerformed

    private void outputMerienda5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputMerienda5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputMerienda5ActionPerformed

    private void outputAlmuerzo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputAlmuerzo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputAlmuerzo5ActionPerformed

    private void outputDesayuno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputDesayuno5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputDesayuno5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBPaciente2;
    private java.awt.Label DatosNutricionista2;
    private javax.swing.JLabel jCondiAlimenticia2;
    private javax.swing.JLabel jLAltura2;
    private javax.swing.JLabel jLApellido2;
    private javax.swing.JLabel jLApellidoNutri2;
    private javax.swing.JLabel jLEdad2;
    private javax.swing.JLabel jLEmail2;
    private javax.swing.JLabel jLGenero2;
    private javax.swing.JLabel jLNombre2;
    private javax.swing.JLabel jLNombreNutri2;
    private javax.swing.JLabel jLPActual2;
    private javax.swing.JLabel jLPBuscado2;
    private javax.swing.JLabel jLPaciente2;
    private javax.swing.JLabel jLTelefono2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField nutriApellido2;
    private javax.swing.JTextField nutriEmail2;
    private javax.swing.JTextField nutriNombre2;
    private javax.swing.JTextField nutriTelefono2;
    private javax.swing.JTextField outputAlmuerzo1;
    private javax.swing.JTextField outputAlmuerzo2;
    private javax.swing.JTextField outputAlmuerzo3;
    private javax.swing.JTextField outputAlmuerzo4;
    private javax.swing.JTextField outputAlmuerzo5;
    private javax.swing.JTextField outputAltura2;
    private javax.swing.JTextField outputApellido2;
    private javax.swing.JTextField outputCena1;
    private javax.swing.JTextField outputCena2;
    private javax.swing.JTextField outputCena3;
    private javax.swing.JTextField outputCena4;
    private javax.swing.JTextField outputCena5;
    private javax.swing.JTextField outputColacion1;
    private javax.swing.JTextField outputColacion2;
    private javax.swing.JTextField outputColacion3;
    private javax.swing.JTextField outputColacion4;
    private javax.swing.JTextField outputColacion5;
    private javax.swing.JTextField outputCondicion2;
    private javax.swing.JTextField outputDesayuno1;
    private javax.swing.JTextField outputDesayuno2;
    private javax.swing.JTextField outputDesayuno3;
    private javax.swing.JTextField outputDesayuno4;
    private javax.swing.JTextField outputDesayuno5;
    private javax.swing.JTextField outputEdad2;
    private javax.swing.JTextField outputGenero2;
    private javax.swing.JTextField outputMerienda1;
    private javax.swing.JTextField outputMerienda2;
    private javax.swing.JTextField outputMerienda3;
    private javax.swing.JTextField outputMerienda4;
    private javax.swing.JTextField outputMerienda5;
    private javax.swing.JTextField outputNombre2;
    private javax.swing.JTextField outputPesoActual2;
    private javax.swing.JTextField outputPesoBuscado2;
    private java.awt.Label tituloDatosPaciente2;
    // End of variables declaration//GEN-END:variables
}
