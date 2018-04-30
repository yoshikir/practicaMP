/*Player es el objeto jugador al cual se le mandan todos los datos*/
package Cliente.Conectividad;

import GUI.MenuOnline;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.*;

public class Cliente extends Thread {

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
            dis = new DataInputStream(sc.getInputStream());
            System.out.println(player + " di algo");
            dos.writeUTF("hola");
            String respuesta = "";
            System.out.println(player + " devolver saludo " + respuesta);
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
