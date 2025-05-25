package modelo;

import Clases.Casilla;
import Clases.Unidad;

public class PartidaGuardada {
    private Casilla[][] tablero;
    private Unidad[][] unidades;
    private String turno;

    public PartidaGuardada() {} // Necesario para Gson

    public PartidaGuardada(Casilla[][] tablero, Unidad[][] unidades, String turno) {
        this.tablero = tablero;
        this.unidades = unidades;
        this.turno = turno;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public Unidad[][] getUnidades() {
        return unidades;
    }

    public String getTurno() {
        return turno;
    }
}
