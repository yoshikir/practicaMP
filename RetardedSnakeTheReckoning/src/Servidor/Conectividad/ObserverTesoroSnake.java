package Servidor.Conectividad;

import Servidor.Modelo.TesoroServer;
import Servidor.Sesion.Serpiente.CachoSerpiente;
import Servidor.Sesion.Serpiente.Serpiente;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ObserverTesoroSnake implements Observer {

    private int serpienteX;
    private int serpienteY;
    private int tesoroX;
    private int tesoroY;

    public ObserverTesoroSnake(){
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof CachoSerpiente){
            serpienteX = ((CachoSerpiente) o).getX();
            serpienteY = ((CachoSerpiente) o).getY();

            if(serpienteX == tesoroX && serpienteY == tesoroY){
                if(o instanceof Serpiente)
                    ((Serpiente) o).setComido(true);
            }
        }
        if(observable instanceof TesoroServer){
            tesoroX = ((TesoroServer) o).getX();
            tesoroY = ((TesoroServer) o).getY();
        }
    }

}
