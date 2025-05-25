package Practicas;

public class Arista {
    public NodoGrafo destino;
    public int peso;

    public Arista(NodoGrafo destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}
