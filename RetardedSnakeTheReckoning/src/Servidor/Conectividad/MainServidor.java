/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

/**
 *
 * @author Yoshiki
 */
public class MainServidor {
    
    public static void main (String[] args){
        Servidor server = new Servidor();
        server.conectar();
    }
    
}
