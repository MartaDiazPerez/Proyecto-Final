package modelo;

import Clases.Casilla;

public class TableroPersonalizado {
    private Casilla[][] casillas;

    public TableroPersonalizado(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}
