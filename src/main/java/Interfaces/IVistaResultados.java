package Interfaces;

import Practicas.Lista;

public interface IVistaResultados {
    void mostrarLog(Lista<String> log);
    void setControlador(IControladorResultados controlador);
}
