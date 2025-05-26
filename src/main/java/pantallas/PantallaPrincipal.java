package pantallas;

import app.PantallaManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PantallaPrincipal {

    @FXML
    private Button btnJugarAnterior;

    @FXML
    private Button btnNuevaPartida;

    @FXML
    private Button btnComoSeJuega;

    @FXML
    public void initialize() {
        btnComoSeJuega.setOnAction(e -> PantallaManager.mostrarPantallaTutorial());
        btnNuevaPartida.setOnAction(e -> PantallaManager.mostrarPantallaEleccionTablero());
        btnJugarAnterior.setOnAction(e -> PantallaManager.mostrarPantallaJugarAnterior());
    }
}