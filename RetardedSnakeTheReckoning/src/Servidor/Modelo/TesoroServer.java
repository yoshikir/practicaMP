/*
 * Genera un tesoro en las coordenadas aleatorias teniendo en cuenta que no exista una serpiente
 * encima suya
 */
package Servidor.Modelo;

import Servidor.Sesion.Serpiente.Serpiente;

import java.util.Observable;
import java.util.Random;

/**
 * @author Yoshiki
 */
public class TesoroServer extends Observable {

    private static final int altura = 60;
    private static final int anchura = 60;


    private int x;
    private int y;
    private Serpiente snake;
    private String mensaje;
    private boolean capturado;
    private boolean generado = false;

    public TesoroServer(Serpiente snake){
        Random rand = new Random();
        do {
            x = rand.nextInt(anchura);
            y = rand.nextInt(altura);
        } while (snake.coincide(x, y));
        this.mensaje = "TES;" + x + ";" + y;
    }

    public void run(){
        while (!capturado){
            if(snake.coincide(this.x,this.y)){
                capturado = true;
            }
        }
        new TesoroServer(snake);
    }


    public void capturaTesoro() {
        capturado = false;

    }

    public boolean isCapturado() {
        return capturado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
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
    
    
    /*public void run(){
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
                }
            }
        }
    }*/
    
    /*public boolean tesoroCazado(){
        if(){
            return false;
        }else{
            return true;
        }
    }*/


}
