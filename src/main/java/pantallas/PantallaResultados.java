package pantallas;

import app.PantallaManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.ResumenPartida;

public class PantallaResultados {

    private final String equipoGanador;
    private ResumenPartida resumen = null;

    public PantallaResultados(String ganador) {
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
        Button btnContinuar = new Button("Ir a Fin de Partida");

        btnContinuar.setOnAction(e -> {
            PantallaManager.mostrarPantallaFinPartida(); // por implementar
        });

        layout.getChildren().addAll(
                lblVictoria, lblResumen,
                lblTurnos, lblCiencias, lblLetras,
                btnMenu, btnCerrar
        );

        return new Scene(layout, 600, 450);
    }

}