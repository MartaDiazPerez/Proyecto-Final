package pantallas;

import Clases.Casilla;
import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PantallaMiPropioTablero {

    private int filas = 5;   // puedes pasar valores reales luego
    private int columnas = 5;
    private Casilla[][] datosCasillas;
    private Casilla casillaSeleccionada;

    private Button[][] casillas;

    casillas = new Button[filas][columnas];
    datosCasillas = new Casilla[filas][columnas];

    for (int fila = 0; fila < filas; fila++) {
        for (int col = 0; col < columnas; col++) {
            Button casilla = new Button();
            casilla.setPrefSize(50, 50);

            datosCasillas[fila][col] = new Casilla();

            int finalFila = fila;
            int finalCol = col;
            casilla.setOnAction(e -> abrirEditorDeCasilla(finalFila, finalCol));

            casillas[fila][col] = casilla;
            tablero.add(casilla, col, fila);
        }
    }

    public Scene getScene() {
        BorderPane root = new BorderPane();

        GridPane tablero = new GridPane();
        tablero.setHgap(5);
        tablero.setVgap(5);
        tablero.setAlignment(Pos.CENTER);
        tablero.setPadding(new Insets(20));

        casillas = new Button[filas][columnas];

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Button casilla = new Button();
                casilla.setPrefSize(50, 50);
                int finalFila = fila;
                int finalCol = col;
                casilla.setOnAction(e -> abrirEditorDeCasilla(finalFila, finalCol));
                casillas[fila][col] = casilla;
                tablero.add(casilla, col, fila);
            }
        }

        VBox panelDerecho = construirPanelEditor();
        root.setCenter(tablero);
        root.setRight(panelDerecho);

        return new Scene(root, 800, 600);
    }

    private VBox construirPanelEditor() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setAlignment(Pos.TOP_CENTER);

        Label lblInfo = new Label("Editar Casilla");

        Slider sliderAtaque = new Slider(0, 10, 1);
        Label lblAtaque = new Label("Ataque: 1");

        Slider sliderDefensa = new Slider(0, 10, 1);
        Label lblDefensa = new Label("Defensa: 1");

        Slider sliderMovimiento = new Slider(1, 5, 1);
        Label lblMovimiento = new Label("Movimiento: 1");

        // Listeners para actualizar valores en tiempo real
        sliderAtaque.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblAtaque.setText("Ataque: " + newVal.intValue());
            if (casillaSeleccionada != null) casillaSeleccionada.setAtaque(newVal.intValue());
        });

        sliderDefensa.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblDefensa.setText("Defensa: " + newVal.intValue());
            if (casillaSeleccionada != null) casillaSeleccionada.setDefensa(newVal.intValue());
        });

        sliderMovimiento.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblMovimiento.setText("Movimiento: " + newVal.intValue());
            if (casillaSeleccionada != null) casillaSeleccionada.setMovimiento(newVal.intValue());
        });

        Button btnSiguiente = new Button("Siguiente");
        btnSiguiente.setOnAction(e -> {
            // Imprimir datos para ver que están guardados correctamente
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(datosCasillas[i][j] + " ");
                }
                System.out.println();
            }

            btnSiguiente.setOnAction(e -> {
                guardarTableroComoJson();
                PantallaManager.mostrarPantallaEleccionPersonajes();
            });
            // Aquí puedes ir a la siguiente pantalla
            // PantallaManager.mostrarPantallaEleccionPersonajes();
        });

        panel.getChildren().addAll(lblInfo, lblAtaque, sliderAtaque, lblDefensa, sliderDefensa, lblMovimiento, sliderMovimiento, btnSiguiente);
        return panel;
    }

    private void abrirEditorDeCasilla(int fila, int col) {
        casillaSeleccionada = datosCasillas[fila][col];
        System.out.println("Editando casilla [" + fila + "," + col + "] " + casillaSeleccionada);
    }


}