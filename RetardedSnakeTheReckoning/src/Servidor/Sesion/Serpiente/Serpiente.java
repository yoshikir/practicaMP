/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion.Serpiente;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;

/**
 *
 * @author st.fila.2016
 */
public class Serpiente extends Observable {

    private LinkedList<CachoSerpiente> cachosSerpiente;
    private boolean comido=false;

    public Serpiente(CachoSerpiente cs){
        cachosSerpiente = new LinkedList<>();
        addCacho(cs);
    }
    
    public Serpiente(LinkedList<CachoSerpiente> serpiente) {
        this.cachosSerpiente = serpiente;        
    }
    //guardamos la posicion de el ultimo elemento y avanza en la direccion asocidada
    //y despues eliminas el primer elemento de la lista
    /*public void move() {
        int x, y;
        x = cachosSerpiente.getLast().getX();
        y = cachosSerpiente.getLast().getY();
        switch (arena.getDireccion()) { //Esto no se controla en Servidor
            case 1:
                //y-
                cachosSerpiente.add(new CachoSerpiente(x, y - 1));
                cachosSerpiente.poll();//saca el primer elemento de la lista y lo elimina
                break;
            case 2:
                //x+
                cachosSerpiente.add(new CachoSerpiente(x + 1, y));
                cachosSerpiente.poll();
                break;
            case 3:
                //y+
                cachosSerpiente.add(new CachoSerpiente(x, y + 1));
                cachosSerpiente.poll();
                break;
            case 4:
                //x-
                cachosSerpiente.add(new CachoSerpiente(x - 1, y));
                cachosSerpiente.poll();
                break;
            default:
                break;
        }
        notifyObservers(this);
    }*/
    
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
    public boolean coincide(int x,int y){
        
        
        ListIterator<CachoSerpiente> recorre= cachosSerpiente.listIterator(0);
        if(x==getCabeza().getX() && y==getCabeza().getY())
            return true;
            
        while(true){
            if(!recorre.hasNext())
                return false;
            else{
                CachoSerpiente next=recorre.next();
                if(x==next.getX()&& y==next.getY())
                    return true;   
            }   
        }
    }
    
    public void comido(){
    comido=true;
    
    }

   
}
