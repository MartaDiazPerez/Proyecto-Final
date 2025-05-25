package Practicas;

/**Definimos la clase ElementoDoble<T> para representar un nodo en la lista*/
public class ElementoDoble<T> {
    T dato; //Valor almacenado en el nodo
    ElementoDoble<T> siguiente; //Referencia al siguiente nodo
    ElementoDoble<T> anterior; //Referencia al nodo anterior

    /**Constructor para inicializar un nodo con su valor*/
    public ElementoDoble(T dato){
        this.dato = dato;
        siguiente = null;
        anterior = null;
    }
}
