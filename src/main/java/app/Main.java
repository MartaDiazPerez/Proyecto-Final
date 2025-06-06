package app;

import app.PantallaManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        PantallaManager.setStage(stage);
        PantallaManager.mostrarPantallaPrincipal();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
