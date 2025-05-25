package pantallas;

import app.PantallaManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PantallaEleccionTablero {

    public Scene getScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Button btnTablerosAnteriores = new Button("Tableros Anteriores");
        Button btnNuevoTablero = new Button("Nuevo Tablero");
        Button btnVolver = new Button("Volver al Menú");

        // Acciones de botón (por ahora placeholders)
        btnTablerosAnteriores.setOnAction(e -> {
            System.out.println("Ir a pantalla de tableros anteriores (por implementar)");
        });

        btnNuevoTablero.setOnAction(e -> {
            System.out.println("Ir a pantalla de configuración de nuevo tablero (por implementar)");
        });

        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        btnNuevoTablero.setOnAction(e -> PantallaManager.mostrarPantallaConfiguracionTablero());

        layout.getChildren().addAll(btnTablerosAnteriores, btnNuevoTablero, btnVolver);

        return new Scene(layout, 600, 400);
    }
    public static void main(String[] args) {;
    }
}