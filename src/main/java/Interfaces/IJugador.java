package Interfaces;

public interface IJugador {
    String getNombre();
    List<IUnidad> getUnidades();
    void agregarUnidad(IUnidad unidad);
    void eliminarUnidad(IUnidad unidad);
    boolean tieneUnidadesVivas();

}
