package Interfaces;

public interface IVistaJuego {
    void mostrarTablero(ITablero tablero);
    void actualizarUnidad(IUnidad unidad);
    void mostrarMensaje(String mensaje);
    void setControlador(IControladorJuego controlador);

}
