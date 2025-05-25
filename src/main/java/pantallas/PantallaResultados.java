package pantallas;

import app.PantallaManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaResultados {

    private String equipoGanador;

    public PantallaResultados(String ganador) {
        this.equipoGanador = ganador;
    }

    public Scene getScene() {
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);

        Label lblResultado = new Label("🎉 ¡Victoria del equipo " + equipoGanador + "!");
        Button btnContinuar = new Button("Finalizar");

        btnContinuar.setOnAction(e -> {
            PantallaManager.mostrarPantallaFinPartida(); // por implementar
        });

        layout.getChildren().addAll(lblResultado, btnContinuar);
        return new Scene(layout, 600, 400);
    }
}