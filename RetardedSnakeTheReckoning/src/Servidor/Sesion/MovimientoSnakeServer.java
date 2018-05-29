/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion;

import Servidor.Modelo.TesoroServer;
import Servidor.Sesion.Serpiente.CachoSerpiente;
import Servidor.Sesion.Serpiente.Serpiente;

import java.awt.Color;

/**
 * @author Yoshiki
 */
public class MovimientoSnakeServer {

    private final String ARRIBA = "ARRIBA";
    private final String ABAJO = "ABAJO";
    private final String IZQ = "IZQ";
    private final String DER = "DER";

    private Serpiente[] snakes;
    private String peticionMov;
    private String respuesta;
    private int direccion;
    private int idJugador;
    private TesoroServer tesoroServer;
    private boolean coincidido = false;


    public MovimientoSnakeServer(Serpiente[] snakes) {
        this.snakes = snakes;
    }

    public String traducirMovimiento(String peticion) {
        idJugador = 1; //TODO ASIGNAR DISTINTO
        if (snakes[idJugador - 1].getCabeza().getX() > 60 || snakes[idJugador - 1].getCabeza().getX() < 0 ||
                snakes[idJugador - 1].getCabeza().getY() > 60 || snakes[idJugador - 1].getCabeza().getY() < 0) {
            respuesta = "FIN;" + idJugador;
            return respuesta;
        } else {
            CachoSerpiente cacho;
            switch (peticion) {
                case ARRIBA:
                    respuesta = "MOV;" + idJugador + ";" + (snakes[idJugador - 1].getCabeza().getX() - 1) +
                            ";" + snakes[idJugador - 1].getCabeza().getY() + ";" + snakes[idJugador - 1].getCola().getX() +
                            ";" + snakes[idJugador - 1].getCola().getY();
                    cacho = new CachoSerpiente(snakes[idJugador - 1].getCabeza().getX() - 1,snakes[idJugador - 1].getCabeza().getY());
                    if(coincidido){
                        snakes[idJugador - 1].getCachosSerpiente().peek();
                        snakes[idJugador - 1].addCacho(cacho);
                        coincidido = false;
                    }else {
                        snakes[idJugador -1].getCachosSerpiente().poll();
                        snakes[idJugador - 1].addCacho(cacho);
                    }
                    return respuesta;
                case DER:
                    respuesta = "MOV;" + idJugador + ";" + snakes[idJugador - 1].getCabeza().getX() +
                            ";" + (snakes[idJugador - 1].getCabeza().getY() + 1) + ";" + snakes[idJugador - 1].getCola().getX() +
                            ";" + snakes[idJugador - 1].getCola().getY();
                    cacho = new CachoSerpiente(snakes[idJugador - 1].getCabeza().getX(),snakes[idJugador - 1].getCabeza().getY() + 1);
                    if(coincidido){
                        snakes[idJugador - 1].getCachosSerpiente().peek();
                        snakes[idJugador - 1].addCacho(cacho);
                        coincidido = false;
                    }else {
                        snakes[idJugador -1].getCachosSerpiente().poll();
                        snakes[idJugador - 1].addCacho(cacho);
                    }
                    return respuesta;
                case ABAJO:
                    respuesta = "MOV;" + idJugador + ";" + (snakes[idJugador - 1].getCabeza().getX() + 1) +
                            ";" + snakes[idJugador - 1].getCabeza().getY() + ";" + snakes[idJugador - 1].getCola().getX() +
                            ";" + snakes[idJugador - 1].getCola().getY();
                    cacho = new CachoSerpiente(snakes[idJugador - 1].getCabeza().getX() + 1,snakes[idJugador - 1].getCabeza().getY());
                    if(coincidido){
                        snakes[idJugador - 1].getCachosSerpiente().peek();
                        snakes[idJugador - 1].addCacho(cacho);
                        coincidido = false;

                    }else {
                        snakes[idJugador -1].getCachosSerpiente().poll();
                        snakes[idJugador - 1].addCacho(cacho);
                    }
                    return respuesta;
                case IZQ:
                    respuesta = "MOV;" + idJugador + ";" + snakes[idJugador - 1].getCabeza().getX() + ";" +
                            (snakes[idJugador - 1].getCabeza().getY() - 1) + ";" + snakes[idJugador - 1].getCola().getX()
                            + ";" + snakes[idJugador - 1].getCola().getY();
                    cacho = new CachoSerpiente(snakes[idJugador - 1].getCabeza().getX(),snakes[idJugador - 1].getCabeza().getY() - 1);
                    if(coincidido){
                        snakes[idJugador - 1].getCachosSerpiente().peek();
                        snakes[idJugador - 1].addCacho(cacho);
                        coincidido = false;
                    }else {
                        snakes[idJugador -1].getCachosSerpiente().poll();
                        snakes[idJugador - 1].addCacho(cacho);
                    }
                    return respuesta;
                default:
                    return "Bad gateaway";
            }
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

    public void setSnakes(int id, Serpiente snakes) {
        this.snakes[id] = snakes;
    }

    public void setPeticionMov(String peticionMov) {
        this.peticionMov = peticionMov;
    }

    public void tesoroCapturado() {

    }

    public void setTesoroServer(TesoroServer tesoroServer) {
        this.tesoroServer = tesoroServer;
    }

    public void setCoincidido(boolean coincidido) {
        this.coincidido = coincidido;
    }
}

