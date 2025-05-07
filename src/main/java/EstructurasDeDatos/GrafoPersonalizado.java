package EstructurasDeDatos;

public class GrafoPersonalizado {
    private ListaPersonalizada<NodoGrafo<T>> nodos = new ListaPersonalizada<>();

    public static class NodoGrafo<T> {
        T valor;
        ListaPersonalizada<Arista<T>> adyacentes = new ListaPersonalizada<>();

        public NodoGrafo(T valor) {
            this.valor = valor;
        }
    }

    public static class Arista<T> {
        NodoGrafo<T> destino;
        int peso;

        public Arista(NodoGrafo<T> destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public NodoGrafo<T> agregarNodo(T valor) {
        NodoGrafo<T> nodo = new NodoGrafo<>(valor);
        nodos.agregar(nodo);
        return nodo;
    }

    public void conectar(NodoGrafo<T> origen, NodoGrafo<T> destino, int peso) {
        origen.adyacentes.agregar(new Arista<>(destino, peso));
    }

    public ListaPersonalizada<NodoGrafo<T>> obtenerNodos() {
        return nodos;
    }
}
