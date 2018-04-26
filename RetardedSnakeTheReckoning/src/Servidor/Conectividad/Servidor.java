/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import Cliente.Conectividad.Cliente;
import Conectividad.Conexion;
import GUI.MenuOnline;
//import Cliente.Conectividad.Player;
import java.io.*;
import java.net.*;
import java.util.logging.*;

//este clase se encarga de asignar un thread a cada nueva conexion
public class Servidor {
    private static MenuOnline mo;
    private static Cliente cl;
    private static int sc=8000;
    private static void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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
            String idSession;
            while (true){
                
                Socket socket;
                socket = ss.accept();
                idSession=cl.getNamePlayer();
               System.out.println("nueva conexion"+sc);
                
                ((Conexion)new Conexion(socket,idSession)).start();
                
               // idSession++;
            }
        }catch (IOException ex){
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
           }
        }

    

  
    }
    

