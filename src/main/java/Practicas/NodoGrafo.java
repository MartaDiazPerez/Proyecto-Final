package Practicas;

public class NodoGrafo {
    public Posicion posicion;
    public ListaBasica<Arista> adyacentes;

    public NodoGrafo(Posicion posicion) {
        this.posicion = posicion;
        this.adyacentes = new ListaBasica<>(20); // o tamaño dinámico si usas ListaDoblementeEnlazada
    }

    public void agregarAdyacente(NodoGrafo destino, int peso) {
        this.adyacentes.add(new Arista(destino, peso));
    }
}
