package pantallas;
import modelo.*;
import Clases.Casilla;
import Clases.Unidad;
import app.PantallaManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import modelo.PartidaGuardada;

import java.io.FileWriter;
import java.io.IOException;




public class PantallaJuego {

    private final int filas;
    private final int columnas;
    private Casilla[][] tableroCasillas;
    private Unidad[][] unidades;
    private String turnoActual;
    private Button[][] casillas;
    private Unidad unidadSeleccionada;
    private int origenFila, origenCol;
    private boolean modoAtaque;

    private Label lblEquipo;
    private Label lblMov;
    private Label lblAtaque;


    public PantallaJuego(Casilla[][] tablero, Unidad[][] unidades, String turno) {
        this.tableroCasillas = tablero;
        this.unidades = unidades;
        this.turnoActual = turno;

        this.filas = tablero.length;
        this.columnas = tablero[0].length;
    }

    private void guardarPartidaCompleta(String nombreArchivo) {
        PartidaGuardada partida = new PartidaGuardada(tableroCasillas, unidades, turnoActual);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(nombreArchivo + ".json")) {
            gson.toJson(partida, writer);
            System.out.println("Partida guardada como " + nombreArchivo + ".json");
            Logger.escribirLog("Partida guardada como " + nombreArchivo + ".json");
        } catch (IOException e) {
            System.err.println("Error al guardar partida: " + e.getMessage());
            Logger.escribirLog("Error al guardar partida: " + e.getMessage());
        }
    }

    private void cambiarTurno() {
        turnoActual = turnoActual.equals("CIENCIAS") ? "LETRAS" : "CIENCIAS";
        System.out.println("Turno ahora: " + turnoActual);
        Logger.escribirLog("Cambio de turno. Ahora juega: " + turnoActual);
    }

    private void actualizarTablero() {
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                if (unidades[fila][col] != null) {
                    casillas[fila][col].setText(unidades[fila][col].toString());
                } else {
                    casillas[fila][col].setText("");
                }
            }
        }
    }

    private void manejarClickCasilla(int fila, int col) {
        Unidad unidad = unidades[fila][col];

        if (unidadSeleccionada == null) {
            if (unidad != null && unidad.getEquipo().equals(turnoActual)) {
                unidadSeleccionada = unidad;
                origenFila = fila;
                origenCol = col;
                System.out.println("Seleccionada unidad en [" + fila + "," + col + "]");
                Logger.escribirLog("Unidad seleccionada en [" + fila + "," + col + "] por el equipo " + turnoActual);
            }


        } else {
            if (modoAtaque) {
                if (unidad != null && !unidad.getEquipo().equals(turnoActual)) {
                    int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                    if (distancia <= unidadSeleccionada.getAtaque()) {
                        System.out.println("¡Ataque exitoso!");
                        Logger.escribirLog("Ataque exitoso del equipo " + turnoActual + " desde [" + origenFila + "," + origenCol + "] a [" + fila + "," + col + "]");
                        unidades[fila][col] = null;
                        cambiarTurno();
                        verificarFinDePartida();
                    } else {
                        System.out.println("Enemigo fuera de alcance.");
                        Logger.escribirLog("Ataque fallido: enemigo fuera de alcance [" + origenFila + "," + origenCol + "] -> [" + fila + "," + col + "]");
                    }
                } else {
                    System.out.println("No puedes atacar esa casilla.");
                    Logger.escribirLog("Ataque inválido: casilla no válida en [" + fila + "," + col + "]");
                }
                modoAtaque = false;
                unidadSeleccionada = null;
                actualizarTablero();
                return;
            }

            if (unidades[fila][col] == null) {
                int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                if (distancia <= unidadSeleccionada.getMovimiento()) {
                    unidades[fila][col] = unidadSeleccionada;
                    unidades[origenFila][origenCol] = null;
                    System.out.println("Unidad movida a [" + fila + "," + col + "]");
                    Logger.escribirLog("Unidad del equipo " + turnoActual + " movida de [" + origenFila + "," + origenCol + "] a [" + fila + "," + col + "]");
                    cambiarTurno();
                } else {
                    System.out.println("Movimiento demasiado lejano");
                    Logger.escribirLog("Movimiento inválido por el equipo " + turnoActual + ": de [" + origenFila + "," + origenCol + "] a [" + fila + "," + col + "]");
                }
            } else {
                System.out.println("Casilla ocupada");
                Logger.escribirLog("Movimiento fallido: la casilla [" + fila + "," + col + "] ya está ocupada");
            }

            actualizarEstadisticas();
            unidadSeleccionada = null;
            modoAtaque = false;
            actualizarTablero();
        }
    }

    private void actualizarEstadisticas() {
        if (unidadSeleccionada != null) {
            lblEquipo.setText("Equipo: " + unidadSeleccionada.getEquipo());
            lblMov.setText("Movimiento: " + unidadSeleccionada.getMovimiento());
            lblAtaque.setText("Ataque: " + unidadSeleccionada.getAtaque());
        } else {
            lblEquipo.setText("Equipo: -");
            lblMov.setText("Movimiento: -");
            lblAtaque.setText("Ataque: -");
        }
    }

    private void verificarFinDePartida() {
        boolean quedanCiencias = false;
        boolean quedanLetras = false;

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Unidad u = unidades[fila][col];
                if (u != null) {
                    if (u.getEquipo().equals("CIENCIAS")) quedanCiencias = true;
                    if (u.getEquipo().equals("LETRAS")) quedanLetras = true;
                }
            }
        }

        if (!quedanCiencias || !quedanLetras) {
            String ganador = quedanCiencias ? "CIENCIAS" : "LETRAS";
            System.out.println("🎉 ¡El equipo " + ganador + " ha ganado!");
            Logger.escribirLog("Fin de la partida. Ganador: " + ganador);
            PantallaManager.mostrarPantallaResultados(ganador);
        }
    }

    public Scene getScene() {
        BorderPane root = new BorderPane();

        GridPane tablero = new GridPane();
        tablero.setHgap(5);
        tablero.setVgap(5);
        tablero.setPadding(new Insets(20));
        tablero.setAlignment(Pos.CENTER);

        casillas = new Button[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Button casilla = new Button();
                casilla.setPrefSize(60, 60);
                final int f = fila;
                final int c = col;
                casilla.setOnAction(e -> manejarClickCasilla(f, c));
                casillas[fila][col] = casilla;
                tablero.add(casilla, col, fila);
            }
        }

        // Inicializar algunas unidades
        unidades[0][0] = new Unidad("CIENCIAS", 2, 1);
        unidades[5][5] = new Unidad("LETRAS", 2, 1);

        actualizarTablero();

        VBox panelLateral = new VBox(15);
        panelLateral.setPadding(new Insets(20));
        panelLateral.setAlignment(Pos.TOP_CENTER);

        Label lblTurno = new Label("Turno: " + turnoActual);
        Label lblInfo = new Label("Unidad seleccionada:");
        lblEquipo = new Label("Equipo: -");
        lblMov = new Label("Movimiento: -");
        lblAtaque = new Label("Ataque: -");

        Button btnMover = new Button("Mover");
        Button btnAtacar = new Button("Atacar");
        Button btnSalir = new Button("Salir");

        btnMover.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = false;
                System.out.println("Modo MOVER activado. Selecciona casilla vacía.");
                Logger.escribirLog("Modo MOVER activado por el equipo " + turnoActual);
            } else {
                System.out.println("Primero selecciona una unidad propia.");
                Logger.escribirLog("Intento de activar MODO MOVER sin unidad seleccionada");
            }
        });

        btnAtacar.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = true;
                System.out.println("Modo ATAQUE activado. Selecciona unidad enemiga.");
                Logger.escribirLog("Modo ATAQUE activado por el equipo " + turnoActual);
            } else {
                System.out.println("Primero selecciona una unidad propia.");
                Logger.escribirLog("Intento de activar MODO ATAQUE sin unidad seleccionada");
            }
        });

        btnSalir.setOnAction(e -> {
            System.out.println("Saliendo de la partida...");
            Logger.escribirLog("Jugador salió de la partida");
            PantallaManager.mostrarPantallaGuardarPartida();
        });

        panelLateral.getChildren().addAll(
                lblTurno,
                lblInfo, lblEquipo, lblMov, lblAtaque,
                btnMover, btnAtacar, btnSalir
        );

        root.setCenter(tablero);
        root.setRight(panelLateral);

        return new Scene(root, 900, 600);
    }
    public static void main(String[] args) {;
    }


}
