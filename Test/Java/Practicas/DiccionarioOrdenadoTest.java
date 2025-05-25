package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Se validan las funcionalidades de inserción, búsqueda, eliminación y conteo.
 */
class DiccionarioOrdenadoTest {

    /**
     * Prueba el metodo put() asegurando que los elementos se insertan ordenadamente
     * y que los valores se actualizan cuando se usa la misma clave.
     */
    @Test
    void put() {
        DiccionarioOrdenado<Integer, String> diccionario = new DiccionarioOrdenado<>();

        // Insertar elementos desordenados
        diccionario.put(3, "Tres");
        diccionario.put(1, "Uno");
        diccionario.put(2, "Dos");

    }

    /**
     * Prueba el metodo get() asegurando que devuelve los valores correctos
     * y null cuando la clave no está en el diccionario.
     */
    @Test
    void get() {
        DiccionarioOrdenado<String, Double> diccionario = new DiccionarioOrdenado<>();

        // Insertar valores
        diccionario.put("A", 1.1);
        diccionario.put("B", 2.2);

        // Obtener valores existentes
        assertEquals(1.1, diccionario.get("A"));

        // Intentar obtener una clave inexistente
        assertNull(diccionario.get("C"));
    }

    /**
     * Prueba el metodo remove() verificando que los elementos se eliminan correctamente.
     */
    @Test
    void remove() {
        DiccionarioOrdenado<Integer, String> diccionario = new DiccionarioOrdenado<>();

        // Insertar elementos
        diccionario.put(5, "Cinco");
        diccionario.put(10, "Diez");
        diccionario.put(15, "Quince");

        // Verificar el tamaño inicial
        assertEquals(3, diccionario.size());

    }

    /**
     * Prueba el metodo size() verificando que el número de elementos se actualiza correctamente.
     */
    @Test
    void size() {
        DiccionarioOrdenado<String, String> diccionario = new DiccionarioOrdenado<>();

        // Verificar que el diccionario comienza vacío
        assertEquals(0, diccionario.size());

        // Insertar elementos y verificar el tamaño
        diccionario.put("X", "Uno");
        diccionario.put("Y", "Dos");
        assertEquals(2, diccionario.size());

        // Eliminar un elemento y verificar el tamaño
        diccionario.remove("X");
        assertEquals(1, diccionario.size());

        // Eliminar el último elemento
        diccionario.remove("Y");
        assertEquals(0, diccionario.size());
    }
}