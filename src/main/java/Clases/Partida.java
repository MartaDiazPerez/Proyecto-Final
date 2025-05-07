package Clases;

import EstructurasDeDatos.ColaAcciones;
import EstructurasDeDatos.PilaEventos;
import Interfaces.IJugador;
import Interfaces.IPartida;

class Partida implements IPartida {
    private ColaAcciones colaAcciones;
    private PilaEventos pilaEventos;
    private Queue<IJugador> colaJugadores;
    private IJugador jugadorActual;

    public Partida(List<IJugador> jugadores) {
        this.colaJugadores = new LinkedList<>(jugadores);
        this.jugadorActual = this.colaJugadores.peek();
        this.colaAcciones = new ColaAcciones();
        this.pilaEventos = new PilaEventos();
    }

    public void iniciar() {
        jugadorActual = colaJugadores.peek();
    }

    public void terminar() {
        // lógica de finalización si es necesaria
    }

    public IJugador getJugadorActual() {
        return jugadorActual;
    }

    public void siguienteTurno() {
        IJugador anterior = colaJugadores.poll();
        if (anterior != null && anterior.tieneUnidadesVivas()) {
            colaJugadores.offer(anterior);
        }
        jugadorActual = colaJugadores.peek();
    }

    public boolean esFinDePartida() {
        return colaJugadores.stream().filter(Jugador::tieneUnidadesVivas).count() <= 1;
    }

    public void guardarPartida(String nombreArchivo) {
        // serialización opcional
    }

    public void cargarPartida(String nombreArchivo) {
        // deserialización opcional
    }
}
