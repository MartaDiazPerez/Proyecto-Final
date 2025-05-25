package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColaTest {
    //pruebo el metodo enqueue creando una cola vacia, metiendo un elemento y comprobando
    //que el metodo isEmpty devuelva false
    @Test
    void enqueue() {
        Cola cola = new Cola();
        cola.enqueue(1);
        assertFalse(cola.isEmpty());
    }
    //pruebo el metodo dequeue creando una cola vacia, metiendo dos elementos y sacando uno
    //el metodo isEmpty me devuelve false
    @Test
    void dequeue() {
        Cola cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.dequeue();
        assertFalse(cola.isEmpty());
    }
    //pruebo el metodo isEmpty creando una cola vacia y viendo que me devuelve verdadero el metodo isEmpty
    @Test
    void isEmpty() {
        Cola cola = new Cola();
        assertTrue(cola.isEmpty());
    }
}