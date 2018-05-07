/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Modelo;

import Servidor.Serpiente.Serpiente;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Esta clase corresponde con la implementación del patrón modelo en la parte
 * del servidor Contiene el estado actual de todos los objetos que manejará el
 * controlador, como el tamaño de la arena o la posición de todos los jugadores.
 *
 * @author Yoshiki
 */
public class DatosDeSesion implements Observer {

    private int arenaColumnas;
    private int arenaFilas;
    private Serpiente[] serpiente;

    public DatosDeSesion(int arenaColumnas, int arenaFilas) {
        this.arenaColumnas = arenaColumnas;
        this.arenaFilas = arenaFilas;
    }

    public void setArenaSize(int x, int y) {
        arenaColumnas = x;
        arenaFilas = y;
    }

    public int getArenaColumnas() {
        return arenaColumnas;
    }

    public int getArenaFilas() {
        return arenaFilas;
    }

    @Override
    public void update(Observable o, Object o1) {
        
    }
}
