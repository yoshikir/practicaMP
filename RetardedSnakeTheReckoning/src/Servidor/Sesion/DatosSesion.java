/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Cliente.GUI.Puntuacion;
import Servidor.Conectividad.ObservadorServer;
import Servidor.Sesion.Serpiente.Serpiente;
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
   
    public DatosSesion (int idCliente){
        obs = new ObservadorServer();
        this.idCliente = idCliente;
        this.snake = new Serpiente();
        this.punt = new PuntuacionServer(obs);
    }
    
    public DatosSesion(int idCliente, Serpiente snake) {
        this.idCliente = idCliente;
        this.snake = snake;
    }
    
}
