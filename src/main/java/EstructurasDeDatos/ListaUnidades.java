package EstructurasDeDatos;

public class ListaUnidades {
    // Lista de unidades por jugador
    class ListaUnidades {
        private List<IUnidad> unidades;

        public ListaUnidades() {
            unidades = new ArrayList<>();
        }

        public void agregar(IUnidad unidad) {
            unidades.add(unidad);
        }

        public void eliminar(IUnidad unidad) {
            unidades.remove(unidad);
        }

        public List<IUnidad> obtenerTodas() {
            return unidades;
        }

        public List<IUnidad> obtenerVivas() {
            return unidades.stream().filter(IUnidad::estaViva).toList();
        }
    }

}
