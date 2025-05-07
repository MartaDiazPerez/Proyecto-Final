public interface IControladorJuego {
    void moverUnidad(IUnidad unidad, int fila, int columna);
    void atacar(IUnidad atacante, IUnidad objetivo);
    void pasarTurno();
    void salir();

}
