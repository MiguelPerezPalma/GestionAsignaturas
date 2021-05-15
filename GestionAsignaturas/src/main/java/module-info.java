module Proyecto3EVA.GestionAsignaturas {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens Proyecto3EVA.GestionAsignaturas to javafx.fxml;
    exports Proyecto3EVA.GestionAsignaturas;
}
