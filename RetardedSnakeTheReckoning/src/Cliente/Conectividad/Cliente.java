/*Player es el objeto jugador al cual se le mandan todos los datos*/
package Cliente.Conectividad;

import Servidor.Modelo.TesoroServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.stream.Stream;

public class Cliente extends Thread {

    private static final String CONEXION = "CNCT";
    private static final String MOVIMIENTO = "MOV";
    private static final String PUNTUACION = "PNT";

    private String namePlayer;
    private String ip;
    private int puerto;
    private String traza;
    private String respuesta;
    private Observador obs;
    private ControladorCliente controlador;

    public Cliente(String namePlayer, String ip, int puerto,ControladorCliente controlador) {
        this.controlador = controlador;
        this.ip = ip;
        this.puerto = puerto;
        this.namePlayer = namePlayer;

    }

    public void run() {
        boolean exit = false;//bandera para controlar ciclo del programa
        Socket socket;//Socket para la comunicacion cliente servidor
        try {
            System.out.println("Cliente> Inicio");
            socket = new Socket(this.ip, this.puerto);//abre socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Para leer lo que envie el servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);//para imprimir datos del servidor
            controlador.start();
            controlador.getSnake().start();

            while (true) {

                //Se manda el mensaje para conectar con el servidor
                //Lee el servidor
                String respuestaServidor;
                while ((respuestaServidor = in.readLine()) != null){
                    if(respuestaServidor == "FIN;1") {
                        socket.close();
                        this.interrupt();
                    }
                    System.out.println("Server>: " + respuestaServidor);
                    controlador.setRespuesta(respuestaServidor);
                    break;
                }

                /*if(respuestaServidor == "FIN;1") {
                    socket.close();
                    this.interrupt();
                }*/

                //Contesta al servidor
                out.println(controlador.getTraza());
                out.flush();

            }
        } catch (IOException ex) {
            System.err.println("Cliente> " + ex.getMessage()); // TODO Controlar con un mensaje en la gui que el servidor no acepta conexiones
        }
    }


    public void traducirParaEjecutar (String respuesta){
        String[] cabeceras = respuesta.split(";");
        switch(cabeceras[0]){
            case MOVIMIENTO:
                controlador.setRespuesta(respuesta);
                break;
        }
    }

    public void setTraza(String traza) {
        this.traza = traza;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Observador getObs() {
        return obs;
    }
}