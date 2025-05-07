package Interfaces;

public interface IUnidad {
    int getHP();
    int getAtaque();
    int getDefensa();
    int getRangoMovimiento();
    int getRangoAtaque();
    void recibirDanio(int danio);
    void mover(int fila, int columna);
    boolean estaViva();
    String getNombre();
    IInventario getInventario();
}
