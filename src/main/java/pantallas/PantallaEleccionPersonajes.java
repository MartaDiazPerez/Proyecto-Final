package pantallas;

import app.PantallaManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PantallaEleccionPersonajes {

    public Scene getScene() {
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);

        Button btnCiencias = new Button("Equipo CIENCIAS ");
        Button btnLetras = new Button("Equipo LETRAS ");

        // Acciones al elegir un equipo
        btnCiencias.setOnAction(e -> {
            System.out.println("Equipo elegido: CIENCIAS");
            PantallaManager.mostrarPantallaJuego();
        });

        btnLetras.setOnAction(e -> {
            System.out.println("Equipo elegido: LETRAS");
            PantallaManager.mostrarPantallaJuego();
        });

        layout.getChildren().addAll(btnCiencias, btnLetras);

        return new Scene(layout, 600, 400);
    }
    public static void main(String[] args) {;
    }

}