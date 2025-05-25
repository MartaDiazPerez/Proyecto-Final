package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    private Jugador jugadorIA;
    private Jugador jugadorHumano;
    private Unidad unidad1;
    private Unidad unidad2;

    @Test
    void getNombre() {
        assertEquals("IA", jugadorIA.getNombre());
        assertEquals("Jugador1", jugadorHumano.getNombre());
    }

    @Test
    void esIA() {
        assertTrue(jugadorIA.esIA());
        assertFalse(jugadorHumano.esIA());
    }

    @Test
    void getUnidades() {
        jugadorHumano.agregarUnidad(unidad1);
        assertFalse(jugadorHumano.getUnidades().estaVacia());
    }

    @Test
    void agregarUnidad() {
        assertTrue(jugadorIA.getUnidades().estaVacia());
        jugadorIA.agregarUnidad(unidad1);
        assertFalse(jugadorIA.getUnidades().estaVacia());
    }

    @Test
    void eliminarUnidad() {
        jugadorIA.agregarUnidad(unidad1);
        jugadorIA.agregarUnidad(unidad2);
        jugadorIA.eliminarUnidad(unidad1);
        assertEquals(unidad2, jugadorIA.getUnidades().get(0));
    }

    @Test
    void tieneUnidades() {
        assertFalse(jugadorHumano.tieneUnidades());
        jugadorHumano.agregarUnidad(unidad1);
        assertTrue(jugadorHumano.tieneUnidades());
    }
}