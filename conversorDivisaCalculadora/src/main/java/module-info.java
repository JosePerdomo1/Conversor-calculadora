module es.iesvigan.jose.conversordivisacalculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens es.iesvigan.jose.conversordivisacalculadora to javafx.fxml;
    exports es.iesvigan.jose.conversordivisacalculadora;
}
