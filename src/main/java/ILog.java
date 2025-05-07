public interface ILog {
    void registrarEvento(String evento);
    List<String> obtenerHistorial();
    void exportarLog(String archivo);
}
