/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion.Serpiente;


import java.util.*;

/**
 * @author st.fila.2016
 */
public class Serpiente extends Observable {

    private LinkedList<CachoSerpiente> cachosSerpiente;
    private boolean comido = false;

    public Serpiente(CachoSerpiente cs) {
        cachosSerpiente = new LinkedList<>();
        addCacho(cs);
    }

    public Serpiente(LinkedList<CachoSerpiente> serpiente) {
        this.cachosSerpiente = serpiente;
    }

    //Añade un cuadrado más a la serpiente
    public void addCacho(CachoSerpiente cacho) {
        cachosSerpiente.add(cacho);
    }

    public CachoSerpiente getCabeza() {
        return this.cachosSerpiente.getFirst();
    }

    public CachoSerpiente getCola() {
        return this.cachosSerpiente.getLast();
    }

    public boolean coincide(int x, int y) {


        ListIterator<CachoSerpiente> recorre = cachosSerpiente.listIterator(0);
        if (x == getCabeza().getX() && y == getCabeza().getY())
            return true;

        while (true) {
            if (!recorre.hasNext())
                return false;
            else {
                CachoSerpiente next = recorre.next();
                if (x == next.getX() && y == next.getY())
                    return true;
            }
        }
    }

    public void actualizarPosicion(){
        CachoSerpiente cabeza = getCabeza();
        CachoSerpiente previous = null;
        CachoSerpiente actual = getCabeza();
        CachoSerpiente next = null;


        Iterator<CachoSerpiente> it = cachosSerpiente.iterator();
        LinkedList<CachoSerpiente> nuevaLista;
        while (it.hasNext()){

        }

    }

    public void setComido(boolean comido) {
        this.comido = comido;
    }


}
