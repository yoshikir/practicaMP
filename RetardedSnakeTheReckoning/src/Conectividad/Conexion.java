/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectividad;
import java.io.*;
import java.net.*;
import java.util.logging.*;


/*La clase conexion contiene los atributos necesarios para que la serpiente se pueda conectar tanto a localhost como a una red externa a traves del router
Esta clase cuenta con los parametros del sockect, los data input y output y la la ide la conexion*/
public class Conexion extends Thread {
    
    protected String mensajeServidor;
    
    private Socket socket;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int idSession;
    
    /*Creacion del constructor para la clase conexion, debemos pasarle los parametros del socket y el id del cliente */
    public Conexion(Socket socket ,int id){
        this.socket=socket;
        this.idSession=id;
        try{
            dos = new DataOutputStream(socket.getOutputStream());/*manda mensaje al servidor*/
            dis = new DataInputStream(socket.getInputStream());/*entra el mensaje */
        }catch (IOException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

   // public Conexion(Socket socket, int idSession) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    public Conexion() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 
    /*Desconexion del socket */
    public void desconexion(){
        try{
            socket.close();
        }catch(IOException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    /*Dentro del metodo run gestionamos que hacer cuando recibamos un
    mensaje del cliente*/
    @Override
    public void run() {
        //String accion="";
        try{
            //accion = dis.readUTF();
            //if(accion.equals("hola")){
                System.out.println("El cliente se ha conectado");
                
                dos.writeUTF("El cliente se ha desconectado");
            //}
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
desconexion();
    }

    public String getMensajeServidor() {
        return mensajeServidor;
    }
     
    }
