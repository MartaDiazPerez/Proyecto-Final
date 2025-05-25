package Clases;
import EstructurasDeDatos.ListaUnidades;
import Practicas.Lista;


public class Jugador {
    private ListaUnidades listaUnidades;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.listaUnidades = new ListaUnidades();
    }

    @Override
    public int getHP() {
        return Unidad.getHp();
    }

    @Override
    public int getAtaque() {
        return 0;
    }

    @Override
    public int getDefensa() {
        return 0;
    }

    @Override
    public int getRangoMovimiento() {
        return 0;
    }

    @Override
    public int getRangoAtaque() {
        return 0;
    }

    @Override
    public void recibirDanio(int danio) {

    }

    @Override
    public void mover(int fila, int columna) {

    }



    public String getNombre() {
        return nombre;
    }


//
//    public Lista<IUnidad> getUnidades() {
//        return listaUnidades.obtenerTodas();
//    }
//
//    public void agregarUnidad(IUnidad unidad) {
//        listaUnidades.agregar(unidad);
//    }
//
//    public void eliminarUnidad(IUnidad unidad) {
//        listaUnidades.eliminar(unidad);
//    }
//
//    public boolean tieneUnidadesVivas() {
//        return !listaUnidades.obtenerVivas().isEmpty();
//    }
}
