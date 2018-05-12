/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Cliente.GUI.Puntuacion;
import Servidor.Conectividad.ControladorServidor;
import Servidor.Conectividad.ObservadorServer;
import Servidor.Sesion.Serpiente.CachoSerpiente;
import Servidor.Sesion.Serpiente.Serpiente;

import java.net.Socket;
import java.util.Observable;

/**
 * Esta clase corresponde con la implementación del patrón modelo en la parte
 * del servidor Contiene el estado actual de todos los objetos que manejará el
 * controlador, como el tamaño de la arena o la posición de todos los jugadores.
 *
 * @author Yoshiki
 */
public class DatosSesion extends Observable{

    private int idCliente;
    private PuntuacionServer punt;
    private Serpiente snake;
    private ObservadorServer obs;
    private ControladorServidor cs;
    private MovimientoSnakeServer mss;
    private Socket socket;
    
    
    public DatosSesion (Socket socket, MovimientoSnakeServer mss){
        obs = new ObservadorServer();
        this.snake = new Serpiente(new CachoSerpiente(30,30));
        this.punt = new PuntuacionServer(obs);
        this.socket = socket;
        cs = new ControladorServidor(this,mss);
    }

    public ObservadorServer getObs() {
        return obs;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public PuntuacionServer getPunt() {
        return punt;
    }

    public Serpiente getSnake() {
        return snake;
    }

    public ControladorServidor getCs() {
        return cs;
    }

    public Socket getSocket() {
        return socket;
    }
}