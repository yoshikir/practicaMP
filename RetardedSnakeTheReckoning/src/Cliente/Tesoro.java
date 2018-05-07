/*
 * Genera un tesoro en las coordenadas aleatorias teniendo en cuenta que no exista una serpiente
 * encima suya
 */
package Cliente;

import Servidor.Serpiente.*;
import Cliente.MovimientoSnake;
import GUI.Arena;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Yoshiki
 */
public class Tesoro{

    private int x;
    private int y;
    private boolean activo = false;

    public Tesoro(int x, int y, Arena arena) {
        this.x = x;
        this.y = y;
        arena.getPosition(x, y).setBackground(Color.GREEN);
        activo = true;
    }

    /* TODO Esto debe estar a nivel de servidor
    public void run() {
        while (activo) {
            System.out.print("");
            if (snake.getCabeza().getX() == x && snake.getCabeza().getY() == y) {
                System.out.print("+1");
                activo = false;
                try {
                    activo = false;
                    //Thread.sleep(1000 / 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    public boolean tesoroCazado() {
        if (activo) {
            return false;
        } else {
            return true;
        }
    }

}
