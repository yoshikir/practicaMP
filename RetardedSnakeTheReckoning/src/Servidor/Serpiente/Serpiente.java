/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Serpiente;

import GUI.Arena;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Observable;

/**
 *
 * @author st.fila.2016
 */
public class Serpiente extends Observable {

    private LinkedList<CachoSerpiente> serpiente;
    private Arena arena;

    public Serpiente(LinkedList<CachoSerpiente> serpiente, Arena arena) {
        this.serpiente = serpiente;
        this.arena = arena;
    }
    //guardamos la posicion de el ultimo elemento y avanza en la direccion asocidada
    //y despues eliminas el primer elemento de la lista
    public void move() {
        int x, y;
        x = serpiente.getLast().getX();
        y = serpiente.getLast().getY();
        switch (arena.getDireccion()) {
            case 1:
                //y-
                serpiente.add(new CachoSerpiente(x, y - 1));
                serpiente.poll();//saca el primer elemento de la lista y lo elimina
                break;
            case 2:
                //x+
                serpiente.add(new CachoSerpiente(x + 1, y));
                serpiente.poll();
                break;
            case 3:
                //y+
                serpiente.add(new CachoSerpiente(x, y + 1));
                serpiente.poll();
                break;
            case 4:
                //x-
                serpiente.add(new CachoSerpiente(x - 1, y));
                serpiente.poll();
                break;
            default:
                break;
        }
        notifyObservers(this);
    }
    
    //Añade un cuadrado más a la serpiente
    public void addCacho(CachoSerpiente cacho) {
        serpiente.add(cacho);
    }

    public CachoSerpiente getCabeza() {
        return this.serpiente.getFirst();
    }

    public CachoSerpiente getCola() {
        return this.serpiente.getLast();
    }
}
