package app;

import Clases.Casilla;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.PartidaGuardada;
import modelo.ResumenPartida;
import pantallas.*;

import java.io.IOException;

public class PantallaManager {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void mostrarPantallaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(PantallaManager.class.getResource("/PantallaPrincipal.fxml"));
            Scene scene = new Scene(loader.load(), 800, 500);
            stage.setTitle("CONQUISTA");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Aquí añadirás métodos como:
    // mostrarPantallaTutorial(), mostrarPantallaJuego(), etc.
    public static void mostrarPantallaTutorial() {
        Scene scene = new PantallaTutorial().getScene();
        stage.setTitle("Tutorial - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaEleccionTablero() {
        Scene scene = new PantallaEleccionTablero().getScene();
        stage.setTitle("Elección de Tablero - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaConfiguracionTablero() {
        Scene scene = new PantallaConfiguracionTablero().getScene();
        stage.setTitle("Configurar Nuevo Tablero - CONQUISTA");
        stage.setScene(scene);
    }

//    public static void mostrarPantallaMiPropioTablero() {
//        Scene scene = new PantallaMiPropioTablero().getScene();
//        stage.setTitle("Mi Propio Tablero - CONQUISTA");
//        stage.setScene(scene);
//    }

    public static void mostrarPantallaEleccionPersonajes() {
        Scene scene = new PantallaEleccionPersonajes().getScene();
        stage.setTitle("Elección de Personajes - CONQUISTA");
        stage.setScene(scene);
    }

//    public static void mostrarPantallaJuego() {
//        Scene scene = new PantallaJuego().getScene();
//        stage.setTitle("Partida en curso - CONQUISTA");
//        stage.setScene(scene);
//    }

    public static void mostrarPantallaResultados(String equipoGanador) {
        Scene scene = new PantallaResultados(equipoGanador).getScene();
        stage.setTitle("Resultados - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaFinPartida() {
        Scene scene = new PantallaFinPartida().getScene();
        stage.setTitle("Fin de Partida - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaGuardarPartida() {
        Scene scene = new PantallaGuardarPartida().getScene();
        stage.setTitle("Guardar Partida - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPartidaCargada(PartidaGuardada partida) {
        Scene scene = new PantallaJuego(partida.getTablero(), partida.getUnidades(), partida.getTurno()).getScene();
        stage.setTitle("Partida Cargada - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaJugarAnterior() {
        Scene scene = new PantallaJugarAnterior().getScene();
        stage.setTitle("Cargar Partida - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaFinPartidaConGanador(String equipoGanador) {
        Scene scene = new PantallaResultados(equipoGanador).getScene();
        stage.setTitle("Fin de Partida - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaFinPartidaConResumen(String ganador, ResumenPartida resumen) {
        Scene scene = new PantallaResultados(ganador).getScene();
        stage.setTitle("Fin de Partida - CONQUISTA");
        stage.setScene(scene);
    }

    public static void mostrarPantallaEleccionPersonajesDesdeTablero(Casilla[][] casillas) {
    }

    public static void mostrarPantallaMiPropioTablero() {
    }

    public static void mostrarPantallaJuego() {

    }
}