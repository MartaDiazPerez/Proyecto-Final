package Practicas;


/**Se implementa una clase de la lista simplemente enlazada donde se
 * implementa la interfaz Lista<T> */
public class ListaSimplementeEnlazada <T> implements Lista<T> {
    /**ATRIBUTOS*/
    private Elemento <T> cabeza;
    private int numElementos = 0;

    /**METODOS*/
    /**Metodo que inicializa la clase con los atributos designados*/
    public ListaSimplementeEnlazada(int numElementos, Elemento <T> cabeza) {
        this.cabeza = null;
        this.numElementos = 0;
    }
    /**Metodo que agrega un elemento a la lista simplemente enlazada*/
    @Override
    public boolean add(T elemento) {
        //Creamos un nodo con el elemento recibido
        Elemento<T> nuevo = new Elemento<>(elemento);
        if (cabeza == null) { //En caso de estar la lista vacía, entonces el nodo
            //es la nueva cabeza de la lista
            cabeza = nuevo;
        } else { //En caso de no estar vacía se recorre la lista hasta el último nodo vacío
            Elemento <T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo; //El nuevo nodo se añade al final de la lista
        }
        numElementos++;//Como hemos añadido un nodo nuevo, entonces, añadimos uno al contador
        return true; //Devuelve true para saber que el proceso es correcto
    }
    /**Metodo para eliminar un elemento de la lista*/
    @Override
    public boolean delete(T elemento) { //En caso de estar la lista vacía, entonces se devuelve
        //un false porque no hay nada que eliminar de la lista
        if (cabeza == null) return false;

        if (cabeza.dato.equals(elemento)) { //en caso de que sea la cabeza el elemento a eliminar
            cabeza = cabeza.siguiente;//se mueve la cabeza al siguiente nodo
            numElementos--; //se elimina en uno el valor del contador
            return true; // devuelve true para que se compruebe que el proceso ha sido correcto
        }

        //creamos una referencia para recorrer la lista y se busca el nodo anterior que queremos eliminar
        Elemento<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(elemento)) {
            actual = actual.siguiente;
        }
        //En caso de encontrar el nodo que queremos eliminar:
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente; //unimos el nodo anterior al siguiente
            numElementos--; //decrementa en uno el valor del contador
            return true; //devolvemos un true para saber que el proceso es correcto
        }
        return false; //devuelve falso en caso de no encontrar el elemento en la lista
    }

    /**Metodo para obtener un iterador y que devuelva una instancia para recorrer la lista desde la cabeza al fin*/
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaSimplementeEnlazada<>(cabeza);
    }

    /**Metodo que devuelve el número de elementos de la lista, es decir, el contador que hemos ido
     * incrementando o decrementando */
    @Override
    public int getNumElementos() {
        return numElementos;
    }

    /**Metodo que me devuelve el elemento de la cabeza de la lista**/
    public Elemento<T> getCabeza() {
        return cabeza;
    }

    /**Comprueba si la lista esta vacia*/
    public boolean estaVacia() {
        return numElementos == 0;
    }


}
