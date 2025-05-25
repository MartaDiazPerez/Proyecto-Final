package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modelo.GuardadoUtils;
import modelo.PartidaGuardada;

import java.io.File;

public class PantallaJugarAnterior {

    String archivo = "partida_guardada"; // nombre del archivo sin .json
    PartidaGuardada partida = GuardadoUtils.cargarPartidaDesdeJson(archivo);
    if (partida != null) {
        PantallaManager.mostrarPartidaCargada(partida);
    }

    private VBox contenedorArchivos;
    private String archivoSeleccionado = null;

    public Scene getScene() {
        GuardadoUtils.asegurarDirectorioPartidas();

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("📂 Partidas Guardadas");

        TextField buscador = new TextField();
        buscador.setPromptText("Buscar por nombre...");

        contenedorArchivos = new VBox(5);
        contenedorArchivos.setAlignment(Pos.CENTER);

        buscador.textProperty().addListener((obs, oldVal, newVal) -> actualizarLista(newVal));

        Button btnCargar = new Button("Cargar Partida");
        Button btnBorrar = new Button("Borrar Partida");
        Button btnVolver = new Button("Volver");

        btnCargar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                String ruta = "partidas/" + archivoSeleccionado.replace(".json", "");
                PartidaGuardada partida = GuardadoUtils.cargarPartidaDesdeJson(ruta);
                if (partida != null) {
                    PantallaManager.mostrarPartidaCargada(partida);
                }
            }
        });

        btnBorrar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                File archivo = new File("partidas/" + archivoSeleccionado);
                if (archivo.exists()) {
                    archivo.delete();
                    System.out.println("🗑️ Partida eliminada: " + archivoSeleccionado);
                    actualizarLista(buscador.getText());
                    archivoSeleccionado = null;
                }
            }
        });

        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        layout.getChildren().addAll(lblTitulo, buscador, contenedorArchivos, btnCargar, btnBorrar, btnVolver);

        actualizarLista(""); // mostrar todos al inicio

        return new Scene(layout, 600, 500);
    }

    private void actualizarLista(String filtro) {
        contenedorArchivos.getChildren().clear();

        File carpeta = new File("partidas");
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".json"));

        if (archivos != null) {
            ToggleGroup grupo = new ToggleGroup();

            for (int i = 0; i < archivos.length; i++) {
                String nombre = archivos[i].getName();
                if (nombre.toLowerCase().contains(filtro.toLowerCase())) {
                    RadioButton rb = new RadioButton(nombre);
                    rb.setToggleGroup(grupo);
                    rb.setOnAction(e -> archivoSeleccionado = nombre);
                    contenedorArchivos.getChildren().add(rb);
                }
            }

            if (contenedorArchivos.getChildren().isEmpty()) {
                Label lbl = new Label("⚠️ No se encontraron partidas.");
                contenedorArchivos.getChildren().add(lbl);
            }
        }
    }
}
