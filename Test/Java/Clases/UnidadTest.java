package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnidadTest {
    Unidad unidad1 = new Unidad(50,12,18,1,1,"Matematico ");

    @Test
    void recibirDanio() {
        assertEquals(3,unidad1.recibirDanio( danio));
    }

    @Test
    void getHp() {
        assertEquals(100, unidad1.getHp());

    }
    // como esta recien creada debe aparecer en el 0
    @Test
    void getX() {
        assertEquals(0, unidad1.getX());
    }

    @Test
    void getY() {
        assertEquals(0, unidad1.getY());
    }

    @Test
    void setPosicion() {
        unidad1.setPosicion(0,0);
        assertEquals(0, unidad1.getX());
    }

    @Test
    void getRangoMovimiento() {
        assertEquals(1, unidad1.getRangoMovimiento());
    }

    @Test
    void getRangoAtaque() {
        assertEquals(1, unidad1.getRangoAtaque());
    }

    @Test
    void getDefensa() {
        assertEquals(18, unidad1.getDefensa());
    }

    @Test
    void getAtaque() {
        assertEquals(12, unidad1.getAtaque());
    }

    @Test
    void getNombre() {
        assertEquals("Matematico",unidad1.getNombre());
    }
}