package nutricionistaVista;

import entidades.Profesional;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ferna
 */
public class PrincipalVista extends javax.swing.JFrame {
    /**
     * Creates new form PrincipalVista
     */
    public PrincipalVista() {
        initComponents();
        setLocationRelativeTo(null);
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRBMFormulario = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jRBMFormulario1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        DietaAutomatica = new javax.swing.JMenu();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        modificarPaciente = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(51, 255, 51));
        escritorio.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 255, 51), null));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nutrilogola.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/signo-de-interrogacion.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/manzana.png"))); // NOI18N

        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addGap(0, 428, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(207, 207, 207))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 255, 153));

        jMenu1.setBackground(new java.awt.Color(51, 255, 255));
        jMenu1.setText("Formulario");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jRBMFormulario.setSelected(true);
        jRBMFormulario.setText("Formulario");
        jRBMFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMFormularioActionPerformed(evt);
            }
        });
        jMenu1.add(jRBMFormulario);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Dieta");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jRBMFormulario1.setSelected(true);
        jRBMFormulario1.setText("Dieta Manual");
        jRBMFormulario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMFormulario1ActionPerformed(evt);
            }
        });
        jMenu2.add(jRBMFormulario1);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Dieta Automatica");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu2);

        DietaAutomatica.setText("Buscar");
        DietaAutomatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DietaAutomaticaActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("Buscar Alimento");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        DietaAutomatica.add(jRadioButtonMenuItem3);

        jMenuBar1.add(DietaAutomatica);

        jMenu4.setText("Modificar");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        modificarPaciente.setSelected(true);
        modificarPaciente.setText("Modificar Paciente");
        modificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPacienteActionPerformed(evt);
            }
        });
        jMenu4.add(modificarPaciente);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Agregar Alimento");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jRadioButtonMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jRBMFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMFormularioActionPerformed
        FormularioVista form = new FormularioVista();   
        escritorio.add(form);
        form.setVisible(true);
        form.setSize(600, 700);
        escritorio.moveToFront(form);
    }//GEN-LAST:event_jRBMFormularioActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jRBMFormulario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMFormulario1ActionPerformed
       new DietaVista().setVisible(true);
    }//GEN-LAST:event_jRBMFormulario1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
    ConsultarVista consu = new ConsultarVista();
    consu.setSize(800, 750);
    consu.setVisible(true);
    escritorio.add(consu);
    consu.setLocation(
        (escritorio.getWidth() - consu.getWidth()) / 2,
        (escritorio.getHeight() - consu.getHeight()) / 2
    );

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void DietaAutomaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DietaAutomaticaActionPerformed

    }//GEN-LAST:event_DietaAutomaticaActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed

        DietaAutomatica auto = new DietaAutomatica();   
        escritorio.add(auto);
        auto.setVisible(true);
        auto.setSize(1250, 650);
        escritorio.moveToFront(auto);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void modificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPacienteActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ConsultarVista consu = new ConsultarVista();   
        escritorio.add(consu);
        consu.setVisible(true);
        consu.setSize(900, 500);
        escritorio.moveToFront(consu);
    }//GEN-LAST:event_modificarPacienteActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed

        BuscarAlimento busca = new BuscarAlimento();   
        escritorio.add(busca);
        busca.setVisible(true);
        busca.setSize(5000, 1000);
        escritorio.moveToFront(busca);
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed

        AgregarAlimento agregar = new AgregarAlimento();   
        escritorio.add(agregar);
        agregar.setVisible(true);
        agregar.setSize(600, 500);
        escritorio.moveToFront(agregar);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DietaAutomatica;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRBMFormulario;
    private javax.swing.JRadioButtonMenuItem jRBMFormulario1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem modificarPaciente;
    // End of variables declaration//GEN-END:variables

class Fondo extends JPanel{
    private Image imagen;
            public void paint(Graphics g){
                imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();
            }
}
}
