package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.PartidaGuardada;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import modelo.TableroPersonalizado;

public class GuardadoUtils {

    public static PartidaGuardada cargarPartidaDesdeJson(String nombreArchivo) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(nombreArchivo + ".json")) {
            PartidaGuardada partida = gson.fromJson(reader, PartidaGuardada.class);
            System.out.println("✅ Partida cargada desde " + nombreArchivo + ".json");
            return partida;
        } catch (IOException e) {
            System.err.println("❌ Error al cargar la partida: " + e.getMessage());
            return null;
        }
    }

    public static void asegurarDirectorioTableros() {
        File dir = new File("tableros");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("📁 Carpeta 'tableros' creada.");
        }
    }
}