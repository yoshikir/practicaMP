/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import Servidor.Modelo.TesoroServer;
import Servidor.Sesion.DatosSesion;
import Servidor.Sesion.MovimientoSnakeServer;

import java.io.*;
import java.net.SocketException;

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
            TesoroServer tes = new TesoroServer(sesion.getSnake());
            snake.setTesoroServer(tes);
            String mensajeCliente = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(sesion.getSocket().getInputStream()));
            PrintWriter out = new PrintWriter(sesion.getSocket().getOutputStream(), true);
            out.println("TES;" + tes.getX() + ";" + tes.getY() + ";");
            out.println("PNT;1;0");

            while (true) {
                //Lee del cliente

                while ((mensajeCliente = in.readLine()) != null) {
                    System.out.println("Cliente > " + mensajeCliente);
                    break;
                }
                String traduccion = traducirPeticion(mensajeCliente);
                String[] t = traduccion.split(";");
                if (t[0] == "FIN") {
                    sesion.getSocket().close();
                    this.interrupt();
                    return;
                } else {
                    out.println(traduccion);
                    out.flush();
                }

                if (sesion.getSnake().coincide(tes.getX(), tes.getY())) {
                    sesion.getPunt().setPuntos(sesion.getPunt().getPuntos() + 100);
                    out.println("PNT;" + sesion.getIdCliente() + ";" + sesion.getPunt().getPuntos() + ";");
                    tes = new TesoroServer(sesion.getSnake());
                    snake.setTesoroServer(tes);
                    out.println("TES;" + tes.getX() + ";" + tes.getY() + ";");
                }

                //contesta al cliente

                //traducirPeticion(mensajeCliente);

                Thread.sleep(100);
            }
        }catch (SocketException e){
                System.out.println("Cliente "+sesion.getIdCliente()+" desconectado.");
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
                return snake.traducirMovimiento(cadenas[1]);
            case FINALIZAR:
                return "";
            default:
                return "";
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
