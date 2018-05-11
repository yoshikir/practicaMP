/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import Servidor.Sesion.DatosSesion;
import Servidor.Sesion.MovimientoSnakeServer;
import Servidor.Sesion.Serpiente.Serpiente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;

public class Servidor extends Observable{

    /**
     * Puerto
     */
    private final static int PORT = 8000;
    
    private String peticion = "";
    private ObservadorServer observador;
    private MovimientoSnakeServer mss;
    private Serpiente[] snakes;
    private ArrayList<DatosSesion> clientesConectados;
    
    public Servidor(){
        observador = new ObservadorServer();
        addObserver(observador);
        snakes = new Serpiente[4];
        mss = new MovimientoSnakeServer(snakes);
        clientesConectados = new ArrayList<>();
    }

    public void conectar() {

        try {
            
            //TODO controlar que cuando los jugadores se hayan conectado, se inicie el hilo de MovimientoSnakeServer
           
            
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor> Servidor iniciado");
            System.out.println("Servidor> En espera de cliente...");
            
            
            
            
            //Socket de cliente
            Socket clientSocket;
            while (true) {
                //en espera de conexion, si existe la acepta
                clientSocket = serverSocket.accept();
                
                DatosSesion a=new DatosSesion(1,mss);
                mss.setSnakes(a.getIdCliente(),a.getSnake());
                clientesConectados.add(a);

                
                mensajesServidor(clientSocket);
                //cierra conexion
                clientSocket.close();

            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("adios amigo");
    }

    private void mensajesServidor(Socket clientSocket) {
        try {
                        
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//Para leer lo que envie el cliente
            PrintStream output = new PrintStream(clientSocket.getOutputStream());//para imprimir datos de salida
            
            String mensaje = input.readLine();//se lee peticion del cliente
            System.out.println("Cliente> petición [" + mensaje + "]");
            notifyObservers(mensaje);
            
            //ESTO no ESTÁ tan MAAAAAAL v (-W-) Cthulhu! Ka namaa ftaghn cthulhuuu!
            clientesConectados.get(0).getCs().start();
            
            
            
            // ^MUY MAAAAAAL
            
            
            //se procesa la peticion y se espera resultado
            /*
                
                Aquí se debe intercalar la clase controlador
                
             */
            String movimientoRealizado = "movimiento aceptado";//Se imprime en consola "servidor"
            System.out.println("Servidor> Resultado de petición");
            System.out.println("Servidor> \"" + movimientoRealizado + "\"");
            //se imprime en cliente
            output.flush();//vacia contenido
            output.println(movimientoRealizado);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public ObservadorServer getObservador() {
        return observador;
    }
    
}

/*
import Cliente.Conectividad.Cliente;
import Conectividad.Conexion;
import GUI.MenuOnline;
//import com.sun.openpisces.Dasher;
//import Cliente.Conectividad.Player;
import java.io.*;
import java.net.*;
import java.util.logging.*;

//este clase se encarga de asignar un thread a cada nueva conexion
public class Servidor   {
    private static MenuOnline mo;
    //protected DataOutputStream dos;
    private static Cliente cl;
    private static final int sc=8000;

    
    public Servidor(MenuOnline mo,Cliente cl){
        
        Servidor.mo=mo;
        Servidor.cl=cl;
    }
    
    public static void main (String args[]) throws IOException{
        
        ServerSocket ss;
        System.out.println("Inicializando el servidor");
        try{
            ss = new ServerSocket(sc);
            System.out.println("\t[OK]");
            
            while (true){
                //Conexion cx=new Conexion();
                int idSession=1;
                
                Socket socket;
                
                socket = ss.accept();
                
                idSession=1;
                BufferedReader entrada= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                entrada.readLine();
                System.out.println(entrada);
                ((Conexion)new Conexion(socket,idSession)).start();
                
                
              /* System.out.println("nueva conexion"+sc+idSession);
                DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());
               salidaCliente.writeUTF("mensaje recibido");
               System.out.println(cx.getMensajeServidor());*/
//dos = new DataOutputStream(sc.getOutputStream());
//dos.writeUTF("hello player");
// idSession++;
// }
//}catch (IOException ex){
//  Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
//  }catch(Exception e){
// e.printStackTrace();
// }
// }
//}
//class GestionDeEventos{
//creamos en esta clase todo lo relacionado con el apartado modelo del patron vista controlador
//Creacion de las cabeceras
//movSnake= new DataOutputStream(idSession;posX;posY;posX;posY);//String mensajeServidor="mov 1;"+posX";+posY;"posX--;"posY;
//numeroJugadores= new DataOutputStream(idSession);//actualizamos el numero de jugador que se ha conectado
// puntacion=new DataOutputStream(puntos++);//actualizamos la puntuacion cuando nos comememos el tesoro
//msg=new DataOutputStream(error);//manda los mensajes de fallo al servidor
// fin=new DataouptStream(conexionFinalizada);//manda el final de la conexion al jugador
//}

