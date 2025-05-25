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

    private VBox contenedorArchivos;
    private String archivoSeleccionado = null;

    public Scene getScene() {
        GuardadoUtils.asegurarDirectorioPartidas(); // Crea carpeta si no existe

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
        Button btnVolver = new Button("Volver al Menú");

        btnCargar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                String ruta = "partidas/" + archivoSeleccionado.replace(".json", "");
                PartidaGuardada partida = GuardadoUtils.cargarPartidaDesdeJson(ruta);
                if (partida != null) {
                    PantallaManager.mostrarPartidaCargada(partida);
                } else {
                    mostrarAlerta("No se pudo cargar la partida seleccionada.");
                }
            } else {
                mostrarAlerta("Selecciona una partida antes de cargar.");
            }
        });

        btnBorrar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                File archivo = new File("partidas/" + archivoSeleccionado);
                if (archivo.exists()) {
                    archivo.delete();
                    archivoSeleccionado = null;
                    actualizarLista(buscador.getText());
                }
            } else {
                mostrarAlerta("Selecciona una partida antes de borrar.");
            }
        });

        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        layout.getChildren().addAll(lblTitulo, buscador, contenedorArchivos, btnCargar, btnBorrar, btnVolver);

        actualizarLista(""); // Mostrar todas al inicio

        return new Scene(layout, 600, 500);
    }

    private void actualizarLista(String filtro) {
        contenedorArchivos.getChildren().clear();

        File carpeta = new File("partidas");
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".json"));

        if (archivos != null && archivos.length > 0) {
            ToggleGroup grupo = new ToggleGroup();

            for (File archivo : archivos) {
                String nombre = archivo.getName();
                if (nombre.toLowerCase().contains(filtro.toLowerCase())) {
                    RadioButton rb = new RadioButton(nombre);
                    rb.setToggleGroup(grupo);
                    rb.setOnAction(e -> archivoSeleccionado = nombre);
                    contenedorArchivos.getChildren().add(rb);
                }
            }

            if (contenedorArchivos.getChildren().isEmpty()) {
                contenedorArchivos.getChildren().add(new Label("No hay coincidencias."));
            }
        } else {
            contenedorArchivos.getChildren().add(new Label("No hay partidas guardadas."));
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public static void main(String[] args) {;
    }
}
