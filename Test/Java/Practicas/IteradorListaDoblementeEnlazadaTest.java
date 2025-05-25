package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaDoblementeEnlazadaTest {
    //Prueba que el iterador recorre correctamente la lista doblemente enlazada.
    //Se crean tres nodos enlazados y se verifica que el iterador los recorra en orden.

    @Test
    void testIteradorRecorrido() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(2);
        ElementoDoble<Integer> nodo3 = new ElementoDoble<>(3);
        // Enlazar los nodos manualmente
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;
        nodo2.siguiente = nodo3;
        nodo3.anterior = nodo2;
        // Crear el iterador
        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);
        // Verificar el recorrido de los elementos en orden
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(2, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(3, iterador.next());
        assertFalse(iterador.hasNext());
    }
    //Prueba la eliminación del único nodo de la lista.
    //Se crea un nodo, se recorre y luego se elimina, verificando que la lista quede vacía.
    @Test
    void testEliminarUltimoNodo() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(1);
        //Prueba la eliminación del único nodo de la lista.
        //Se crea un nodo, se recorre y luego se elimina, verificando que la lista quede vacía.
        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);

        iterador.next(); // nodo1
        iterador.delete(); // Elimina nodo1
        // Verificar que la lista está vacía
        assertFalse(iterador.hasNext());
        assertNull(iterador.next());
    }

    @Test
    void hasNext() {
        ElementoDoble<Integer> nodo = new ElementoDoble<>(10);
        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo);
        assertTrue(iterador.hasNext());// Debería haber un elemento
        iterador.next();// Avanza en la lista
        assertFalse(iterador.hasNext());// Ya no debería haber más elementos
    }
    //Prueba el metodo next() asegurando que devuelve los elementos en el orden correcto.
    @Test
    void next() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(5);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(10);
        // Enlazar los nodos
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);
        // Verificar que el iterador recorre correctamente los elementos
        assertEquals(5, iterador.next());
        assertEquals(10, iterador.next());
        assertNull(iterador.next());// No hay más elementos
    }
    //Prueba el metodo delete()  eliminando un nodo y verificando la estructura restante.
    @Test
    void delete() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(7);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(14);
        // Enlazar los nodos
        nodo1.siguiente = nodo2;// Avanza a nodo1
        nodo2.anterior = nodo1;// Elimina nodo1

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);
        iterador.next();
        iterador.delete(); // Borra nodo1
        // Verificar que el siguiente elemento es nodo2
        assertEquals(14, iterador.next());
        assertFalse(iterador.hasNext());// No hay más elementos en la lista
    }
}