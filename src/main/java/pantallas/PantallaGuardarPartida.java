package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PantallaGuardarPartida {

    public Scene getScene() {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("¿Qué deseas guardar?");
        TextField tfNombreArchivo = new TextField();
        tfNombreArchivo.setPromptText("Nombre del archivo (sin extensión)");

        Button btnGuardarTodo = new Button("Guardar Partida Completa");
        Button btnGuardarTablero = new Button("Guardar Solo Tablero");
        Button btnSalir = new Button("Salir sin Guardar");

        btnGuardarTodo.setOnAction(e -> {
            String nombre = tfNombreArchivo.getText().trim();
            if (!nombre.isEmpty()) {
                System.out.println("✅ Guardando partida completa como: " + nombre + ".json");
                // Aquí llama a guardarPartidaCompleta(nombre); ← accediendo al estado de juego
                PantallaManager.mostrarPantallaPrincipal();
            } else {
                mostrarAlerta("Por favor, ingresa un nombre de archivo.");
            }
        });

        btnGuardarTablero.setOnAction(e -> {
            String nombre = tfNombreArchivo.getText().trim();
            if (!nombre.isEmpty()) {
                System.out.println("✅ Guardando solo el tablero como: " + nombre + ".json");
                // guardarSoloTablero(nombre); // Por implementar
                PantallaManager.mostrarPantallaPrincipal();
            } else {
                mostrarAlerta("Por favor, ingresa un nombre de archivo.");
            }
        });

        btnSalir.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        layout.getChildren().addAll(lblTitulo, tfNombreArchivo, btnGuardarTodo, btnGuardarTablero, btnSalir);

        return new Scene(layout, 600, 400);
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