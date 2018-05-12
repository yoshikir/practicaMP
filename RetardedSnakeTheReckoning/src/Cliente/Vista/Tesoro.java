/*
 * Genera un tesoro en las coordenadas aleatorias teniendo en cuenta que no exista una serpiente
 * encima suya
 */
package Cliente.Vista;


import Cliente.Vista.GUI.Arena;
import java.awt.Color;

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
        arena.getPosition(x,y).setBackground(Color.yellow);
        activo = true;
    }


    public boolean tesoroCazado() {
        if (activo) {
            return false;
        } else {
            return true;
        }
    }

}
