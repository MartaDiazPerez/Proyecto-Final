package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String NOMBRE_ARCHIVO_LOG = "movimientos_juego.log";

    public static void escribirLog(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_LOG, true))) {
            String linea = "[" + java.time.LocalDateTime.now() + "] " + mensaje;
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error escribiendo log: " + e.getMessage());
        }
    }
}
