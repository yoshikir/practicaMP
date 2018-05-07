/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Servidor.Sesion.Serpiente.Serpiente;
import java.awt.Color;

/**
 *
 * @author Yoshiki
 */
public class MovimientoSnakeServer extends Thread{

    private Serpiente[] snakes;
    
    public MovimientoSnakeServer(Serpiente[] snakes){
        this.snakes = snakes;
    }
    
    /*@Override
    public void run() {
        while(true){
            try{
                switch (arena.getDireccion()) {
                        case 1:
                            snakes[0].getPosition(posX, posY).setBackground(Color.white);
                            posX -= 1;
                            arena.getPosition(posX, posY).setBackground(Color.red);
                            break;
                        case 2:
                            arena.getPosition(posX, posY).setBackground(Color.white);
                            posY += 1;
                            arena.getPosition(posX, posY).setBackground(Color.red);
                            break;
                        case 3:
                            arena.getPosition(posX, posY).setBackground(Color.white);
                            posX += 1;
                            arena.getPosition(posX, posY).setBackground(Color.red);
                            break;
                        case 4:
                            arena.getPosition(posX, posY).setBackground(Color.white);
                            posY -= 1;
                            arena.getPosition(posX, posY).setBackground(Color.red);
                            break;
                        default:
                            break;
                    }
                    Thread.sleep(1000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
    }
    }*/
}
