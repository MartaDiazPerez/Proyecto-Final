package Interfaces;

public interface IPartida {
    void iniciar();
    void terminar();
    IJugador getJugadorActual();
    void siguienteTurno();
    boolean esFinDePartida();
    void guardarPartida(String nombreArchivo);
    void cargarPartida(String nombreArchivo);
}
