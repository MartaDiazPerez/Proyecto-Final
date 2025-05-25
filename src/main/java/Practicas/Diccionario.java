package Practicas;

public interface Diccionario<K,V> {
    boolean add(K clave, V valor);
    V get(K clave);
    boolean delete(K clave);
    boolean exists(K clave);
    int getNumElementos();
    Iterador<ElementoDiccionario<K,V>> getIterador();
}
