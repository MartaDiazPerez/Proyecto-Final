package Personajes;

import Clases.Jugador;

public class Ingeniero extends Unidad {
    public Ingeniero(Jugador jugador) {
        super(jugador, 100, "Ingeniero");
    }

    @Override
    public void atacar(Unidad otra, RegistroEventos registro) {
        otra.recibirDanio(15); // Más daño que el estándar
        registro.registrarEvento(nombre + " (Ingeniero) ataca con herramientas a " + otra.getNombre());
        if (otra.getVida() <= 0) {
            otra.getJugador().obtenerUnidades().eliminar(otra);
            registro.registrarEvento(otra.getNombre() + " ha sido destruido por un Ingeniero.");
        }
    }
}
