/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Vista.GUI;

//import Cliente.Conectividad.Cliente;

import Cliente.Conectividad.Cliente;
import Cliente.Conectividad.ControladorCliente;
import Cliente.Conectividad.MovimientoSnake;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Markos
 */
public class MenuOnline extends javax.swing.JFrame {

    /**
     * Creates new form MenuOnline
     */
    public MenuOnline() {
        initComponents();
                /* Create and display the form */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuOnline = new javax.swing.JPanel();
        jButtonAtras = new javax.swing.JButton();
        jButtonStartGame = new javax.swing.JButton();
        labelSocket = new java.awt.Label();
        labelNumberIP = new java.awt.Label();
        labelPlayerName = new java.awt.Label();
        jTextFieldNamePlayer = new javax.swing.JTextField();
        jTextFieldDireccionIP = new javax.swing.JTextField();
        jTextFieldSocket = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jButtonStartGame.setText("Are you ready? GO!!");
        jButtonStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartGameActionPerformed(evt);
            }
        });

        labelSocket.setText("Socket");

        labelNumberIP.setText("Direccion IP");

        labelPlayerName.setText("Nombre de jugador");

        jTextFieldNamePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamePlayerActionPerformed(evt);
            }
        });
        jTextFieldNamePlayer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNamePlayerKeyTyped(evt);
            }
        });

        jTextFieldDireccionIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDireccionIPActionPerformed(evt);
            }
        });

        jTextFieldSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSocketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuOnlineLayout = new javax.swing.GroupLayout(jPanelMenuOnline);
        jPanelMenuOnline.setLayout(jPanelMenuOnlineLayout);
        jPanelMenuOnlineLayout.setHorizontalGroup(
                jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                                .addComponent(labelPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTextFieldNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(labelSocket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(labelNumberIP, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldDireccionIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldSocket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(26, 26, 26))
                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                .addComponent(jButtonStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                                .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55))))
        );
        jPanelMenuOnlineLayout.setVerticalGroup(
                jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuOnlineLayout.createSequentialGroup()
                                .addContainerGap(64, Short.MAX_VALUE)
                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldNamePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelNumberIP, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(jTextFieldSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelMenuOnlineLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(labelSocket, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addGroup(jPanelMenuOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMenuOnline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelMenuOnline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*Metodo del metodo boton atras el cual nos lleva al menu de inicio en el cual se elige
        que si queremos jugar o no de forma online
        Primero eliminamos el panel de dentro para insertar el del menu correspondiente*/
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed

        this.dispose();
        // this.remove(jPanelMenuOnline);
        MenuInicio mi = new MenuInicio();
        //this.add(mi.getjPanelMenuInicio());
        mi.setVisible(true);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    /*Metodo del metodo boton atras el cual nos lleva al menu de inicio en el cual se elige
        que si queremos jugar o no de forma online
        Primero eliminamos el panel de dentro para insertar el del menu correspondiente*/
    private void jButtonStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartGameActionPerformed
        try {
            String player = this.jTextFieldNamePlayer.getText();
            String Ip = this.jTextFieldDireccionIP.getText();
            int puerto = Integer.parseInt(this.jTextFieldSocket.getText());


            Puntuacion puntuacion = new Puntuacion(player);
            puntuacion.setLocationRelativeTo(null);
            puntuacion.setVisible(true);
            Arena arena = new Arena(true);
            arena.setVisible(true);

            Cliente cl = new Cliente(player, Ip, puerto, new ControladorCliente(arena,new MovimientoSnake(arena,30,30,true),puntuacion));
            cl.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButtonStartGameActionPerformed

    /*Introduciremos el nombre del jugador en este campo de texto para luego ponerlo en las acciones de juego*/
    private void jTextFieldNamePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamePlayerActionPerformed
        this.setEditable(true);
    }//GEN-LAST:event_jTextFieldNamePlayerActionPerformed

    private void jTextFieldNamePlayerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNamePlayerKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamePlayerKeyTyped

    private void jTextFieldDireccionIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDireccionIPActionPerformed
        this.setEditable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDireccionIPActionPerformed

    private void jTextFieldSocketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSocketActionPerformed
        //this.setEditable(true);
    }//GEN-LAST:event_jTextFieldSocketActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JPanel jPanelMenuOnline;
    private javax.swing.JTextField jTextFieldDireccionIP;
    private javax.swing.JTextField jTextFieldNamePlayer;
    private javax.swing.JTextField jTextFieldSocket;
    private java.awt.Label labelNumberIP;
    private java.awt.Label labelPlayerName;
    private java.awt.Label labelSocket;
    // End of variables declaration//GEN-END:variables

    public JPanel getjPanelMenuOnline() {
        return jPanelMenuOnline;
    }

    private void setEditable(boolean b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JTextField getjTextFieldDireccionIP() {
        return jTextFieldDireccionIP;
    }

    public JTextField getjTextFieldNamePlayer() {
        return jTextFieldNamePlayer;
    }

    public JTextField getjTextFieldSocket() {
        return jTextFieldSocket;
    }


}
