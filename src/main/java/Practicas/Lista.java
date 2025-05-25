package Practicas;

/**
 * Interfaz Lista<T> que define las operaciones básicas de una lista.
 * @param <T> Tipo de dato genérico.
 */
public interface Lista<T> {

    /**
     * Agrega un elemento a la lista.
     * @param elemento Elemento a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    boolean add(T elemento);

    /**
     * Elimina un elemento de la lista.
     * @param elemento Elemento a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    boolean delete(T elemento);

    /**
     * Obtiene un iterador para recorrer la lista.
     * @return Un iterador de tipo T.
     */
    Iterador<T> getIterador();

    /**
     * Retorna el número de elementos en la lista.
     * @return Cantidad de elementos en la lista.
     */
    int getNumElementos();

}
