/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Servidor.Conectividad.ObservadorServer;
import java.util.Observable;

/**
 *
 * @author Yoshiki
 */
public class PuntuacionServer extends Observable{
    
    private int puntos;

    public PuntuacionServer(ObservadorServer obs) {
        this.puntos = 0;
        addObserver(obs);
    }

    public PuntuacionServer(int puntos, int tesorosAdquiridos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
        notifyObservers(this);
    }
}
