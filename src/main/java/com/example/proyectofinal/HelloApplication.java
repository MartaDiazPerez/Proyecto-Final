package com.example.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800,500);
        stage.setTitle("Ejemplo de cómo cargar un gridpane desde un fichero fxml");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
