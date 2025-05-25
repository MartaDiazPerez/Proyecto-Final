package Practicas;

public class Pila<T> {
    //uso una listaSE(simplemente enlazada) como base para la Pila
    protected ListaSimplementeEnlazada<T> lista;
    //creo el constructor Pila con una listaSE vacia
    public Pila() {
        lista = new ListaSimplementeEnlazada<>(0, null);
    }
    //Este metodo sirve para agregar al inicio de la lista(arriba de la pila)
    public void push(T elemento) {
        lista.add(elemento);
    }
    //Este metodo sirve para eliminar elementos de la lista, lo hace
    //de la pila (LIFO), es decir, al principio de la listaSE
    public T pop() {
        //primero miro si la lista esta llena o vacia:
        //si la lista esta vacia, no devuelvo nada
        if (lista.getNumElementos() == 0) {
           return null;
        }
        //si la lista esta llena guardo en elemento el primer elemento de la listaSE
        //y luego lo borro
        T elemento = (T) lista.getCabeza();
        lista.delete(elemento);
        return elemento ;
    }
    //me devuelve si la pila esta vacia comprobando si la lista por la
    //que esta formada la pila esta vacia o no, esto lo hago mirando
    //el numero de elementos de la lista, si es igual a 0 me devuelve
    //True y si es distinto de 0 me devuelve False
    public boolean isEmpty() {
        return lista.getNumElementos() == 0;
    }

}
