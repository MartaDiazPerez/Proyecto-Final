package Practicas;
/**Creamos la clase elemento cuya función es representar un nodo en la estructura de la lista
 * simplemente enlazada */
public class Elemento <T>{
    /**ATRIBUTOS*/

    T dato; //Hace referencia al dato almacenado en el nodo
    Elemento <T> siguiente; //Hace referencia al siguiente elemento de la lista simplemente enlazada

    /**MÉTODOS*/

    /**Constructor de la clase Elemento que inicializa la lista con el dato proporcionado y
     * el siguiente elemento es nulo*/
    public Elemento (T dato){
        this.dato = dato;
        this.siguiente = null;
    }

}
