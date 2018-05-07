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

    private final Color P1 = Color.RED;
    private final Color P2 = Color.BLUE;
    private final Color P3 = Color.GREEN;
    private final Color P4 = Color.MAGENTA;
    
    
    private int posX;
    private int posY;
    private int borrarX;
    private int borrarY;
    private int jugador = 1;
    private boolean online;

    private int velocidad = 10;
    private Arena arena;

    public MovimientoSnake(Arena arena, int posX, int posY, boolean online) {
        this.arena = arena;
        this.posX = posX;
        this.posY = posY;
        this.online = online;
    }

    /*Controla la dirección en la que se cambian los tiles de color. La posición X e Y están
    intercambiadas para corresponder con las posiciones relativas en la matriz de posición.*/
    @Override
    public void run() {
        try {
            while (true) {
                
                //La vista variará dependiendo si la aplicación es online y offline
                // TODO Hay que comprobar si esto rompe el modelo Vista Controlador 
                if (online) {
                    arena.getPosition(borrarX, borrarY).setBackground(Color.white);
                    if(jugador == 1){
                        arena.getPosition(posX, posY).setBackground(P1);
                    }else if(jugador == 2){
                        arena.getPosition(posX, posY).setBackground(P2);
                    }else if(jugador == 3){
                        arena.getPosition(posX, posY).setBackground(P3);
                    }else if(jugador == 4){
                        arena.getPosition(posX, posY).setBackground(P4);
                    }
                        
                         //controlar el color dependiendo del idCliente
                    
                    
                } else {
                    /*
                    Este switch en realidad estaría en el controlador del servidor. Habría que controlar dependiendo si es local u online
                     */
                    switch (arena.getDireccion()) {
                        case 1:
                            arena.getPosition(borrarX, borrarY).setBackground(Color.white);
                            arena.getPosition(posX, posY).setBackground(Color.white);
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
                }
                Thread.sleep(1000 / velocidad);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            arena.dispose();
            System.out.println("Has Perdido");
            HasPerdido dialog = new HasPerdido();
            dialog.setVisible(true);
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setBorrarX(int borrarX) {
        this.borrarX = borrarX;
    }

    public void setBorrarY(int borrarY) {
        this.borrarY = borrarY;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }
    
    

}
