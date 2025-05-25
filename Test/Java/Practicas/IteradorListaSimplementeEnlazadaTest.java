package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**Test de la clase IteradorListaSimplementeEnlazada.java*/
class IteradorListaSimplementeEnlazadaTest {

    /**Se prueba el metodo tiene siguiente*/
    @Test
    void hasNext() {
        //Se crean los dos nodos con valores 10 y 20
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        nodo1.siguiente = nodo2;
        //Se inicializa el iterador con el primer nodo
        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        //Se verifica que hay un siguiente elemento
        assertTrue(iterador.hasNext());
        iterador.next(); //Avanza al siguiente nodo
        assertTrue(iterador.hasNext());
        iterador.next(); //Avanza al siguiente nodo
        assertFalse(iterador.hasNext());//No hay más elementos
    }

    /**Se prueba el metodo siguiente elemento*/
    @Test
    void next() {
        //Se crean dos nodos con valores 10 y 20
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        nodo1.siguiente = nodo2;
        // Se inicializa el iterador con el primer nodo
        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        assertEquals(10, iterador.next()); //Primer elemento
        assertEquals(20, iterador.next()); //Segundo elemento
        assertNull(iterador.next()); //Como no hay mas elementos va a devolver un null
    }

    /**Prueba el metodo elimar de la clase del iterador*/
    @Test
    void delete() {
        //Se crean los tres nodos con valores 10, 20 y 30
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        Elemento<Integer> nodo3 = new Elemento<>(30);
        nodo1.siguiente = nodo2;
        nodo2.siguiente = nodo3;
        // Se inicializa el iterador con el primer nodo
        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        iterador.next(); // Avanza a 10
        iterador.delete(); // Elimina 10, ahora la cabeza es 20
        assertEquals(30, iterador.next()); // El siguiente elemento ahora es 30
        assertEquals(null, iterador.next()); //No hay más elementos
        assertNull(iterador.next()); //Ya no hay ninguno más
    }

}