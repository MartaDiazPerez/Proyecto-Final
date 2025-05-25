package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.PartidaGuardada;
import modelo.TableroPersonalizado;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GuardadoUtils {

    public static void asegurarDirectorioPartidas() {
        File carpeta = new File("partidas");
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdir();
            if (creada) {
                System.out.println("📁 Carpeta 'partidas' creada.");
            }
        }
    }

    public static void asegurarDirectorioTableros() {
        File carpeta = new File("tableros");
        if (!carpeta.exists()) {
            boolean creada = carpeta.mkdir();
            if (creada) {
                System.out.println("📁 Carpeta 'tableros' creada.");
            }
        }
    }

    public static PartidaGuardada cargarPartidaDesdeJson(String nombreArchivoSinExtension) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(nombreArchivoSinExtension + ".json")) {
            return gson.fromJson(reader, PartidaGuardada.class);
        } catch (IOException e) {
            System.err.println("❌ Error al cargar la partida: " + e.getMessage());
            return null;
        }
    }

    public static TableroPersonalizado cargarTableroDesdeJson(String nombreArchivoSinExtension) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(nombreArchivoSinExtension + ".json")) {
            return gson.fromJson(reader, TableroPersonalizado.class);
        } catch (IOException e) {
            System.err.println("❌ Error al cargar el tablero: " + e.getMessage());
            return null;
        }
    }
}