/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Yoshiki
 */
public class Snake extends Thread {

    private int posX;
    private int posY;
    private int direccion;
    
    private JPanel[][] arena;
    
    public Snake(JPanel[][] arena,int posX,int posY) {
        this.arena = arena;
        this.posX = posX;
        this.posY = posY;
    }
    
    public void run() {
        while(true){
            if (direccion == 1) {
                   arena[posX][posY].setBackground(Color.white);
                   posY-=1;
                   arena[posX][posY].setBackground(Color.red);
               } else if (direccion == 2) {
                   arena[posX][posY].setBackground(Color.white);
                   posX+=1;
                   arena[posX][posY].setBackground(Color.red);
               } else if (direccion == 3) {
                   arena[posX][posY].setBackground(Color.white);
                   posY+=1;
                   arena[posX][posY].setBackground(Color.red);
               } else if (direccion == 4) {
                   arena[posX][posY].setBackground(Color.white);
                   posX-=1;
                   arena[posX][posY].setBackground(Color.red);
               }
        }
    }
    

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }
    public void setDireccion( int direccion){
        this.direccion = direccion;
    }

    

    
}
