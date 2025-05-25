package Practicas;

/** Define métodos para recorrer una lista de forma secuencial y manipular la lista*/
interface Iterador<T> {

    /** Verifica si hay más elementos en la lista*/
    boolean hasNext();

    /** Retorna el siguiente elemento de la lista*/
    T next();

    /** Elimina el último elemento retornado por next*/
    void delete();
}
