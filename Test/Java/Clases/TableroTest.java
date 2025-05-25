package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    Tablero tablero = new Tablero(5,5);

    @Test
    void getCasilla() {
        Casilla c = tablero.getCasilla(2, 3);
        assertNotNull(c);
        assertEquals(2, c.getX());
        assertEquals(3, c.getY());

        assertNull(tablero.getCasilla(-1, 0));
        assertNull(tablero.getCasilla(5, 5));

    }

    @Test
    void esPosicionValida() {
        assertTrue(tablero.esPosicionValida(0, 0));
        assertTrue(tablero.esPosicionValida(4, 4));
        assertFalse(tablero.esPosicionValida(-1, 0));
        assertFalse(tablero.esPosicionValida(5, 2));
        assertFalse(tablero.esPosicionValida(2, 5));
    }

    @Test
    void ocuparCasilla() {
        tablero.ocuparCasilla(1, 1);
        assertTrue(tablero.getCasilla(1, 1).estaOcupada());
    }

    @Test
    void desocuparCasilla() {
        tablero.ocuparCasilla(1, 1);
        tablero.desocuparCasilla(1, 1);
        assertFalse(tablero.getCasilla(1, 1).estaOcupada());
    }

    @Test
    void getFilas() {
        assertEquals(5, tablero.getFilas());
    }

    @Test
    void getColumnas() {
        assertEquals(5, tablero.getColumnas());
    }
}