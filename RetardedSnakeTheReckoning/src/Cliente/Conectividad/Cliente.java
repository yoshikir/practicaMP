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

     Cliente(MenuOnline mo,String namePlayer) {
        this.mo = mo;
        this.namePlayer=mo.getjTextFieldNamePlayer().getText();     
    }
    //String player=mo.getjTextFieldDireccionIP().getText();

    public String getNamePlayer() {
        return namePlayer;
    }

   

   


    public void start(/*String player, String Ip, String puerto*/) {
         try {
            
            sc = new Socket(mo.getjTextFieldDireccionIP().getText(), Integer.parseInt(mo.getjTextFieldSocket().getText()));
            dos = new DataOutputStream(sc.getOutputStream());
            dis = new DataInputStream(sc.getInputStream());
            System.out.println(mo.getjTextFieldNamePlayer().getText() + " di algo");
            dos.writeUTF("hola");
            String respuesta = "";
            System.out.println(mo.getjTextFieldNamePlayer().getText() + " devolver saludo " + respuesta);
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
