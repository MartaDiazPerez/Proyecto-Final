package Clases;
import EstructurasDeDatos.ListaUnidades;
import Interfaces.IInventario;
import Interfaces.IUnidad;


public class Jugador implements IUnidad {
    private ListaUnidades listaUnidades;
    private String nombre;
    private List<IUnidad> unidades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.listaUnidades = new ListaUnidades();
    }

    @Override
    public int getHP() {
        return 0;
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

    @Override
    public boolean estaViva() {
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public IInventario getInventario() {
        return null;
    }

    public List<IUnidad> getUnidades() {
        return listaUnidades.obtenerTodas();
    }

    public void agregarUnidad(IUnidad unidad) {
        listaUnidades.agregar(unidad);
    }

    public void eliminarUnidad(IUnidad unidad) {
        listaUnidades.eliminar(unidad);
    }

    public boolean tieneUnidadesVivas() {
        return !listaUnidades.obtenerVivas().isEmpty();
    }
}
