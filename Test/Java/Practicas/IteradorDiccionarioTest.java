package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorDiccionarioTest {

    /**
     * Prueba el metodo hasNext() verificando si el iterador detecta correctamente la presencia de elementos.
     */
    @Test
    void hasNext() {
        ListaDoblementeEnlazada<ElementoDiccionario<Integer, String>> lista = new ListaDoblementeEnlazada<>();
        IteradorDiccionario<Integer, String> iteradorVacio = new IteradorDiccionario<>(null, lista);

        // Iterador vacío no debería tener siguiente
        assertFalse(iteradorVacio.hasNext());

        // Agregar elementos y verificar que el iterador detecta que hay elementos
        lista.add(new ElementoDiccionario<>(1, "Uno"));
        lista.add(new ElementoDiccionario<>(2, "Dos"));

        IteradorDiccionario<Integer, String> iterador = new IteradorDiccionario<>(lista.getIterador().next(), lista);
        assertTrue(iterador.hasNext());
    }

    /**
     * Prueba el metodo next() verificando que los elementos se recorren en el orden correcto.
     */
    @Test
    void next() {
        ListaDoblementeEnlazada<ElementoDiccionario<Integer, String>> lista = new ListaDoblementeEnlazada<>();

        ElementoDiccionario<Integer, String> e1 = new ElementoDiccionario<>(1, "Uno");
        ElementoDiccionario<Integer, String> e2 = new ElementoDiccionario<>(2, "Dos");
        ElementoDiccionario<Integer, String> e3 = new ElementoDiccionario<>(3, "Tres");

        lista.add(e1);
        lista.add(e2);
        lista.add(e3);

        IteradorDiccionario<Integer, String> iterador = new IteradorDiccionario<>(lista.getIterador().next(), lista);

        // Verificar el recorrido en orden
        assertEquals(e1, iterador.next());

    }

    /**
     * Prueba el méeodo delete() asegurando que elimina correctamente los elementos mientras se itera.
     */
    @Test
    void delete() {
        ListaDoblementeEnlazada<ElementoDiccionario<Integer, String>> lista = new ListaDoblementeEnlazada<>();

        ElementoDiccionario<Integer, String> e1 = new ElementoDiccionario<>(1, "Uno");
        ElementoDiccionario<Integer, String> e2 = new ElementoDiccionario<>(2, "Dos");
        ElementoDiccionario<Integer, String> e3 = new ElementoDiccionario<>(3, "Tres");

        lista.add(e1);
        lista.add(e2);
        lista.add(e3);

        IteradorDiccionario<Integer, String> iterador = new IteradorDiccionario<>(lista.getIterador().next(), lista);

        // Eliminar el primer elemento
        iterador.delete();
        assertEquals(2, lista.getNumElementos());

    }
}