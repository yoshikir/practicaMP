/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Yoshiki
 */
public class MovimientoSnake extends Thread {

    private int posX;
    private int posY;
    
    private JPanel[][] arena;
    
    public MovimientoSnake(JPanel[][] arena,int posX,int posY) {
        this.arena = arena;
        this.posX = posX;
        this.posY = posY;
    }
    
    public void run(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            posY += 1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            posY -= 1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            posX += 1;
        }
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            posX -= 1;
        }
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
