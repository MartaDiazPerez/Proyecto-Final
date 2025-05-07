package Interfaces;

public interface ITablero {
    void inicializarTablero(int filas, int columnas);
    ICasilla obtenerCasilla(int fila, int columna);
    boolean moverUnidad(IUnidad unidad, int nuevaFila, int nuevaColumna);
    void agregarUnidad(IUnidad unidad, int fila, int columna);
    void eliminarUnidad(int fila, int columna);
    void guardarTablero(String nombreArchivo);
    void cargarTablero(String nombreArchivo);

}
