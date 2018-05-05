/*Player es el objeto jugador al cual se le mandan todos los datos*/
package Cliente.Conectividad;



import GUI.MenuOnline;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {
    protected MenuOnline mo;
    private String namePlayer;
    public Cliente(MenuOnline mo,String namePlayer) {
       this.mo = mo;
        this.namePlayer=mo.getjTextFieldNamePlayer().getText(); 
    }

    public Cliente() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * Puerto
     * */
    //private final static int PORT = 8000;
    /**
     * Host
     * */
   // private final static String SERVER = "localhost";

    public void run(String player, String Ip,int puerto) {
        boolean exit=false;//bandera para controlar ciclo del programa
        Socket socket;//Socket para la comunicacion cliente servidor
        try {
            System.out.println("Cliente> Inicio");
            while( !exit ){//ciclo repetitivo
                socket = new Socket(Ip, puerto);//abre socket
                //Para leer lo que envie el servidor
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                //para imprimir datos del servidor
                PrintStream output = new PrintStream(socket.getOutputStream());
                //Para leer lo que escriba el usuario
                BufferedReader brRequest = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Dime movimiento "+player);
                //captura comando escrito por el usuario
                String movimientoRequerido = brRequest.readLine();
                //manda peticion al servidor
                output.println(movimientoRequerido);
                //captura respuesta e imprime
                String st = input.readLine();
                if( st != null ) System.out.println("Servidor> " + st );
                if(movimientoRequerido.equals("exit")){//terminar aplicacion
                    exit=true;
                    System.out.println("Cliente> Fin de programa");
                }
                socket.close();
            }//end while
        } catch (IOException ex) {
            System.err.println("Cliente> " + ex.getMessage());
        }
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
