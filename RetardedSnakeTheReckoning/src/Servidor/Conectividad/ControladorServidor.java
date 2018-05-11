/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import Servidor.Conectividad.ObservadorServer;
import Servidor.Conectividad.Servidor;
import Servidor.Sesion.DatosSesion;
import Servidor.Sesion.MovimientoSnakeServer;

/**
 *
 * @author Yoshiki
 */
public class ControladorServidor extends Thread{

    private final String MOVIMIENTO = "DIR";
    private final String FINALIZAR = "FIN";

    private DatosSesion sesion;
    private MovimientoSnakeServer snake;
    private ObservadorServer observador;
    private int direccion = 1;
    private int idCliente;

    public ControladorServidor(DatosSesion sesion, MovimientoSnakeServer snake) {
        this.sesion = sesion;
        this.snake = snake;
        observador = sesion.getObs();
    }

    public void run() {
        while (true) {
            String[] peticion = observador.getPeticion().split(";");
            switch (peticion[0]) {
                case MOVIMIENTO:
                    switch (peticion[1]) {
                        case "ARRIBA":
                            snake.setIdJugador(idCliente);
                            snake.traducir(peticion.toString());
                            break;
                        case "DER":
                            snake.setDireccion(2);
                            snake.setIdJugador(idCliente);
                            break;
                        case "ABAJO":
                            snake.setDireccion(3);
                            snake.setIdJugador(idCliente);
                            break;
                        case "IZQ ":
                            snake.setDireccion(4);
                            snake.setIdJugador(idCliente);
                            break;
                    }
                case FINALIZAR:
                    break;
            }
        }
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
