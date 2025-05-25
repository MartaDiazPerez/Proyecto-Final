package Practicas;

public class Posicion {
    public int x, y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) return false;
        Posicion otra = (Posicion) obj;
        return this.x == otra.x && this.y == otra.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
