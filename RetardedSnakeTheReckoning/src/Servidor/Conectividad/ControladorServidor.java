/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import Servidor.Conectividad.ObservadorServer;
import Servidor.Conectividad.Servidor;
import Servidor.Sesion.MovimientoSnakeServer;

/**
 *
 * @author Yoshiki
 */
public class ControladorServidor extends Thread {

    private final String MOVIMIENTO = "DIR";
    private final String FINALIZAR = "FIN";

    private boolean escuchando;
    private MovimientoSnakeServer snake;
    private Servidor server;
    private ObservadorServer observador;
    private int direccion = 1;

    public ControladorServidor(Servidor server, MovimientoSnakeServer snake) {
        this.server = server;
        this.snake = snake;
        observador = server.getObservador();
    }

    public void run() {
        while (escuchando) {
            String[] peticion = observador.getPeticion().split(";");
            switch (peticion[0]) {
                case MOVIMIENTO:
                    switch (peticion[1]) {
                        case "ARRIBA":
                            setDireccion(1);
                            break;
                        case "DER":
                            setDireccion(2);
                            break;
                        case "ABAJO":
                            setDireccion(3);
                            break;
                        case "IZQ ":
                            setDireccion(4);
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

}
