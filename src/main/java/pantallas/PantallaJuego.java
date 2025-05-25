package pantallas;

import Clases.Unidad;
import app.PantallaManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class PantallaJuego {

    private final int filas = 6;
    private final int columnas = 6;
    private Button[][] casillas;
    private String turnoActual = "CIENCIAS";

    private Unidad[][] unidades;
    private Unidad unidadSeleccionada = null;
    private int origenFila = -1;
    private int origenCol = -1;

    private boolean modoAtaque = false;

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

    public Scene getScene() {
        BorderPane root = new BorderPane();

        // Centro: Tablero
        GridPane tablero = new GridPane();
        tablero.setHgap(5);
        tablero.setVgap(5);
        tablero.setPadding(new Insets(20));
        tablero.setAlignment(Pos.CENTER);

        unidades = new Unidad[filas][columnas];


        // Posicionar unidades iniciales
        unidades[0][0] = new Unidad("CIENCIAS", 2);
        unidades[5][5] = new Unidad("LETRAS", 2);
        actualizarTablero();

        private void cambiarTurno() {
            turnoActual = turnoActual.equals("CIENCIAS") ? "LETRAS" : "CIENCIAS";
            System.out.println("Turno ahora: " + turnoActual);
        }

        casillas = new Button[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                Button casilla = new Button();
                casilla.setPrefSize(60, 60);
                casilla.setOnAction(e -> {
                    // Futuro: seleccionar unidad
                    System.out.println("Casilla [" + fila + "," + col + "] seleccionada.");
                });
                casillas[fila][col] = casilla;
                tablero.add(casilla, col, fila);
            }
        }

        private void cambiarTurno() {
            turnoActual = turnoActual.equals("CIENCIAS") ? "LETRAS" : "CIENCIAS";
            System.out.println("Turno ahora: " + turnoActual);
        }

        private void manejarClickCasilla(int fila, int col) {
            Unidad unidad = unidades[fila][col];

            if (unidadSeleccionada == null) {
                // Seleccionar unidad propia
                if (unidad != null && unidad.getEquipo().equals(turnoActual)) {
                    unidadSeleccionada = unidad;
                    origenFila = fila;
                    origenCol = col;
                    System.out.println("Seleccionada unidad en [" + fila + "," + col + "]");
                }
            } else {
                if (modoAtaque) {
                    if (unidad != null && !unidad.getEquipo().equals(turnoActual)) {
                        int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                        if (distancia <= unidadSeleccionada.getAtaque()) {
                            System.out.println("¡Ataque exitoso!");
                            unidades[fila][col] = null; // Eliminar enemigo
                            cambiarTurno();
                        } else {
                            System.out.println("Enemigo fuera de alcance.");
                        }
                    } else {
                        System.out.println("No puedes atacar esa casilla.");
                    }
                    modoAtaque = false;
                    unidadSeleccionada = null;
                    actualizarTablero();
                    return;
                }

                // Mover (como antes)
                if (unidades[fila][col] == null) {
                    int distancia = Math.abs(fila - origenFila) + Math.abs(col - origenCol);
                    if (distancia <= unidadSeleccionada.getMovimiento()) {
                        unidades[fila][col] = unidadSeleccionada;
                        unidades[origenFila][origenCol] = null;
                        System.out.println("Unidad movida a [" + fila + "," + col + "]");
                        cambiarTurno();
                    } else {
                        System.out.println("Movimiento demasiado lejano");
                    }
                } else {
                    System.out.println("Casilla ocupada");
                }

                actualizarEstadisticas(lblEquipo, lblMov, lblAtaque);
                unidadSeleccionada = null;
                unidadSeleccionada = null;
                actualizarEstadisticas(lblEquipo, lblMov, lblAtaque);
                modoAtaque = false;
                actualizarTablero();
            }
        }

        private void actualizarEstadisticas(Label lblEquipo, Label lblMov, Label lblAtaque) {
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
                        if (u.getEquipo().equals("CIENCIAS")) {
                            quedanCiencias = true;
                        } else if (u.getEquipo().equals("LETRAS")) {
                            quedanLetras = true;
                        }
                    }
                }
            }

            if (!quedanCiencias || !quedanLetras) {
                String ganador = quedanCiencias ? "CIENCIAS" : "LETRAS";
                System.out.println("🎉 ¡El equipo " + ganador + " ha ganado!");

                // Aquí puedes redirigir a la pantalla de resultados
                PantallaManager.mostrarPantallaResultados(ganador);
            }
        }
        // Posicionar unidades de ejemplo
        unidades[0][0] = new Unidad("CIENCIAS", 2, 1);
        unidades[5][5] = new Unidad("LETRAS", 2, 1);

        root.setCenter(tablero);

        // Derecha: Panel de acciones
        VBox panelLateral = new VBox(15);
        panelLateral.setPadding(new Insets(20));
        panelLateral.setAlignment(Pos.TOP_CENTER);

        // Turno actual
        Label lblTurno = new Label("Turno: " + turnoActual);

        // Estadísticas
        Label lblInfo = new Label("Unidad seleccionada:");
        Label lblEquipo = new Label("Equipo: -");
        Label lblMov = new Label("Movimiento: -");
        Label lblAtaque = new Label("Ataque: -");

        // Botones
        Button btnMover = new Button("Mover");
        Button btnAtacar = new Button("Atacar");
        Button btnSalir = new Button("Salir");

        // Acciones
        btnMover.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = false;
                System.out.println("Modo MOVER activado. Selecciona casilla vacía.");
            } else {
                System.out.println("Primero selecciona una unidad propia.");
            }
        });

        btnAtacar.setOnAction(e -> {
            if (unidadSeleccionada != null) {
                modoAtaque = true;
                System.out.println("Modo ATAQUE activado. Selecciona unidad enemiga.");
            } else {
                System.out.println("Primero selecciona una unidad propia.");
            }
        });

        btnSalir.setOnAction(e -> {
            System.out.println("Saliendo de la partida...");
            PantallaManager.mostrarPantallaGuardarPartida();
        });

        // Agregar al panel
        panelLateral.getChildren().addAll(
                lblTurno,
                lblInfo, lblEquipo, lblMov, lblAtaque,
                btnMover, btnAtacar, btnSalir
        );

        root.setRight(panelLateral);

        return new Scene(root, 900, 600);
    }
}