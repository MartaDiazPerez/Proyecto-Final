package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PantallaTutorial {

    public Scene getScene() {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Text texto = new Text(obtenerTextoTutorial());
        texto.setWrappingWidth(500);

        ScrollPane scrollPane = new ScrollPane(texto);
        scrollPane.setFitToWidth(true);
        layout.setCenter(scrollPane);

        Button btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> PantallaManager.mostrarPantallaPrincipal());

        BorderPane.setAlignment(btnVolver, Pos.CENTER);
        layout.setBottom(btnVolver);

        return new Scene(layout, 600, 400);
    }

    private String obtenerTextoTutorial() {
        return """
            Bienvenido a CONQUISTA, un juego de estrategia por turnos.

            Objetivo: Elimina todas las unidades del equipo enemigo.

            Turnos:
            - Cada jugador controla unidades por turnos.
            - Puedes mover o atacar con una unidad en tu turno.

            Tipos de terreno:
            - Algunas casillas aumentan defensa o dificultan movimiento.
            - Solo puedes entrar si tienes suficiente capacidad de movimiento.

            Unidades:
            - Cada equipo tiene distintas unidades con ataque, defensa y rango.
            - Solo una unidad por casilla.
            - No puedes mover a una casilla ocupada.

            Gana el primer equipo que elimine todas las unidades enemigas.
            """;
    }
}