package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test que prueba la clase de la ListaSimplementeEnlazada*/
class ListaSimplementeEnlazadaTest {
    /** Prueba el metodo añadir elementos de la lista enlazada.*/
    @Test
    void add() {
        // Se crea una lista con un elemento inicial
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0,null);
        //Se añaden dos elementos y se comprueba que se haya hecho correctamente y devuelve true
        assertTrue(lista.add(10));
        assertTrue(lista.add(20));
        //Comprueba que el numero de elementos coincide
        assertEquals(2,lista.getNumElementos());
    }
    /** Prueba el metodo eliminar elementos de la lista enlazada.*/
    @Test
    void delete() {
        // Se crea una lista con un elemento inicial
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0,null);
        // Se añaden elementos a la lista
        lista.add(10);
        lista.add(20);
        lista.add(30);
        //Se elimina el elemento '20' y devuelve true si es correcto
        assertTrue(lista.delete(20));
        //Comprueba que el número de elementos coincide
        assertEquals(2,lista.getNumElementos());
       //Devuelve un false al eliminar el elemento '60' porque no existe
        assertFalse(lista.delete(60));
    }

    /**Prueba el metodo de getIterador() de la lista enlazada*/
    @Test
    void getIterador() {
        // Se crea una lista con un elemento inicial
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0, null);
        // Se añaden elementos a la lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
        // Se obtiene el iterador de la lista
        Iterador<Integer> iterador = lista.getIterador();
        // Se verifica que el iterador no es nulo y que tiene elementos
        assertNotNull(iterador);
        assertTrue(iterador.hasNext());
        // Se verifica que el iterador recorre correctamente la lista
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        // Se verifica que no hay más elementos en el iterador
        assertFalse(iterador.hasNext());

    }

    /**Prueba el metodo getNumElementos() de la lista enlazada.*/
    @Test
    void getNumElementos() {
        // Se crea una lista con un elemento inicial
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0, null);
        // Se verifica que la lista está vacía al inicio
        assertEquals(0, lista.getNumElementos());
        // Se agregan elementos y se verifica el número de elementos
        lista.add(5);
        lista.add(15);
        assertEquals(2, lista.getNumElementos());
        // Se elimina un elemento y se verifica el número de elementos
        lista.delete(5);
        assertEquals(1, lista.getNumElementos());
    }
}