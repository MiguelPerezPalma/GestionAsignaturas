package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entradaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEntradaController {

	
	@FXML
	private TextField NombreTexF;
	
	@FXML
	private TextArea AnotacionTexA;
	
	private entradaDAO e;
	
	@FXML
	private void guardadEntrada() throws IOException {
		if(e.getCod()>=0) {
			e.setNombre(NombreTexF.getText());
			e.setInformacion(AnotacionTexA.getText());
			e.setFecha(LocalDate.now());
			e.guardar();
		}
		App.setRoot("secondary");
	}
	@FXML
	private void switchToAsignatura() throws IOException {
		App.setRoot("primary");
	}
    @FXML
    public void closeApp() {
    	System.exit(0);
    }
}
