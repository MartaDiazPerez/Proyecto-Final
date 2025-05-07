package EstructurasDeDatos;

public class ColaAcciones {
    // Cola de acciones para procesamiento por turno
    class ColaAcciones {
        private Queue<String> acciones;

        public ColaAcciones() {
            acciones = new LinkedList<>();
        }

        public void encolar(String accion) {
            acciones.offer(accion);
        }

        public String desencolar() {
            return acciones.poll();
        }

        public boolean estaVacia() {
            return acciones.isEmpty();
        }
    }

}
