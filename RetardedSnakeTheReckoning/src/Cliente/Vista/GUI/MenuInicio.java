/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Vista.GUI;

import javax.swing.JPanel;

/**
 *
 * @author Markos
 */
public class MenuInicio extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicio
     */
    public MenuInicio() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuInicio = new javax.swing.JPanel();
        jButtonOnline = new javax.swing.JButton();
        jButtonOffline = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonOnline.setText("ONLINE");
        jButtonOnline.setToolTipText("");
        jButtonOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOnlineActionPerformed(evt);
            }
        });

        jButtonOffline.setText("OFFLINE");
        jButtonOffline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOfflineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuInicioLayout = new javax.swing.GroupLayout(jPanelMenuInicio);
        jPanelMenuInicio.setLayout(jPanelMenuInicioLayout);
        jPanelMenuInicioLayout.setHorizontalGroup(
            jPanelMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuInicioLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(jPanelMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonOnline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOffline, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addGap(115, 115, 115))
        );
        jPanelMenuInicioLayout.setVerticalGroup(
            jPanelMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuInicioLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(jButtonOffline, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        /*Metodo del metodo boton online el cual nos lleva al menu de online en el cual ponemos los datos necesarios
        para realizar la conexion
        Primero eliminamos el panel de dentro para insertar el del menu correspondiente*/
    private void jButtonOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOnlineActionPerformed
        //this.remove(jPanelMenuInicio);
        this.dispose();
        MenuOnline mn= new MenuOnline();
        //this.add(mn.getjPanelMenuOnline());
        mn.setVisible(true);
    }//GEN-LAST:event_jButtonOnlineActionPerformed

    private void jButtonOfflineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOfflineActionPerformed
        Arena arena = new Arena(false);
        arena.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonOfflineActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOffline;
    private javax.swing.JButton jButtonOnline;
    private javax.swing.JPanel jPanelMenuInicio;
    // End of variables declaration//GEN-END:variables

    public JPanel getjPanelMenuInicio() {
        return jPanelMenuInicio;
    }

}