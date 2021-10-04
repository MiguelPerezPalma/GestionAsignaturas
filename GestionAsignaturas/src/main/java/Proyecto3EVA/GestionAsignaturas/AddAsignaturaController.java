package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.util.List;
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
	f
	@FXML
	private void guardarAsignatura() throws IOException {
		String nombre=NombreTexF.getText();
		if(nombre.isBlank()) {
		Asignatura a=new Asignatura();
		AsignaturaDAO ada=new AsignaturaDAO(a);
		ada.guardar();	
		}else {
		Asignatura a=new Asignatura(nombre);
		AsignaturaDAO ada=new AsignaturaDAO(a);
		ada.guardar();
		}
		App.setRoot("primary");
	}
	
	@FXML
	private void switchToAsignatura() throws IOException {
		App.setRoot("primary");
	}
}
