package Practicas;
/**
 * Implementación de un iterador para recorrer los elementos de un diccionario basado en una lista doblemente enlazada.
 */
public class IteradorDiccionario<K, V> implements Iterador<ElementoDiccionario<K, V>> {
    /**Zona de atributos**/
    private ElementoDiccionario<K, V> actual;
    private ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista;
    /**Zona de metodos**/
    //Constructor del iterador, inicializado con la cabeza de la lista y la referencia a la lista completa.
    public IteradorDiccionario(ElementoDiccionario<K, V> cabeza, ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista) {
        this.actual = cabeza;
        this.lista = lista;  // Guardamos la referencia a la lista
    }
    //Verifica si hay más elementos en el diccionario.
    @Override
    public boolean hasNext() {
        return actual != null;
    }
    //Retorna el siguiente elemento del diccionario y avanza el iterador.
    @Override
    public ElementoDiccionario<K, V> next() {
        if (!hasNext()) {
            return null;
        }
        ElementoDiccionario<K, V> elemento = actual;
        actual = actual.siguiente;
        return elemento;
    }
    //Elimina el elemento actual del diccionario y avanza al siguiente.
    //Si el elemento actual es nulo, no se realiza ninguna acción.
    @Override
    public void delete() {
        if (actual != null) {
            // Llamamos al metodo delete() de la lista para eliminar el elemento actual
            lista.delete(actual);
            actual = actual.siguiente;  // Mover al siguiente elemento después de eliminar
        }
    }
}

