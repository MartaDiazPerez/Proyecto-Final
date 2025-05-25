package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para ListaIterador.
 * Se validan los métodos hasNext(), next() y delete().
 */
class ListaIteradorTest {

    /**
     * Prueba el método hasNext() para verificar si hay más elementos en la lista.
     * Se valida que la iteración detecte correctamente la presencia de elementos.
     */
    @Test
    void hasNext() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        lista.add(10);
        lista.add(20);

        Iterador<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext()); // Hay elementos disponibles
        iterador.next();
        iterador.next();
        assertFalse(iterador.hasNext()); // Ya no hay más elementos
    }

    /**
     * Prueba el método next() para obtener el siguiente elemento en la iteración.
     * Se verifica que los elementos sean devueltos en el orden correcto.
     */
    @Test
    void next() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        Iterador<Integer> iterador = lista.getIterador();
        assertEquals(10, iterador.next()); // Primer elemento
        assertEquals(20, iterador.next()); // Segundo elemento
        assertEquals(30, iterador.next()); // Tercer elemento
    }

    /**
     * Prueba el método delete() para eliminar el último elemento retornado por next().
     * Se valida que la eliminación funcione correctamente y que la iteración continúe sin errores.
     */
    @Test
    void delete() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        Iterador<Integer> iterador = lista.getIterador();
        iterador.next(); // Avanza al primer elemento (10)
        iterador.delete(); // Elimina el primer elemento
        assertEquals(2, lista.getNumElementos()); // Ahora hay 2 elementos en la lista
        assertEquals(30, iterador.next()); // El nuevo primer elemento debería ser 20
    }
}