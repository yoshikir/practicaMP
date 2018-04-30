/*
 Esta clase se encarga del movimineto de la serpiente
 */
package Cliente;

import GUI.Arena;
import GUI.HasPerdido;
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
            try {
                switch (arena.getDireccion()) {
                    case 1:
                        arena.getPosition(posX, posY).setBackground(Color.white);
                        posX-=1;
                        System.out.println("PosX"+posX);
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
            
      
               Thread.sleep(1000 / velocidad);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ArrayIndexOutOfBoundsException e){
               System.out.println("Has Perdido");
               HasPerdido dialog = new HasPerdido(arena,true);
               dialog.setVisible(true);
           }
        }
    }
    

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
