package Practicas;

/**Clase IteradorListaSimplementeEnlazada que implementa un iterador que nos permite recorrer la
 * lista simplemente enlazada */

public class IteradorListaSimplementeEnlazada<T> implements Iterador<T> {
    /**ATRIBUTOS*/
    private Elemento<T> actual;//Hace referencia al elemento actual que marca el iterador
    private Elemento<T> previo;//Hace referencia al elemento previo al actual que marca el iterador

    /**MÉTODOS*/
    /** Metodo que incializa la posición del iterador en la cabeza de la lista */
    public IteradorListaSimplementeEnlazada(Elemento<T> cabeza) {
        this.actual = cabeza;
        this.previo = null;
    }
    /**Metodo que comprueba si hay un nodo siguiente en la lista, si lo hay devuelve true
     * y si no lo hay devuelve false */
    @Override
    public boolean hasNext() {
        return actual != null;
    }
    /**Metodo que avanza al siguiente nodo de la lista y devuelve el dato al que apunta el iterador, en el
     * caso de no haber siguiente dato devuelve falso*/
    @Override
    public T next() {
        if (actual != null) { //Comprueba que el nodo no sea nulo
            T dato = actual.dato; //Guarda el dato en el nodo actual
            previo = actual; //Guarda el nodo actual antes de avanzar
            actual = actual.siguiente; //Avanza al siguiente nodo de la lista
            return dato; //Devuelve el dato
        }
        return null; //En caso de estar vacío el nulo actual, devuelve nulo
    }
    /**Metodo que elimina el último elemento retornado por la función next*/
    @Override
    public void delete() {
        if (actual == null) {//En caso de estar nulo el nodo entonces, no se elimina nada
            return;
        }
        if (previo != null) { //En caso de haber nodo previo
            previo.siguiente = actual.siguiente;//Pasa del previo nodo al siguiente
            actual = actual.siguiente; //Avanza al siguiente nodo
        } else {
            actual = actual.siguiente;//En caso de no haber nodo previo, avanza al siguiente nodo
        }
    }
}
