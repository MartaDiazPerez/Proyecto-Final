package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Se validan las funcionalidades de agregar, eliminar, obtener iteradores y contar elementos.
class ListaDoblementeEnlazadaTest {
    //Prueba el metodo add() verificando que los elementos se agregan correctamente a la lista.
    @Test
    void add() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();

        // Verifica que la lista inicialmente está vacía
        assertEquals(0, lista.getNumElementos());

        // Añadir un elemento
        lista.add(10);
        assertEquals(1, lista.getNumElementos());

        // Añadir otro elemento
        lista.add(20);
        assertEquals(2, lista.getNumElementos());
    }
    //Prueba el metodo delete() verificando la eliminación de elementos en diferentes posiciones.
    @Test
    void delete() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();

        // Añadir elementos a la lista
        lista.add(10);
        lista.add(20);
        lista.add(30);

        // Verifica que la lista tiene 3 elementos
        assertEquals(3, lista.getNumElementos());

        // Eliminar un elemento que está en el medio
        assertTrue(lista.delete(20));
        assertEquals(2, lista.getNumElementos());

        // Intentar eliminar un elemento que no existe
        assertFalse(lista.delete(40));

        // Eliminar el primer elemento
        assertTrue(lista.delete(10));
        assertEquals(1, lista.getNumElementos());

        // Eliminar el último elemento
        assertTrue(lista.delete(30));
        assertEquals(0, lista.getNumElementos());
    }
    //Prueba el metodo getIterador() asegurando que el iterador recorre los elementos en el orden correcto.
    @Test
    void getIterador() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();

        // Añadir elementos a la lista
        lista.add(10);
        lista.add(20);
        lista.add(30);

        // Crear un iterador y verificar que recorre los elementos correctamente
        Iterador<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals(10, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(20, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(30, iterador.next());
        assertFalse(iterador.hasNext());
    }
    //Prueba el méetodo getNumElementos() verificando que devuelve el número correcto de elementos.
    @Test
    void getNumElementos() {
        ListaDoblementeEnlazada<String> lista = new ListaDoblementeEnlazada<>();

        // Verifica que inicialmente la lista está vacía
        assertEquals(0, lista.getNumElementos());

        // Añadir elementos
        lista.add("a");
        lista.add("b");
        lista.add("c");

        // Verifica el número de elementos
        assertEquals(3, lista.getNumElementos());

        // Eliminar un elemento
        lista.delete("b");
        assertEquals(2, lista.getNumElementos());
    }
}