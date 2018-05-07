package GUI;

import Cliente.MovimientoSnake;
import Servidor.Serpiente.Tesoro;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Yoshiki
 */
public class Arena extends javax.swing.JFrame implements KeyListener, Observer {

    private static final int COLUMNAS = 60;
    private static final int FILAS = 60;
    private static final int SERPIENTE_X_INIC = 30;
    private static final int SERPIENTE_Y_INIC = 30;
    private int direccion;

    private JPanel[][] matriz = new JPanel[COLUMNAS][FILAS];

    /**
     * Creates new form FramePrincipal
     */

    public Arena() {
        initComponents();

        GridLayout gl = new GridLayout(COLUMNAS, FILAS);
        this.jPanel1.setLayout(gl);
        Dimension dim = new Dimension(15, 15);

        for (int i = 0; i < gl.getColumns(); i++) {
            for (int j = 0; j < gl.getRows(); j++) {

                JPanel panelChupi = new JPanel();
                panelChupi.setBackground(Color.WHITE);

                panelChupi.setSize(10, 10);

                panelChupi.setPreferredSize(dim);
                panelChupi.setMinimumSize(dim);

                matriz[i][j] = panelChupi;
                panelChupi.setVisible(true);

                jPanel1.add("panel" + i + "/" + j, panelChupi);
            }
        }

        addKeyListener(this);
        direccion = 1;

        //Seleccionar posicion inicial de la serpiente
        matriz[SERPIENTE_X_INIC][SERPIENTE_Y_INIC].setBackground(Color.red);
        MovimientoSnake ms = new MovimientoSnake(this, SERPIENTE_X_INIC, SERPIENTE_Y_INIC,false); //Para emplear el sistema de movimiento por mensajes, hacerlo true
        ms.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                direccion = 1;
                break;
            case KeyEvent.VK_RIGHT:
                direccion = 2;
                break;
            case KeyEvent.VK_DOWN:
                direccion = 3;
                break;
            case KeyEvent.VK_LEFT:
                direccion = 4;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getDireccion() {
        return direccion;
    }

    public JPanel getPosition(int i, int j) throws ArrayIndexOutOfBoundsException {
        return matriz[i][j];
    }

    public int getColumnas() {
        return COLUMNAS;
    }

    public int getFilas() {
        return FILAS;
    }

    @Override
    public void update(Observable o, Object o1) {

    }
}
