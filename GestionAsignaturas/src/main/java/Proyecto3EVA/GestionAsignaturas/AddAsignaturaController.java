package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.AsignaturaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddAsignaturaController {
	
	@FXML
	private TextField NombreTexF;
    @FXML
    private MenuItem con;
    @FXML
    public void closeApp() {
    	System.exit(0);
    }
	private AsignaturaDAO a;
	
	@FXML
	private void guardarAsignatura() throws IOException {
		if(a.getId() >=0) {			
			a.setNombre(NombreTexF.getText());
			a.guardar();
			App.setRoot("primary");
		}
	}
	
	@FXML
	private void switchToAsignatura() throws IOException {
		App.setRoot("primary");
	}
}
