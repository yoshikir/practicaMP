/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Conectividad;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Yoshiki
 */
public class ObservadorServer implements Observer {

    String peticion;

    @Override
    public void update(Observable o, Object obj) {
        /*if(o instanceof Servidor){
            peticion = (String) obj;
        }*/
    }

    public String getPeticion() {
        return peticion;
    }
}
