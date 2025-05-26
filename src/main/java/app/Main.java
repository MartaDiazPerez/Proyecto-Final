package app;

import app.PantallaManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            PantallaManager.setStage(stage); // Asigna el Stage global

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/PantallaPrincipal.fxml"));
            Scene scene = new Scene(loader.load(), 800, 500);

            stage.setTitle("Juego de Conquista");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}