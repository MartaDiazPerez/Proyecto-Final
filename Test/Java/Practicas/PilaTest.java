package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PilaTest {
    //como el metodo PUSH es un metodo void no devuelve nada asi que para probar que funciona
    //compruebo que el hacer un push la listano esta vacia
    @Test
    void Push(){
        //creo una nueva pila vacia
        Pila<Integer> pila1= new Pila();
        pila1.push(2);//añado un elemento
        assertFalse(pila1.isEmpty());

    }
    //compruebo que el metodo Pop funcione, como no devuelve nada añado un elemento y hago pop de forma que
    //la pila se quede vacia y compruebo que esta vacia con el metodo isEmpty
    @Test
    void Pop(){
        //creo una pila vacia
        Pila<Integer> pila1= new Pila();
        //añado un elemento a la pila
        pila1.push(2);
        pila1.pop();
        assertFalse(pila1.isEmpty());
        
    }
    //pruebo el metodo isEmpty creando una pila vacia y viendo que esta vacia y da true
    //meto un elemento y veo que isEmpty devuele false
    @Test
    void isEmpty(){
        Pila<Integer> pila1= new Pila();
        assertTrue(pila1.isEmpty());
        pila1.push(10);
        assertFalse(pila1.isEmpty());
    }

}