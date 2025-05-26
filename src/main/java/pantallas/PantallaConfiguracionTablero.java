package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.converter.NumberStringConverter;

public class PantallaConfiguracionTablero {

    public Scene getScene() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label lblAncho = new Label("Ancho del tablero:");
        TextField tfAncho = new TextField();
        tfAncho.setPromptText("Ej: 10");

        Label lblAlto = new Label("Alto del tablero:");
        TextField tfAlto = new TextField();
        tfAlto.setPromptText("Ej: 10");

        HBox inputAncho = new HBox(10, lblAncho, tfAncho);
        HBox inputAlto = new HBox(10, lblAlto, tfAlto);
        inputAncho.setAlignment(Pos.CENTER);
        inputAlto.setAlignment(Pos.CENTER);

        Button btnAleatorio = new Button("Tablero Aleatorio");
        Button btnTodoIgual = new Button("Todo Igual");
        Button btnCrearPropio = new Button("Crear Propio");
        Button btnVolver = new Button("Volver");

        btnAleatorio.setOnAction(e -> {
            System.out.println("Crear tablero aleatorio con " + tfAncho.getText() + " x " + tfAlto.getText());
            PantallaManager.mostrarPantallaEleccionPersonajes();
        });

        btnTodoIgual.setOnAction(e -> {
            System.out.println("Crear tablero TODO IGUAL con " + tfAncho.getText() + " x " + tfAlto.getText());
            PantallaManager.mostrarPantallaEleccionPersonajes();
        });

        btnCrearPropio.setOnAction(e -> {
            System.out.println("Ir a crear propio tablero con " + tfAncho.getText() + " x " + tfAlto.getText());
            PantallaManager.mostrarPantallaMiPropioTablero();
        });

        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaEleccionTablero());
        btnCrearPropio.setOnAction(e -> PantallaManager.mostrarPantallaMiPropioTablero());

        layout.getChildren().addAll(inputAncho, inputAlto, btnAleatorio, btnTodoIgual, btnCrearPropio, btnVolver);

        return new Scene(layout, 600, 450);
    }
    public static void main(String[] args) {;
    }

}