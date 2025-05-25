package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pantallas.PantallaPrincipal;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        PantallaManager.setStage(primaryStage);  // Inicia el gestor
        PantallaManager.mostrarPantallaPrincipal(); // Pantalla inicial
    }

    public static void main(String[] args) {
        launch(args);
    }
}