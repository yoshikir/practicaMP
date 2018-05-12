package Cliente.Conectividad;

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
    private Puntuacion punt;
    private int idCliente;
    private String respuesta;
    private String traza;
    //private Observador observer;

    public ControladorCliente(Arena arena, MovimientoSnake snake, Puntuacion punt) {
        this.arena = arena;
        this.snake = snake;
        this.punt = punt;
        //this.observer = con.getObs();
    }

    //detecta las distintas cabeceras recibidas por el cliente desde el servidor
    //y las redirige a sus respectivas vistas o actualiza los datos del cliente
    public void run() {
        while (true) {
            if (respuesta != null || respuesta == "") {
            String[] mensaje = respuesta.split(";");//observer.getRespuesta().split(";");
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
            if(traza!=null || traza!=""){
                switch (arena.getDireccion()){
                    case 1:
                        traza = "DIR;ARRIBA";
                        break;
                    case 2:
                        traza = "DIR;DER";
                        break;
                    case 3:
                        traza = "DIR;ABAJO";
                        break;
                    case 4:
                        traza = "DIR;IZQ";
                        break;
                }
            }
        }
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getTraza() {
        return traza;
    }

    public MovimientoSnake getSnake() {
        return snake;
    }
}
