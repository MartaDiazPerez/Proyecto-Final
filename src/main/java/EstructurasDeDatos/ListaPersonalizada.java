package EstructurasDeDatos;

public class ListaPersonalizada {
    private Nodo<T> cabeza;
    private int tamaño;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int obtenerTamaño() {
        return tamaño;
    }

    public T obtener(int indice) {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(T valor) {
        if (cabeza == null) return;

        if (cabeza.valor.equals(valor)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.valor.equals(valor)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamaño--;
        }
    }

    public boolean contiene(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.valor.equals(valor)) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}
