package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Se validan las funcionalidades de agregar, obtener, eliminar y contar elementos.
 */
class DiccionarioBasicoTest {

    /**
     * Prueba el metodo put() verificando que los elementos se agregan correctamente
     * y que los valores se actualizan cuando se usa la misma clave.
     */

    @Test
    void add() {
        DiccionarioBasico<String, Integer> diccionario = new DiccionarioBasico<>();

        // Añadir un nuevo par clave-valor
        diccionario.add("A", 1);
        assertEquals(1, diccionario.get("A"));

        // Añadir otra clave diferente
        diccionario.add("B", 2);

        // Reemplazar el valor de una clave existente
        diccionario.add("A", 10);
        assertEquals(10, diccionario.get("A"));

        // Verificar que el tamaño es 2 (no se duplican claves)
        assertEquals(2, diccionario.getNumElementos());
    }

    /**
     * Prueba el metodo {get() asegurando que devuelve los valores correctos
     * y null cuando la clave no está presente.
     */
    @Test
    void get() {
        DiccionarioBasico<String, String> diccionario = new DiccionarioBasico<>();

        // Insertar valores
        diccionario.add("Clave1", "Valor1");
        diccionario.add("Clave2", "Valor2");

        // Verificar que se obtienen los valores correctos
        assertEquals("Valor1", diccionario.get("Clave1"));

    }

    /**
     * Prueba el metodo remove() verificando la eliminación de elementos en distintas situaciones.
     */
    @Test
    void delete() {
        DiccionarioBasico<Integer, String> diccionario = new DiccionarioBasico<>();

        // Insertar valores
        diccionario.add(1, "Uno");
        diccionario.add(2, "Dos");
        diccionario.add(3, "Tres");

        // Verificar el tamaño inicial
        assertEquals(3, diccionario.getNumElementos());

        // Eliminar un elemento y verificar que ya no está
        assertNull(diccionario.get(2));
        assertEquals(3, diccionario.getNumElementos());

        // Intentar eliminar un elemento inexistente
        assertFalse(diccionario.delete(99));

        // Eliminar los restantes
        assertTrue(diccionario.delete(1));
    }

    /**
     * Prueba el metodo size() verificando que el número de elementos almacenados es correcto.
     */
    @Test
    void getNumElementos() {
        DiccionarioBasico<String, Double> diccionario = new DiccionarioBasico<>();

        // Diccionario vacío
        assertEquals(0, diccionario.getNumElementos());

        // Insertar elementos
        diccionario.add("X", 1.1);
        diccionario.add("Y", 2.2);
        assertEquals(2, diccionario.getNumElementos());

        // Eliminar un elemento y verificar el tamaño
        diccionario.delete("X");
        assertEquals(1, diccionario.getNumElementos());

        // Eliminar el último elemento
        diccionario.delete("Y");
        assertEquals(0, diccionario.getNumElementos());
    }
    @Test
    void testExists() {
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<String,Integer>();
        diccionario.add("uno", 1);
        diccionario.add("dos", 2);
        diccionario.add("tres", 3);
        assertTrue(diccionario.exists("uno"));
        assertFalse(diccionario.exists("cuatro"));
    }

    @Test
    void testGetIterator() {
        DiccionarioBasico<String,Integer> diccionario = new DiccionarioBasico<String,Integer>();
        diccionario.add("uno", 1);
        diccionario.add("dos", 2);
        diccionario.add("tres", 3);
        Iterador<ElementoDiccionario<String, Integer>> iterador = diccionario.getIterator();
        assertNotNull(iterador);

        assertTrue(iterador.hasNext());
        ElementoDiccionario<String, Integer> elemento = iterador.next();
        assertNotNull(elemento);
        assertEquals("uno", elemento.clave); // Verificamos que el primer elemento es "uno"
    }
}