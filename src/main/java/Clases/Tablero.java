package Clases;

import Interfaces.ICasilla;
import Interfaces.ITablero;
import Interfaces.IUnidad;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casillas = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(i, j, 1, 0, 0, false);
            }
        }
    }

    public Casilla getCasilla(int x, int y) {
        if (x >= 0 && y >= 0 && x < filas && y < columnas) {
            return casillas[x][y];
        }
        return null;
    }

    public boolean esPosicionValida(int x, int y) {
        return x >= 0 && y >= 0 && x < filas && y < columnas;
    }

    public void ocuparCasilla(int x, int y) {
        casillas[x][y].ocupar();
    }

    public void desocuparCasilla(int x, int y) {
        casillas[x][y].desocupar();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
