package Practicas;

/** Implementación de un iterador para una lista doblemente enlazada */
class IteradorListaDoblementeEnlazada<T> implements Iterador<T> {
    /**Zona de atributos**/
    private ElementoDoble<T> actual;
    private ElementoDoble<T> previo;
    //Constructor que inicializa el iterador en la posición de inicio de la lista.
    public IteradorListaDoblementeEnlazada(ElementoDoble<T> inicio) {
        this.actual = inicio;
        this.previo = null;
    }
    /**Zona de metodos**/
    //Verifica si hay más elementos en la lista.
    @Override
    public boolean hasNext() {
        return actual != null;
    }
    //Retorna el siguiente elemento en la iteración y avanza el iterador.
    @Override
    public T next() {
        if (actual != null) {
            previo = actual;
            actual = actual.siguiente;
            return previo.dato;
        }
        return null;
    }
    //Elimina el último elemento retornado
    @Override
    public void delete() {
        if (previo == null) {
            return;// No hay elemento previo que eliminar
        }
        // Conectamos el nodo anterior al nodo siguiente, eliminando "previo" de la lista
        if (previo.anterior != null) {
            previo.anterior.siguiente = actual;
        }
        // Conectamos el nodo siguiente al nodo anterior
        if (actual != null) {
            actual.anterior = previo.anterior;
        }
        // Movemos el puntero "previo" al anterior, para continuar la iteración correctamente
        previo = previo.anterior;
    }
}

