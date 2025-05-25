package pantallas;

import Clases.Casilla;
import app.PantallaManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import modelo.TableroPersonalizado;

import java.io.FileWriter;
import java.io.IOException;

public class PantallaMiPropioTablero {

    private final int filas;
    private final int columnas;

    private Casilla[][] datosCasillas;
    private Button[][] botonesCasilla;

    private Casilla casillaSeleccionada;

    // Sliders e info visual
    private Slider sliderAtaque;
    private Slider sliderDefensa;
    private Slider sliderMovimiento;

    private Label lblAtaque;
    private Label lblDefensa;
    private Label lblMovimiento;

    public PantallaMiPropioTablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        datosCasillas = new Casilla[filas][columnas];
        botonesCasilla = new Button[filas][columnas];

        // Inicializar todas las casillas con valores por defecto
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datosCasillas[i][j] = new Casilla(); // Usa el constructor por defecto
            }
        }
    }

    public Scene getScene() {
        BorderPane root = new BorderPane();

        // Construir tablero visual (centro)
        GridPane tablero = new GridPane();
        tablero.setHgap(4);
        tablero.setVgap(4);
        tablero.setAlignment(Pos.CENTER);
        tablero.setPadding(new Insets(20));

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Button boton = new Button();
                boton.setPrefSize(45, 45);
                final int f = fila;
                final int c = col;
                boton.setOnAction(e -> seleccionarCasilla(f, c));
                botonesCasilla[fila][col] = boton;
                tablero.add(boton, c, fila);
            }
        }

        // Panel lateral (derecha)
        VBox panelDerecho = construirPanelEdicion();
        root.setCenter(tablero);
        root.setRight(panelDerecho);

        return new Scene(root, 800, 600);
    }

    private VBox construirPanelEdicion() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setAlignment(Pos.TOP_CENTER);

        Label lblTitulo = new Label("Editar Casilla");

        // Slider Ataque
        sliderAtaque = new Slider(0, 10, 1);
        sliderAtaque.setShowTickLabels(true);
        sliderAtaque.setShowTickMarks(true);
        lblAtaque = new Label("Ataque: 1");

        sliderAtaque.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblAtaque.setText("Ataque: " + newVal.intValue());
            if (casillaSeleccionada != null) {
                casillaSeleccionada.setAtaqueExtra(newVal.intValue());
            }
        });

        // Slider Defensa
        sliderDefensa = new Slider(0, 10, 1);
        sliderDefensa.setShowTickLabels(true);
        sliderDefensa.setShowTickMarks(true);
        lblDefensa = new Label("Defensa: 1");

        sliderDefensa.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblDefensa.setText("Defensa: " + newVal.intValue());
            if (casillaSeleccionada != null) {
                casillaSeleccionada.setDefensaExtra(newVal.intValue());
            }
        });

        // Slider Movimiento
        sliderMovimiento = new Slider(1, 5, 1);
        sliderMovimiento.setShowTickLabels(true);
        sliderMovimiento.setShowTickMarks(true);
        lblMovimiento = new Label("Movimiento: 1");

        sliderMovimiento.valueProperty().addListener((obs, oldVal, newVal) -> {
            lblMovimiento.setText("Movimiento: " + newVal.intValue());
            if (casillaSeleccionada != null) {
                casillaSeleccionada.setCosteMovimiento(newVal.intValue());
            }
        });

        // Botón Guardar y continuar
        Button btnSiguiente = new Button("Siguiente");
        btnSiguiente.setOnAction(e -> {
            guardarTableroComoJson();
            PantallaManager.mostrarPantallaEleccionPersonajes();
        });

        panel.getChildren().addAll(
                lblTitulo,
                lblAtaque, sliderAtaque,
                lblDefensa, sliderDefensa,
                lblMovimiento, sliderMovimiento,
                btnSiguiente
        );

        return panel;
    }

    private void seleccionarCasilla(int fila, int col) {
        casillaSeleccionada = datosCasillas[fila][col];
        // Reflejar los valores actuales de la casilla en los sliders
        sliderAtaque.setValue(casillaSeleccionada.getAtaqueExtra());
        sliderDefensa.setValue(casillaSeleccionada.getDefensaExtra());
        sliderMovimiento.setValue(casillaSeleccionada.getCosteMovimiento());
    }

    private void guardarTableroComoJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        TableroPersonalizado tablero = new TableroPersonalizado(datosCasillas);

        try (FileWriter writer = new FileWriter("tableros/mi_tablero_personalizado.json")) {
            gson.toJson(tablero, writer);
            System.out.println("✅ Tablero guardado exitosamente.");
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el tablero: " + e.getMessage());
        }
    }


}