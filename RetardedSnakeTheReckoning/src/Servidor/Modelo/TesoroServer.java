/*
 * Genera un tesoro en las coordenadas aleatorias teniendo en cuenta que no exista una serpiente
 * encima suya
 */
package Servidor.Modelo;

import Servidor.Sesion.Serpiente.Serpiente;

/**
 *
 * @author Yoshiki
 */
public class TesoroServer extends Thread{
    
    private int x;
    private int y;
    private Serpiente snake;
    private boolean activo = false;
    
    /*public Tesoro(Serpiente snake){
        this.snake = snake;
        Random rand = new Random(System.nanoTime());
        while(!activo){
            x = rand.nextInt(arena.getColumnas());
            y = rand.nextInt(arena.getFilas());
            if(arena.getPosition(x, y).getBackground() != Color.RED){
                arena.getPosition(x, y).setBackground(Color.GREEN);
                activo = true;
            }
        }
    }*/
    
    
    public void run(){
        while(activo){
            System.out.print("");
            if(snake.getCabeza().getX()== x && snake.getCabeza().getY()== y){
                System.out.print("+1");
                activo=false;
                /*try {
                    activo = false;
                    //Thread.sleep(1000 / 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
    
    public boolean tesoroCazado(){
        if(activo){
            return false;
        }else{
            return true;
        }
    }
    
    
    
}
