/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;

import Cliente.MovimientoSnake;
import Cliente.Tesoro;
import GUI.Arena;
import GUI.Puntuacion;

/**
 * Esta clase es el controlador del cliente que se encarga de la modificaciones de todas
 * las variables necesarias, envía el próximo movimiento de cada uno de los jugadores presentes, 
 * inicia las posiciones de los tesoros, avisa de errores, etc
 * 
 * @author Yoshiki
 */
public class ControladorCliente extends Thread {

    private final String ID_CLIENTE = "IDC";
    private final String MOVIMIENTO = "MOV";
    private final String PUNTUACION = "PTS";
    private final String ERROR = "ERR";
    private final String TESORO = "TES";

    private Arena arena;
    private MovimientoSnake snake;
    private Conexion con;
    private Puntuacion punt;
    private int idCliente;

    public ControladorCliente(Arena arena, MovimientoSnake snake, Puntuacion punt, Conexion con) {
        this.arena = arena;
        this.snake = snake;
        this.con = con;
        this.punt = punt;
    }

    //detecta las distintas cabeceras recibidas por el cliente desde el servidor
    //y las redirige a sus respectivas vistas o actualiza los datos del cliente
    public void run() {
        while (true) {
            String[] mensaje = con.getMensajeServidor().split(";");
            switch (mensaje[0]) {
                //Traza por defecto: IDC;numId
                case ID_CLIENTE:
                    idCliente = Integer.parseInt(mensaje[1]);
                    break;
                case MOVIMIENTO:
                    if (Integer.parseInt(mensaje[1]) == idCliente) {
                        snake.setPosX(Integer.parseInt(mensaje[2]));
                        snake.setPosY(Integer.parseInt(mensaje[3]));
                        snake.setBorrarX(Integer.parseInt(mensaje[4]));
                        snake.setBorrarY(Integer.parseInt(mensaje[5]));
                    }
                    break;
                case PUNTUACION:
                    switch (mensaje[1]) {
                        case "1":
                            punt.setJugador1Puntuacion(mensaje[2]);
                            break;
                        case "2":
                            punt.setJugador2Puntuacion(mensaje[2]);
                            break;
                        case "3":
                            punt.setJugador3Puntuacion(mensaje[2]);
                            break;
                        case "4":
                            punt.setJugador4Puntuacion(mensaje[2]);
                            break;
                    }
                    break;
                case ERROR:
                    break;
                case TESORO:
                    Tesoro tes = new Tesoro(Integer.parseInt(mensaje[1]),Integer.parseInt(mensaje[2]),arena);
                    break;
            }
        }
    }

}
