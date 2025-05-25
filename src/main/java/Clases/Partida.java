package Clases;

import Practicas.*;

class Partida{
    private Jugador jugador1;
    private Jugador jugadoriA;
    private Tablero tablero;
    private Cola turnos;
    private int turnoActual;
    private int T; // Intervalo de aparición de nueva unidad

    public Partida(Jugador jugador1, Jugador jugadoriA, int filas, int columnas, int T) {
        this.jugador1 = jugador1;
        this.jugadoriA = jugadoriA;
        this.tablero = new Tablero(filas, columnas);
        this.turnos = new Cola();
        this.T = T;
        this.turnoActual = 0;

        turnos.enqueue(jugador1);
        turnos.enqueue(jugadoriA);
    }

    public void siguienteTurno() {
        turnos.enqueue(turnos.dequeue());
        turnoActual++;

        // Verificación para generar nueva unidad
        if (turnoActual % T == 0) {
            generarUnidadAleatoria(getJugadorActual());
        }
    }

    private void generarUnidadAleatoria(Jugador jugador) {
        // Aquí podrías usar Math.random para elegir una subclase de Unidad
        // y colocarla junto a otra unidad del jugador si hay espacio
        // (queda como punto de implementación específico)
    }

    public boolean verificarVictoria() {
        return !jugador1.tieneUnidades() || !jugadoriA.tieneUnidades();
    }

    public Jugador getGanador() {
        if (!jugador1.tieneUnidades()) return jugadoriA;
        if (!jugadoriA.tieneUnidades()) return jugador1;
        return null;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getTurnoActual() {
        return turnoActual;
    }
    public Jugador getJugadorActual() {
        return (Jugador) turnos.verelemento1();
    }
}
