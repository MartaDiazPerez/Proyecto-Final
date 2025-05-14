package Personajes;

public class Filologo extends Unidad {
    public Filologo(Jugador jugador) {
        super(jugador, 90, "Filólogo");
    }

    @Override
    public void atacar(Unidad otra, RegistroEventos registro) {
        otra.recibirDanio(10);
        registro.registrarEvento(nombre + " (Filólogo) critica el lenguaje de " + otra.getNombre());
        if (otra.getVida() <= 0) {
            otra.getJugador().obtenerUnidades().eliminar(otra);
            registro.registrarEvento("Filólogo deja sin argumentos a " + otra.getNombre());
        }
    }
}
