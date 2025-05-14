package Personajes;

import Clases.Jugador;

public class Matematico extends Unidad {
    public Matematico(Jugador jugador) {
        super(jugador, 80, "Matemático");
    }

    @Override
    public void atacar(Unidad otra, RegistroEventos registro) {
        int daño = (int)(Math.random() * 20); // Daño aleatorio entre 0 y 20
        otra.recibirDanio(daño);
        registro.registrarEvento(nombre + " (Matemático) calcula un ataque de " + daño + " a " + otra.getNombre());
        if (otra.getVida() <= 0) {
            otra.getJugador().obtenerUnidades().eliminar(otra);
            registro.registrarEvento(otra.getNombre() + " eliminado por cálculo preciso.");
        }
    }
}
