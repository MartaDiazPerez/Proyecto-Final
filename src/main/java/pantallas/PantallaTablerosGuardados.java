package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import modelo.GuardadoUtils;
import modelo.TableroPersonalizado;
import modelo.GuardadoUtils;
import Practicas.ListaBasica;

import java.io.File;

public class PantallaTablerosGuardados {

    private VBox contenedorLista; // contendrá botones dinámicos
    private String archivoSeleccionado = null;

    public Scene getScene() {
        GuardadoUtils GuardadoUtils;
        GuardadoUtils.asegurarDirectorioTableros();

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label(" Tableros Guardados");

        TextField buscador = new TextField();
        buscador.setPromptText("Buscar por nombre...");

        contenedorLista = new VBox(5);
        contenedorLista.setAlignment(Pos.CENTER);

        buscador.textProperty().addListener((obs, oldVal, newVal) -> mostrarArchivosFiltrados(newVal));

        Button btnCargar = new Button("Usar Tablero");
        Button btnBorrar = new Button("Borrar Tablero");
        Button btnVolver = new Button("Volver");

        btnCargar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                TableroPersonalizado t = GuardadoUtils.cargarTableroDesdeJson("tableros/" + archivoSeleccionado.replace(".json", ""));
                if (t != null) {
                    PantallaManager.mostrarPantallaEleccionPersonajesDesdeTablero(t.getCasillas());
                }
            }
        });

        btnBorrar.setOnAction(e -> {
            if (archivoSeleccionado != null) {
                File archivo = new File("tableros/" + archivoSeleccionado);
                if (archivo.exists()) {
                    archivo.delete();
                    mostrarArchivosFiltrados(buscador.getText());
                    archivoSeleccionado = null;
                }
            }
        });

        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaEleccionTablero());

        layout.getChildren().addAll(lblTitulo, buscador, contenedorLista, btnCargar, btnBorrar, btnVolver);

        mostrarArchivosFiltrados(""); // inicial

        return new Scene(layout, 600, 500);
    }

    private void mostrarArchivosFiltrados(String filtro) {
        contenedorLista.getChildren().clear();

        File carpeta = new File("tableros");
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".json"));

        if (archivos != null && archivos.length > 0) {
            ToggleGroup grupo = new ToggleGroup();

            for (File archivo : archivos) {
                String nombre = archivo.getName();
                if (nombre.toLowerCase().contains(filtro.toLowerCase())) {
                    RadioButton rb = new RadioButton(nombre);
                    rb.setToggleGroup(grupo);

                    rb.setOnAction(e -> archivoSeleccionado = nombre);
                    contenedorLista.getChildren().add(rb);
                }
            }
        }
    }
    public static void main(String[] args) {
        ;
    }
}