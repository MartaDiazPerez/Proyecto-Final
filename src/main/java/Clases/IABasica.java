package Clases;

import Practicas.Lista;

public class IABasica {
    public void jugarTurno(Unidad ia, Lista<Unidad> enemigos, Tablero tablero) {
        // Primero busca al enemigo más cercano
        Unidad objetivo = encontrarEnemigoMasCercano(ia, enemigos);
        if (objetivo == null) return;

        int dx = Math.abs(ia.getX() - objetivo.getX());
        int dy = Math.abs(ia.getY() - objetivo.getY());

        //Después comprueba si el enemigo está en su rango si es asi ataca
        if (dx + dy <= ia.getRangoAtaque()) {
            int factor = (int)(Math.random() * 3); // 0,1,2
            int daño = factor * ia.getAtaque() - objetivo.getDefensa();
            if (daño < 0) daño = 0;
            objetivo.recibirDanio(daño);
            System.out.println(ia.getNombre() + " ataca a " + objetivo.getNombre() + " causando " + daño + " de daño.");
            return;
        }

        // se mueve una casilla hacia el enemigo en caso de que esa casilla este libre
        int nuevoX = ia.getX();
        int nuevoY = ia.getY();

        if (ia.getX() < objetivo.getX()) nuevoX++;
        else if (ia.getX() > objetivo.getX()) nuevoX--;

        if (ia.getY() < objetivo.getY()) nuevoY++;
        else if (ia.getY() > objetivo.getY()) nuevoY--;

        if (tablero.esPosicionValida(nuevoX, nuevoY) && !tablero.getCasilla(nuevoX, nuevoY).estaOcupada()) {
            tablero.desocuparCasilla(ia.getX(), ia.getY());
            tablero.ocuparCasilla(nuevoX, nuevoY);
            ia.setPosicion(nuevoX, nuevoY);
            System.out.println(ia.getNombre() + " se mueve a (" + nuevoX + "," + nuevoY + ")");
        }
    }

    private Unidad encontrarEnemigoMasCercano(Unidad ia, Lista<Unidad> enemigos) {
        Unidad masCercano = null;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < enemigos.getNumElementos(); i++) {
            Unidad enemigo = enemigos.get(i);
            if (enemigo.getHp() <= 0) continue;
            int distancia = Math.abs(ia.getX() - enemigo.getX()) + Math.abs(ia.getY() - enemigo.getY());
            if (distancia < minDist) {
                minDist = distancia;
                masCercano = enemigo;
            }
        }

        return masCercano;
    }
}
