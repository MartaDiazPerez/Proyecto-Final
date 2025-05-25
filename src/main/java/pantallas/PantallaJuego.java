package pantallas;

import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import Clases.Casilla;
import modelo.ResumenPartida;
import Clases.Unidad;

public class PantallaJuego {

    private final int filas = 6;
    private final int columnas = 6;

    private Casilla[][] tableroCasillas;
    private Unidad[][] unidades;

    private String turnoActual = "CIENCIAS";
    private int turnosTotales = 0;
    private int eliminadasCiencias = 0;
    private int eliminadasLetras = 0;

    private Button[][] botones;
    private Unidad unidadSeleccionada = null;
    private int origenFila = -1, origenCol = -1;
    private boolean modoAtaque = false;

    private Label lblTurno, lblEquipo, lblMov, lblAtaque;

    public PantallaJuego() {
        // Tablero plano por defecto
        tableroCasillas = new Casilla[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tableroCasillas[i][j] = new Casilla(); // Si tienes constructor con atributos, cámbialo

        unidades = new Unidad[filas][columnas];

        // Posicionar unidades de ejemplo
        unidades[0][0] = new Unidad("CIENCIAS", 2, 1);
        unidades[5][5] = new Unidad("LETRAS", 2, 1);
    }

    public Scene getScene() {
        BorderPane root = new BorderPane();

        GridPane tablero = new GridPane();
        tablero.setHgap(4);
        tablero.setVgap(4);
        tablero.setAlignment(Pos.CENTER);
        tablero.setPadding(new Insets(20));

        botones = new Button[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Button b = new Button();
                b.setPrefSize(60, 60);
                int f = fila;
                int c = col;
                b.setOnAction(e -> manejarClickCasilla(f, c));
                botones[fila][col] = b;
                tablero.add(b, col, fila);
            }
        }

        root.setCenter(tablero);

        VBox panelLateral = construirPanelEstadisticas();
        root.setRight(panelLateral);

        actualizarTablero();

        return new Scene(root, 900, 600);
    }

    private VBox construirPanelEstadisticas() {
        VBox panel = new VBox(15);
        panel.setPadding(new Insets(20));
        panel.setAlignment(Pos.TOP_CENTER);

        lblTurno = new Label("Turno: " + turnoActual);
        Label lblUnidad = new Label("Unidad seleccionada:");

        lblEquipo = new Label("Equipo: -");
        lblMov = new Label("Movimiento: -");
        lblAtaque = new Label("Ataque: -");

        Button btnMover = new Button("Mover");
        Button btnAtacar = new Button("Atacar");
        Button btnSalir = new Button("Salir");

        btnMover.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = false;
            }
        });

        btnAtacar.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = true;
            }
        });

        btnSalir.setOnAction(e -> {
            PantallaManager.mostrarPantallaGuardarPartida(); // Implementado aparte
        });

        panel.getChildren().addAll(lblTurno, lblUnidad, lblEquipo, lblMov, lblAtaque, btnMover, btnAtacar, btnSalir);
        return panel;
    }

    private void manejarClickCasilla(int fila, int col) {
        Unidad actual = unidades[fila][col];

        if (unidadSeleccionada == null) {
            if (actual != null && actual.getEquipo().equals(turnoActual)) {
                unidadSeleccionada = actual;
                origenFila = fila;
                origenCol = col;
                actualizarEstadisticas();
            }
        } else {
            if (modoAtaque) {
                if (actual != null && !actual.getEquipo().equals(turnoActual)) {
                    int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                    if (distancia <= unidadSeleccionada.getAtaque()) {
                        if (actual.getEquipo().equals("CIENCIAS")) eliminadasCiencias++;
                        else eliminadasLetras++;

                        unidades[fila][col] = null;
                        verificarFinDePartida();
                        cambiarTurno();
                    }
                }
                modoAtaque = false;
                unidadSeleccionada = null;
                actualizarEstadisticas();
                actualizarTablero();
                return;
            }

            if (unidades[fila][col] == null) {
                int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                if (distancia <= unidadSeleccionada.getMovimiento()) {
                    unidades[fila][col] = unidadSeleccionada;
                    unidades[origenFila][origenCol] = null;
                    cambiarTurno();
                }
            }
            unidadSeleccionada = null;
            actualizarEstadisticas();
            actualizarTablero();
        }
    }

    private void cambiarTurno() {
        turnoActual = turnoActual.equals("CIENCIAS") ? "LETRAS" : "CIENCIAS";
        lblTurno.setText("Turno: " + turnoActual);
        turnosTotales++;
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

    private void actualizarTablero() {
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Unidad u = unidades[fila][col];
                botones[fila][col].setText(u != null ? (u.getEquipo().equals("CIENCIAS") ? "C" : "L") : "");
            }
        }
    }

    private void verificarFinDePartida() {
        boolean quedanCiencias = false;
        boolean quedanLetras = false;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Unidad u = unidades[i][j];
                if (u != null) {
                    if (u.getEquipo().equals("CIENCIAS")) quedanCiencias = true;
                    else quedanLetras = true;
                }
            }
        }

        if (!quedanCiencias || !quedanLetras) {
            String ganador = quedanCiencias ? "CIENCIAS" : "LETRAS";
            ResumenPartida resumen = new ResumenPartida(turnosTotales, eliminadasCiencias, eliminadasLetras);
            PantallaManager.mostrarPantallaFinPartidaConResumen(ganador, resumen);
        }
    }
}