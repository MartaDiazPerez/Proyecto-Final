package Practicas;

public class Cola<T> {
    //Declaro una ListaSE como base de la cola (FIFO)
    private ListaSimplementeEnlazada<T> lista;
    //creo una listaSE vacia para el constructor de la cola
    public Cola() {
        lista = new ListaSimplementeEnlazada<T>(0, null);
    }
    //este metodo agrega elementos al final de la lista, es decir, al final
    //de la cola con el metodo add de las listasSE
    public void enqueue(T elemento) {
        lista.add(elemento);
    }

    //este metodo saca el ultimo elemento de la cola distinguiendo el caso de
    //la cola vacia --> no devuelvo nada
    //el caso de la cola con elementos --> guardando en elemento el ultimo elemento
    //de la cola para luego eliminarlo y devolverlo
    public T dequeue() {
        if (lista.getNumElementos() == 0) {
            return null;
        }
        T elemento = (T) lista.getCabeza(); // Obtener el primer elemento
        lista.delete(elemento); // Eliminarlo
        return elemento;
    }
    //me devuelve si la cola esta vacia comprobando si la lista por la
    //que esta formada la cola esta vacia o no, esto lo hago mirando
    //el numero de elementos de la lista, si es igual a 0 me devuelve
    //True y si es distinto de 0 me devuelve False
    public boolean isEmpty() {
        return lista.getNumElementos() == 0;
    }

    public T verelemento1() {
        if (lista.getCabeza() == null) {
            return null;
        }
        return (T) lista.getCabeza();
    }

}
