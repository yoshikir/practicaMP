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

import java.io.*;
import java.net.Socket;

/**
 * @author Yoshiki
 */
public class ControladorServidor extends Thread {

    private final String MOVIMIENTO = "DIR";
    private final String FINALIZAR = "FIN";

    private DatosSesion sesion;
    private MovimientoSnakeServer snake;
    private ObservadorServer observador;
    private int direccion = 1;
    private int idCliente;
    private String request;

    public ControladorServidor(DatosSesion sesion, MovimientoSnakeServer snake) {
        this.sesion = sesion;
        this.snake = snake;
        observador = sesion.getObs();
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(sesion.getSocket().getInputStream()));
                PrintWriter out = new PrintWriter(sesion.getSocket().getOutputStream(), true);

                out.println("conectado");
                //Lee del cliente
                String mensajeCliente;
                while ((mensajeCliente = in.readLine()) != null) {
                    System.out.println("Cliente > " + mensajeCliente);
                    break;

                }

                //contesta al cliente
                out.println(traducirPeticion(mensajeCliente));
                //traducirPeticion(mensajeCliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String traducirPeticion(String peticion) {
        //TODO Esta cosa
        String[] cadenas = peticion.split(";");
        switch (cadenas[0]) {
            case MOVIMIENTO:
                switch (cadenas[1]) {
                    case "ARRIBA":
                        snake.setIdJugador(idCliente);
                        return snake.traducir(cadenas[1]);
                    case "DER":
                        snake.setIdJugador(idCliente);
                        return snake.traducir(cadenas[1]);
                    case "ABAJO":
                        snake.setIdJugador(idCliente);
                        return snake.traducir(cadenas[1]);
                    case "IZQ ":
                        snake.setIdJugador(idCliente);
                        return snake.traducir(cadenas[1]);
                }
            case FINALIZAR:
                return "FIN;1";
            default:
                return "FIN;1";
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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
