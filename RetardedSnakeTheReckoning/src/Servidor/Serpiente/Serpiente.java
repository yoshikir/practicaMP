/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Serpiente;

import java.util.LinkedList;

/**
 *
 * @author st.fila.2016
 */
public class Serpiente {
    private LinkedList<CachoSerpiente> serpiente;
    
    public Serpiente(LinkedList<CachoSerpiente> serpiente){
        this.serpiente = serpiente;
    
    
    }
    public void addCacho(CachoSerpiente cacho){
        serpiente.add(cacho);
    }
    //TODO: Añadir dos metodos que devuelvan la cabeza y el final de la serpiente
    
}
