package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para ListaBasica.
 * Se validan los métodos de agregar, eliminar, obtener iterador y contar elementos.
 */
class ListaBasicaTest {

    /**
     * Prueba el método add() para agregar elementos a la lista.
     * Se verifica que los elementos se agreguen correctamente y que el conteo sea correcto.
     */
    @Test
    void add() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        assertTrue(lista.add(10)); // Agrega el primer elemento correctamente
        assertTrue(lista.add(20)); // Agrega un segundo elemento correctamente
        assertTrue(lista.add(30)); // Agrega un tercer elemento correctamente
        assertEquals(3, lista.getNumElementos()); // La cantidad de elementos debe ser 3
    }

    /**
     * Prueba el método delete() para eliminar elementos de la lista.
     * Se verifica que el elemento se elimine correctamente y que el conteo de elementos disminuya.
     */
    @Test
    void delete() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        assertTrue(lista.delete(20)); // Se elimina correctamente el 20
        assertEquals(2, lista.getNumElementos()); // La cantidad de elementos debe ser 2
        assertFalse(lista.delete(50)); // No está en la lista, por lo que debe devolver false
        assertTrue(lista.delete(10)); // Se elimina correctamente el 10
        assertEquals(1, lista.getNumElementos()); // Ahora solo queda 1 elemento
    }

    /**
     * Prueba el método getIterador() para obtener un iterador de la lista.
     * Se verifica que el iterador funcione correctamente recorriendo los elementos en orden.
     */
    @Test
    void getIterador() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        Iterador<Integer> iterador = lista.getIterador();
        assertNotNull(iterador); // Se verifica que el iterador no sea nulo
        assertTrue(iterador.hasNext()); // Debe haber un siguiente elemento disponible
        assertEquals(10, iterador.next()); // El primer elemento debe ser 10
        assertEquals(20, iterador.next()); // El segundo elemento debe ser 20
        assertEquals(30, iterador.next()); // El tercer elemento debe ser 30
        assertFalse(iterador.hasNext()); // Ya no debe haber más elementos en la lista
    }

    /**
     * Prueba el método getNumElementos() para obtener el número de elementos en la lista.
     * Se verifica que el número de elementos sea correcto antes y después de agregar elementos.
     */
    @Test
    void getNumElementos() {
        ListaBasica<Integer> lista = new ListaBasica<>(5);
        assertEquals(0, lista.getNumElementos()); // Lista vacía al inicio
        lista.add(10);
        lista.add(20);
        assertEquals(2, lista.getNumElementos()); // La lista ahora tiene 2 elementos
        lista.add(30);
        assertEquals(3, lista.getNumElementos()); // La lista ahora tiene 3 elementos
    }
}