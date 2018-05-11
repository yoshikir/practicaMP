/*Player es el objeto jugador al cual se le mandan todos los datos*/
package Cliente.Conectividad;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Cliente extends Observable {

    private String namePlayer;
    private String traza;
    private String respuesta;
    private Observador obs;

    public Cliente() {
        obs = new Observador();
        this.addObserver(obs);
    }

    public void run(String player, String Ip, int puerto) {
        boolean exit = false;//bandera para controlar ciclo del programa
        Socket socket;//Socket para la comunicacion cliente servidor
        try {
            System.out.println("Cliente> Inicio");
           
            while (!exit) {
                socket = new Socket(Ip, puerto);//abre socket

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Para leer lo que envie el servidor
                PrintStream output = new PrintStream(socket.getOutputStream());//para imprimir datos del servidor
                BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in));//Para leer lo que escriba el usuario
                DataInputStream dis= new DataInputStream(socket.getInputStream());
                System.out.println(dis);
                System.out.println("El servidor te dice: "+output);
                output.println(output);
                
                
                //mensajeServidor=input.readLine();
                
                //La primera traza debe ser la comprobación del estado del server
                //La siguiente respuesta debe ser el ACK del servidor
                //A continuación el server asigna el id de cliente depende de la sesión
                //con el id asignado a cada cliente se puede mover la serpiente.
                System.out.println("Dime movimiento " + player);
                String movimientoRequerido = brRequest.readLine();//captura comando escrito por el usuario
                //output.println(traza);  //@Yoshiki se envía una traza al servidor y este debe responder
                
               
                //String imprimeRespuesta = input.readLine(); //captura respuesta e imprime
                if (respuesta != null) {
                    notifyObservers(respuesta); //Esto llama al método update en el observer
                    System.out.println("Servidor> " + respuesta);
                }
                if (movimientoRequerido.equals("exit")) {//terminar aplicacion
                    exit = true;
                    System.out.println("Cliente> Fin de programa");
                }
                socket.close(); // ????????????????????????????? Esto no debería de estar fuera del while?
            }
        } catch (IOException ex) {
            System.err.println("Cliente> " + ex.getMessage()); // TODO Controlar con un mensaje en la gui que el servidor no acepta conexiones
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

/*
import Conectividad.Conexion;
import GUI.MenuOnline;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.*;

public class Cliente extends Thread  {

    protected Socket sc;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    protected MenuOnline mo;
    protected String namePlayer;
    
    
    //protected int id;
    //private final String IP="127.0.0.1";
    //private final int port=8000;

 
    //String player=mo.getjTextFieldDireccionIP().getText();

    public Cliente(MenuOnline mo,String namePlayer) {
       this.mo = mo;
        this.namePlayer=mo.getjTextFieldNamePlayer().getText(); 
    }

    public Cliente() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public String getNamePlayer() {
        return namePlayer;
    }

    public void run(String player, String Ip,int puerto) {
        
         try {
            sc = new Socket(Ip, puerto);
            dos = new DataOutputStream(sc.getOutputStream());
            dos.writeUTF("hola");//le envia mensaje al servidor
            dis = new DataInputStream(sc.getInputStream());
            //System.out.println(player + " di algo");
            
            
           // String respuesta = "";
            //System.out.println(player + " devolver saludo " + respuesta);
            
            //este comentario no hay que borrarle de momento
            //direccion=new DataInputStream(dir);
            dis.close();
            dos.close();
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

   

   

}

/* class Player {
     //MenuOnline mo= new MenuOnline();
      //String playerName=mo.getjTextFieldNamePlayer().getText();

   // public String getPlayerName() {
      //  return playerName;
    
     
   public static void main(String[] args) {
     Player cl=new Player();
      
       
   }

   


}*/
