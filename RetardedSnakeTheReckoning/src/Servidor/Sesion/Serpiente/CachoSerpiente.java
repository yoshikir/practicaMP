/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Sesion.Serpiente;



/**
 *
 * @author st.fila.2016
 */
public class CachoSerpiente {
    private int posX;
    private int posY;
    
    public CachoSerpiente(int posX,int posY){
        this.posX=posX;
        this.posY=posY;
    
    }
    public int getY(){
        return posY;
    }
    public int getX(){
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
