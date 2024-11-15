package nutricionistaVista;

import entidades.Profesional;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRBMFormulario = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jRBMFormulario1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jConsultarDieta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1438, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 802, Short.MAX_VALUE)
        );

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
        jRBMFormulario1.setText("Dieta");
        jRBMFormulario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMFormulario1ActionPerformed(evt);
            }
        });
        jMenu2.add(jRBMFormulario1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Dieta Automatica");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Modificar");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jConsultarDieta.setText("Modificar Paciente");
        jConsultarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarDietaActionPerformed(evt);
            }
        });
        jMenu4.add(jConsultarDieta);

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
        escritorio.removeAll();
        escritorio.repaint();
        FormularioVista form = new FormularioVista();   
        escritorio.add(form);
        form.setVisible(true);
        form.setSize(800, 750);
        escritorio.moveToFront(form);
    }//GEN-LAST:event_jRBMFormularioActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jRBMFormulario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMFormulario1ActionPerformed
       new DietaVista().setVisible(true);
    }//GEN-LAST:event_jRBMFormulario1ActionPerformed

    private void jConsultarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarDietaActionPerformed
    ConsultarVista consu = new ConsultarVista();
    consu.setSize(800, 750);
    consu.setVisible(true);
    escritorio.add(consu);
    consu.setLocation(
        (escritorio.getWidth() - consu.getWidth()) / 2,
        (escritorio.getHeight() - consu.getHeight()) / 2
    );

    }//GEN-LAST:event_jConsultarDietaActionPerformed

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


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jConsultarDieta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRBMFormulario;
    private javax.swing.JRadioButtonMenuItem jRBMFormulario1;
    // End of variables declaration//GEN-END:variables
}
