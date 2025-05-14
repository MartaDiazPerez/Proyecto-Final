package Personajes;

import Clases.Jugador;

public class Poeta extends Unidad {
    public Poeta(Jugador jugador) {
        super(jugador, 60, "Poeta");
    }

    @Override
    public void atacar(Unidad otra, RegistroEventos registro) {
        int daño = 5;
        otra.recibirDanio(daño);
        registro.registrarEvento(nombre + " (Poeta) lanza versos que hieren a " + otra.getNombre() + " con " + daño + " daño lírico.");
        if (otra.getVida() <= 0) {
            otra.getJugador().obtenerUnidades().eliminar(otra);
            registro.registrarEvento("La poesía ha derrotado a " + otra.getNombre());
        }
    }
}
