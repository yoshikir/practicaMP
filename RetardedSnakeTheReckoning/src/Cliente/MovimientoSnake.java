/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import GUI.Arena;
import java.awt.Color;

/**
 *
 * @author Sebas104
 */
public class MovimientoSnake extends Thread {

    private int posX;
    private int posY;
    private int velocidad = 10;
    private Arena arena;
    
    public MovimientoSnake(Arena arena,int posX,int posY) {
        this.arena = arena;
        this.posX = posX;
        this.posY = posY;
    }
    
    
    /*Controla la dirección en la que se cambian los tiles de color. La posición X e Y están
    intercambiadas para corresponder con las posiciones relativas en la matriz de posición.*/
    @Override
    public void run() {
        while(true){
            switch (arena.getDireccion()) {
                case 1:
                    arena.getPosition(posX, posY).setBackground(Color.white);
                    posX-=1;
                    arena.getPosition(posX, posY).setBackground(Color.red);
                    
                    break;
                case 2:
                    arena.getPosition(posX, posY).setBackground(Color.white);
                    posY+=1;
                    arena.getPosition(posX, posY).setBackground(Color.red);
                    break;
                case 3:
                    arena.getPosition(posX, posY).setBackground(Color.white);
                    posX+=1;
                    arena.getPosition(posX, posY).setBackground(Color.red);
                    break;
                case 4:
                    arena.getPosition(posX, posY).setBackground(Color.white);
                    posY-=1;
                    arena.getPosition(posX, posY).setBackground(Color.red);
                    break;
                default:
                    break;
            }
            
            try {
               Thread.sleep(1000 / velocidad);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
    

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
