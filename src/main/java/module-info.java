module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    // Abre tus paquetes reales
    opens app to javafx.graphics, javafx.fxml;
    opens pantallas to javafx.fxml;

    // Exporta si lo vas a usar desde otros módulos
    exports app;
    exports pantallas;
}