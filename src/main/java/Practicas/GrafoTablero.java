package Practicas;

import Clases.Casilla;
import Clases.Tablero;

public class GrafoTablero {
    private DiccionarioBasico<Posicion, NodoGrafo> nodos;

    public GrafoTablero(Tablero tablero) {
        nodos = new DiccionarioBasico<>();

        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();

        // Crear nodos
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                Posicion pos = new Posicion(x, y);
                nodos.add(pos, new NodoGrafo(pos));
            }
        }

        // Conectar nodos adyacentes (arriba, abajo, izquierda, derecha)
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                Posicion origenPos = new Posicion(x, y);
                NodoGrafo nodoOrigen = nodos.get(origenPos);

                conectarAdyacente(tablero, nodoOrigen, x + 1, y);
                conectarAdyacente(tablero, nodoOrigen, x - 1, y);
                conectarAdyacente(tablero, nodoOrigen, x, y + 1);
                conectarAdyacente(tablero, nodoOrigen, x, y - 1);
            }
        }
    }

    private void conectarAdyacente(Tablero tablero, NodoGrafo origen, int x, int y) {
        if (tablero.esPosicionValida(x, y)) {
            Casilla destinoCasilla = tablero.getCasilla(x, y);
            if (!destinoCasilla.estaOcupada()) {
                Posicion destinoPos = new Posicion(x, y);
                NodoGrafo nodoDestino = nodos.get(destinoPos);
                int coste = destinoCasilla.getCosteMovimiento();
                origen.agregarAdyacente(nodoDestino, coste);
            }
        }
    }

    public NodoGrafo getNodo(Posicion pos) {
        return nodos.get(pos);
    }

    public DiccionarioBasico<Posicion, NodoGrafo> getNodos() {
        return nodos;
    }
}
