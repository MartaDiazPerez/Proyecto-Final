package EstructurasDeDatos;

public class List<T> {

    //Cada nodo guarda un dato y una referencia al siguiente
    private class Nodo {
        T dato;
        Nodo siguiente;

        Nodo(T dato){
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo primero; //Referencia al primer nodo
    private int tamaño; //Cuántos elementos hay en la lista

    public void añadir(T dato){
        Nodo nuevo = new Nodo(dato);
        if (primero == null){
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    //Devuelve el elemento en la posicion indicada (empezando desde 0)
    public T obtener(int posicion){
        if (posicion < 0 || posicion >= tamaño){
            return null;
        }
        Nodo actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    //Elimina el elemento en la posicion indicada
    public boolean eliminar(int posicion){
        if (posicion < 0 || posicion >= tamaño) {
            return false;
        }
        if (posicion == 0){
            primero = primero.siguiente;
        } else {
            Nodo actual = primero;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        tamaño--;
        return true;
    }

    //Devuelve cuántos elementos hay en la lista
    public int tamaño(){
        return tamaño;
    }

    //Devuelve true si la lista está vacía
    public boolean estaVacia(){
        return tamaño == 0;
    }
}
