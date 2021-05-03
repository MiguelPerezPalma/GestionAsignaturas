package Proyecto3EVA.GestionAsignaturas.controlador;

import java.io.IOException;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController {

    @FXML
    private TableView<Asignatura> tableAsignaturas;
    
    private TableColumn<Asignatura, String> idcolumna;
    @FXML
    private TableColumn<Asignatura, String> nombrecolumna;
}
