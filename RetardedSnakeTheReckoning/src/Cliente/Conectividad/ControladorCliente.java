package Cliente.Conectividad;

import Cliente.Conectividad.Cliente;
import Cliente.MovimientoSnake;
import Cliente.Vista.Tesoro;
import Cliente.GUI.Arena;
import Cliente.GUI.Puntuacion;

/**
 * Esta clase es el controlador del cliente que se encarga de la modificaciones
 * de todas las variables necesarias, envía el próximo movimiento de cada uno de
 * los jugadores presentes, inicia las posiciones de los tesoros, avisa de
 * errores, etc
 *
 * @author Yoshiki
 */
public class ControladorCliente extends Thread {

    private final String ID_CLIENTE = "IDC";
    private final String MOVIMIENTO = "MOV";
    private final String PUNTUACION = "PTS";
    private final String ERROR = "ERR";
    private final String TESORO = "TES";

    private Arena arena;
    private MovimientoSnake snake;
    private Cliente con;
    private Puntuacion punt;
    private int idCliente;
    private Observador observer;

    public ControladorCliente(Arena arena, MovimientoSnake snake, Puntuacion punt, Cliente con) {
        this.arena = arena;
        this.snake = snake;
        this.con = con;
        this.punt = punt;
        this.observer = con.getObs();
    }

    //detecta las distintas cabeceras recibidas por el cliente desde el servidor
    //y las redirige a sus respectivas vistas o actualiza los datos del cliente
    public void run() {
        while (true) {
            String[] mensaje = observer.getRespuesta().split(";");
            if (mensaje != null) {
                switch (mensaje[0]) {
                    //Traza por defecto: IDC;numId
                    case ID_CLIENTE:
                        idCliente = Integer.parseInt(mensaje[1]);
                        break;
                    case MOVIMIENTO:
                        snake.setJugador(Integer.parseInt(mensaje[1]));
                        snake.setPosX(Integer.parseInt(mensaje[2]));
                        snake.setPosY(Integer.parseInt(mensaje[3]));
                        snake.setBorrarX(Integer.parseInt(mensaje[4]));
                        snake.setBorrarY(Integer.parseInt(mensaje[5]));
                        break;
                    case PUNTUACION:
                        switch (mensaje[1]) {
                            case "1":
                                punt.setJugador1Puntuacion(mensaje[2]);
                                break;
                            case "2":
                                punt.setJugador2Puntuacion(mensaje[2]);
                                break;
                            case "3":
                                punt.setJugador3Puntuacion(mensaje[2]);
                                break;
                            case "4":
                                punt.setJugador4Puntuacion(mensaje[2]);
                                break;
                        }
                        break;
                    case ERROR:
                        break;
                    case TESORO:
                        Tesoro tes = new Tesoro(Integer.parseInt(mensaje[1]), Integer.parseInt(mensaje[2]), arena);
                        break;
                }
            }
        }
    }

}
