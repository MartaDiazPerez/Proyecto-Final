public interface ICasilla {
    int getModificadorDefensa();
    int getCosteMovimiento();
    boolean estaOcupada();
    void ocupar(IUnidad unidad);
    void liberar();
    IUnidad getUnidad();
}
