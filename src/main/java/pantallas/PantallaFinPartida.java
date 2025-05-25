package pantallas;

import app.PantallaManager;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaFinPartida {

    public Scene getScene() {
        VBox layout = new VBox(25);
        layout.setAlignment(Pos.CENTER);

        Label lblGracias = new Label("¡Gracias por jugar CONQUISTA!");

        Button btnGuardarTablero = new Button("Guardar Tablero");
        Button btnMenuPrincipal = new Button("Menú Principal");
        Button btnCerrar = new Button("Cerrar Juego");

        btnGuardarTablero.setOnAction(e -> {
            System.out.println("📁 Guardar tablero actual... (Por implementar)");
            // Aquí podrías reutilizar guardarTableroComoJson() si conservas la matriz Casilla[][]
        });

        btnMenuPrincipal.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        btnCerrar.setOnAction(e -> Platform.exit());

        layout.getChildren().addAll(lblGracias, btnGuardarTablero, btnMenuPrincipal, btnCerrar);

        return new Scene(layout, 600, 400);
    }
    public static void main(String[] args) {;
    }

}