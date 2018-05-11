/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Servidor.Sesion.Serpiente.Serpiente;
import java.awt.Color;

/**
 *
 * @author Yoshiki
 */
public class MovimientoSnakeServer{

    private final String ARRIBA = "ARRIBA";
    private final String ABAJO = "ABAJO";
    private final String IZQ = "IZQ";
    private final String DER = "DER";
    
    private Serpiente[] snakes;
    private String peticionMov;
    private String respuesta;
    private int direccion;
    private int idJugador;
    
    
    public MovimientoSnakeServer(Serpiente[] snakes){
        this.snakes = snakes;
    }

    public String traducir(String peticion) {

                switch (peticionMov) {
                        case ARRIBA:
                            respuesta = "MOV;" + idJugador + ";" + (snakes[idJugador-1].getCabeza().getX() - 1) +
                                    ";" + snakes[idJugador-1].getCabeza().getY() + ";" + snakes[idJugador-1].getCola().getX() +
                                    ";" + snakes[idJugador-1].getCola().getY();
                            return respuesta;
                        case DER:
                            respuesta = "MOV;" + idJugador + ";" + snakes[idJugador-1].getCabeza().getX() +
                                    ";" + (snakes[idJugador-1].getCabeza().getY() + 1) + ";" + snakes[idJugador-1].getCola().getX() +
                                    ";" + snakes[idJugador-1].getCola().getY();
                            return respuesta;
                        case ABAJO:
                            respuesta = "MOV;" + idJugador + ";" + (snakes[idJugador-1].getCabeza().getX() + 1) +
                                    ";" + snakes[idJugador-1].getCabeza().getY() + ";" + snakes[idJugador-1].getCola().getX() +
                                    ";" + snakes[idJugador-1].getCola().getY();
                            return respuesta;
                        case IZQ:
                            respuesta = "MOV;" + idJugador + ";" + snakes[idJugador-1].getCabeza().getX() +";" + (snakes[idJugador-1].getCabeza().getY() - 1) + ";" + snakes[idJugador-1].getCola().getX() +";" + snakes[idJugador-1].getCola().getY();
                            return respuesta;
                        default:
                            return "Bad gateaway";
               }

     
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setSnakes(int id,Serpiente snakes) {
        this.snakes[id] = snakes;
    }

    public void setPeticionMov(String peticionMov) {
        this.peticionMov = peticionMov;
    }
}

