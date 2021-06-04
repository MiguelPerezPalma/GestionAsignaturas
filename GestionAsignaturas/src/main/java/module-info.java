module Proyecto3EVA.GestionAsignaturas {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens Proyecto3EVA.GestionAsignaturas to javafx.fxml,javafx.base;
    opens Proyecto3EVA.GestionAsignaturas.modelo.asignatura to javafx.base;
    opens Proyecto3EVA.GestionAsignaturas.modelo.entrada to javafx.base;
    exports Proyecto3EVA.GestionAsignaturas;
}
