package Practicas;

/** Implementación de una lista doblemente enlazada **/
class ListaDoblementeEnlazada<T> implements Lista<T> {
    /**Zona de atributos**/
    //Primer nodo de la lista (inicio de la secuencia de elementos).
    public ElementoDoble<T> cabeza;
    //Último nodo de la lista (final de la secuencia de elementos).
    private ElementoDoble<T> cola;
    //Contador que almacena el número de elementos en la lista.
    private int numElementos;
    //Constructor que inicializa una lista vacía.
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.numElementos = 0;
    }

    /**Zona de metodos**/
    //Agrega un nuevo elemento al final de la lista.
    @Override
    public boolean add(T elemento) {
        ElementoDoble<T> nuevo = new ElementoDoble<>(elemento);
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo se convierte en cabeza y cola
            cabeza = cola = nuevo;
        } else {
            // Se enlaza el nuevo nodo al final de la lista
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        numElementos++;
        return true;
    }
    //Elimina la primera ocurrencia de un elemento en la lista.
    @Override
    public boolean delete(T elemento) {
        ElementoDoble<T> actual = cabeza;
        // Se recorre la lista en busca del elemento
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                // Se ajustan las referencias de los nodos para eliminar el elemento
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    // Si se elimina el primer elemento, se actualiza la cabeza
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    // Si se elimina el último elemento, se actualiza la cola
                    cola = actual.anterior;
                }
                numElementos--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    //Obtiene un iterador para recorrer la lista desde el primer elemento.
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDoblementeEnlazada<>(cabeza);
    }
    //Devuelve la cantidad de elementos en la lista.
    @Override
    public int getNumElementos() {
        return numElementos;
    }
}
