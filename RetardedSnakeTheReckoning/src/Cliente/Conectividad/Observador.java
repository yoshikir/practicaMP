/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Conectividad;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Yoshiki
 */
public class Observador implements Observer{
    
    private String respuesta;

    @Override
    public void update(Observable o, Object obj) {

    }
    
    public String getRespuesta(){
        return respuesta;
    }
    
}
