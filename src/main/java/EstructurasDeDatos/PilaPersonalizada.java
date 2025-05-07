package EstructurasDeDatos;

public class PilaPersonalizada {
    private Nodo<T> tope;

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        Nodo(T valor) {
            this.valor = valor;
        }
    }

    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public T desapilar() {
        if (tope == null) return null;
        T valor = tope.valor;
        tope = tope.siguiente;
        return valor;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
