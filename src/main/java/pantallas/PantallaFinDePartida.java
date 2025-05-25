package pantallas;

import app.PantallaManager;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.ResumenPartida;

public class PantallaFinDePartida {

    private final String equipoGanador;
    private final ResumenPartida resumen;

    public PantallaFinDePartida(String ganador) {
        this.equipoGanador = ganador;
        this.resumen = resumen;
    }

    public Scene getScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label lblVictoria = new Label(" ¡Victoria del equipo " + equipoGanador + "!");
        Label lblResumen = new Label(" Resumen de la Partida:");
        Label lblTurnos = new Label("Turnos jugados: " + resumen.getTurnosTotales());
        Label lblCiencias = new Label("Unidades de Letras eliminadas: " + resumen.getEliminadasLetras());
        Label lblLetras = new Label("Unidades de Ciencias eliminadas: " + resumen.getEliminadasCiencias());

        Button btnMenu = new Button("Menú Principal");
        Button btnCerrar = new Button("Cerrar Juego");

        btnMenu.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());
        btnCerrar.setOnAction(e -> Platform.exit());

        layout.getChildren().addAll(
                lblVictoria, lblResumen,
                lblTurnos, lblCiencias, lblLetras,
                btnMenu, btnCerrar
        );

        return new Scene(layout, 600, 450);
    }
}