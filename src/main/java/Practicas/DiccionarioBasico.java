package Practicas;

public class DiccionarioBasico<K, V> implements Diccionario<K, V> {
    private ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista;

    public DiccionarioBasico() {
        lista = new ListaDoblementeEnlazada<>();
    }

    public boolean add(K clave, V valor) {
        // Verificamos si la clave ya existe
        ElementoDiccionario<K, V> actual = lista.getIterador().next();
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor;  // Si existe, actualizamos el valor
                return true;
            }
            actual = actual.siguiente;
        }
        // Si no existe, añadimos un nuevo elemento
        lista.add(new ElementoDiccionario<>(clave, valor));
        return true;
    }

    public V get(K clave) {
        ElementoDiccionario<K, V> actual = lista.getIterador().next();
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;  // No se encontró el valor
    }
    public boolean exists(K clave) {
        return get(clave) != null;
    }
    public Iterador<ElementoDiccionario<K, V>> getIterator() {
        return new IteradorDiccionario<K,V>(lista.cabeza.dato,this.lista);
    }

    public boolean delete(K clave) {
        ElementoDiccionario<K, V> actual = lista.getIterador().next();
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                lista.delete(actual);  // Eliminamos el elemento
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public Iterador<ElementoDiccionario<K, V>> getIterador() {
        return new IteradorDiccionario<>(lista.cabeza.dato,this.lista);
    }

    public int getNumElementos() {
        return lista.getNumElementos();
    }
}