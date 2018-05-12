/*Player es el objeto jugador al cual se le mandan todos los datos*/
package Cliente.Conectividad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Cliente extends Thread {

    private static final String CONEXION = "CNCT";

    private String namePlayer;
    private String ip;
    private int puerto;
    private String traza;
    private String respuesta;
    private Observador obs;

    public Cliente(String namePlayer, String ipp, int puerto) {
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

            while (true) {

                //Se manda el mensaje para conectar con el servidor

                //Lee el servidor
                String respuestaServidor;
                while ((respuestaServidor = in.readLine()) != null){
                    System.out.println("Server>: " + respuestaServidor);
                    break;
                }

                //Contesta al servidor
                out.println("DIR;ARRIBA");
                out.flush();

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
