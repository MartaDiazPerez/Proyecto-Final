package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {
    Casilla casilla= new Casilla(0,0,1,2,3, false);

    @Test
    void estaOcupada() {
        assertFalse(casilla.estaOcupada());
        casilla.ocupar();
        assertTrue(casilla.estaOcupada());
    }

    @Test
    void ocupar() {
        casilla.ocupar();
        assertTrue(casilla.estaOcupada());
    }

    @Test
    void desocupar() {
        casilla.ocupar();
        casilla.desocupar();
        assertFalse(casilla.estaOcupada());
    }

    @Test
    void getCosteMovimiento() {
        assertEquals(casilla.getCosteMovimiento(), 1);
    }

    @Test
    void setCosteMovimiento() {
        casilla.setCosteMovimiento(10);
        assertEquals(casilla.getCosteMovimiento(), 10);
    }

    @Test
    void getDefensaExtra() {
        assertEquals(casilla.getDefensaExtra(), 2);
    }

    @Test
    void setDefensaExtra() {
        casilla.setDefensaExtra(2);
        assertEquals(casilla.getDefensaExtra(), 2);
    }

    @Test
    void getAtaqueExtra() {
        assertEquals(casilla.getAtaqueExtra(), 2);
    }

    @Test
    void setAtaqueExtra() {
        casilla.setAtaqueExtra(9);
        assertEquals(casilla.getAtaqueExtra(), 9);
    }

    @Test
    void setX() {
        casilla.setX(8);
        assertEquals(casilla.getX(), 8);
    }

    @Test
    void getX() {
        assertEquals(casilla.getX(), 8);
    }

    @Test
    void setY() {
        casilla.setY(8);
        assertEquals(casilla.getY(), 8);
    }

    @Test
    void getY() {
        assertEquals(casilla.getY(), 8);
    }

    @Test
    void setPosicion() {
        casilla.setPosicion(0,0);
        assertEquals(0, casilla.getX());
        assertEquals(0, casilla.getY());

    }

    @Test
    void getPosicionX() {
        assertEquals(casilla.getPosicionX(), 0);
    }

    @Test
    void getPosicionY() {
        assertEquals(casilla.getPosicionY(), 0);
    }


}