package Clases;

import Practicas.Lista;
import Practicas.ListaBasica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IABasicaTest {

    @Test
    void jugarTurno() {
        Tablero tablero = new Tablero(5, 5);
        IABasica ia = new IABasica();

        // Crear unidad controlada por la IA
        Unidad unidadIA = new Unidad(1, 2, 2, 10, 5,  "matematico");
        tablero.ocuparCasilla(2, 2);

        // Crear enemigo a distancia
        Unidad enemigo = new Unidad(5, 4, 2, 10, 3,  "poeta");
        tablero.ocuparCasilla(4, 2);

        ListaBasica<Unidad> enemigos = new ListaBasica<>(5);
        enemigos.add(enemigo);

        // Primer turno: IA debería moverse 1 casilla hacia el enemigo
        ia.jugarTurno(unidadIA, enemigos, tablero);
        assertTrue(unidadIA.getX() == 3 && unidadIA.getY() == 2);

        // Segundo turno: IA debería estar en rango de ataque y atacar
        ia.jugarTurno(unidadIA, enemigos, tablero);
        assertTrue(enemigo.getHp() < 10); // Recibió daño
    }
}