package Clases;
import Practicas.Lista;
import Practicas.ListaSimplementeEnlazada;


public class Jugador {
    private String nombre;
    private ListaSimplementeEnlazada unidades;
    private boolean esIA;

    public Jugador(String nombre, boolean esIA) {
        this.nombre = nombre;
        this.unidades = new ListaSimplementeEnlazada(1000, null);
        this.esIA = esIA;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esIA() {
        return esIA;
    }

    public ListaSimplementeEnlazada getUnidades() {
        return unidades;
    }

    public void agregarUnidad(Unidad unidad) {
        unidades.add(unidad);
    }

    public void eliminarUnidad(Unidad unidad) {
        unidades.delete(unidad);
    }

    public boolean tieneUnidades() {
        return !unidades.estaVacia();
    }

}
