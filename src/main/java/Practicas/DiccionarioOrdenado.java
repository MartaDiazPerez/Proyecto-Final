package Practicas;
/**
 * Implementación de un diccionario ordenado basado en una lista doblemente enlazada.
 * Almacena pares clave-valor y mantiene el orden de las claves de forma ascendente.
 */
public class DiccionarioOrdenado<K extends Comparable<K>, V> {
    /**Zona de atributos**/
    private ListaDoblementeEnlazada<ElementoDiccionario<K, V>> lista;
    //Constructor que inicializa el diccionario con una lista doblemente enlazada
    public DiccionarioOrdenado() {
        lista = new ListaDoblementeEnlazada<>();
    }
    /**Zona de metodos**/
    //Inserta un nuevo par clave-valor en el diccionario, manteniendo el orden.
    // Si la clave ya existe, su valor se actualiza.
    public void put(K clave, V valor) {
        // Buscamos la posición donde insertar el nuevo elemento manteniendo el orden
        ElementoDiccionario<K, V> actual = lista.getIterador().next();
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor;  // Si la clave ya existe, actualizamos el valor
                return;
            }
            if (actual.clave.compareTo(clave) > 0) {
                // Insertamos el nuevo elemento en el lugar correspondiente
                ElementoDiccionario<K, V> nuevo = new ElementoDiccionario<>(clave, valor);
                if (actual.anterior != null) {
                    actual.anterior.siguiente = nuevo;
                } else {
                    lista.add(nuevo);  // Es el primer elemento
                }
                nuevo.anterior = actual.anterior;
                nuevo.siguiente = actual;
                actual.anterior = nuevo;
                return;
            }
            actual = actual.siguiente;
        }
        // Si la clave es mayor que todas, lo insertamos al final
        lista.add(new ElementoDiccionario<>(clave, valor));
    }
    //Obtiene el valor asociado a una clave dada.
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
    //Elimina un elemento del diccionario dado su clave.
    public boolean remove(K clave) {
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
    //Devuelve el número de elementos almacenados en el diccionario.
    public int size() {
        return lista.getNumElementos();
    }
}