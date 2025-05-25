package Interfaces;

import Practicas.ListaSimplementeEnlazada;

public interface IJugador {
    String getNombre();
    ListaSimplementeEnlazada<IUnidad> getUnidades();
    void agregarUnidad(IUnidad unidad);
    void eliminarUnidad(IUnidad unidad);
    boolean tieneUnidadesVivas();

}
