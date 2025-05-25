package pantallas;

import app.PantallaManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PantallaPrincipal {

    public Scene getScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Button btnJugarAnterior = new Button("Jugar Partida Anterior");
        Button btnNuevaPartida = new Button("Jugar Nueva Partida");
        Button btnComoSeJuega = new Button("¿Cómo se Juega?");

        // Acciones de botón (ejemplo, aún no implementadas)
        btnComoSeJuega.setOnAction(e -> {
            System.out.println("Ir a Tutorial (por implementar)");
        });
        btnComoSeJuega.setOnAction(e -> PantallaManager.mostrarPantallaTutorial());
        btnNuevaPartida.setOnAction(e -> PantallaManager.mostrarPantallaEleccionTablero());
        layout.getChildren().addAll(btnJugarAnterior, btnNuevaPartida, btnComoSeJuega);

        return new Scene(layout, 600, 400);
    }
}