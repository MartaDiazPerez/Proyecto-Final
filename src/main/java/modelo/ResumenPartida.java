package modelo;

public class ResumenPartida {
    private int turnosTotales;
    private int eliminadasCiencias;
    private int eliminadasLetras;

    public ResumenPartida(int turnosTotales, int eliminadasCiencias, int eliminadasLetras) {
        this.turnosTotales = turnosTotales;
        this.eliminadasCiencias = eliminadasCiencias;
        this.eliminadasLetras = eliminadasLetras;
    }

    public int getTurnosTotales() {
        return turnosTotales;
    }

    public int getEliminadasCiencias() {
        return eliminadasCiencias;
    }

    public int getEliminadasLetras() {
        return eliminadasLetras;
    }
}
