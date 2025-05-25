package pantallas;

import app.PantallaManager;
import com.example.proyectofinal.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaPrincipal {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800,500);
        stage.setTitle("Ejemplo de cómo cargar un gridpane desde un fichero fxml");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {;
    }

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