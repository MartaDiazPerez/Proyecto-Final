public class Tablero implements ITablero{
    private ICasilla[][] casillas;
    private int filas, columnas;

    public void inicializarTablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casillas = new ICasilla[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(0,1); //Por defecto
            }
        }
    }

    public ICasilla obtenerCasilla(int fila, int columnas) {
        return casillas[fila][columnas];
    }

    public boolean moverUnidad(IUnidad unidad, int nuevaFila, int nuevaColumna) {
        if (nuevaFila < 0 || nuevaFila >= filas || nuevaColumna < 0 || nuevaColumna >= columnas );
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].getUnidad() == unidad) {
                    casillas[i][j].liberar();
                    casillas[nuevaFila][i].ocupar(unidad);
                    unidad.mover(nuevaFila, nuevaColumna);
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarUnidad(IUnidad unidad, int fila, int columna) {
        casillas[fila][columna].ocupar(unidad);
        unidad.mover(fila, columna);
    }

    public void eliminarUnidad( int fila, int columna) {
        casillas[fila][columna].liberar();
    }

    public void guardarTablero(String nombreArchivo) {
        //Implementar
    }

    public void cargarTablero(String nombreArchivo) {
        //Implementar
    }
}
