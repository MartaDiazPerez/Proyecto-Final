package Interfaces;

import Practicas.Lista;

public interface ILog {
    void registrarEvento(String evento);
    Lista<String> obtenerHistorial();
    void exportarLog(String archivo);
}
