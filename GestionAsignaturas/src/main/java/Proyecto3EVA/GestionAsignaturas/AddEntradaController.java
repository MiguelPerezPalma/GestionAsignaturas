package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.AsignaturaDAO;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entradaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEntradaController {

	
	@FXML
	private TextField NombreTexF;
	
	@FXML
	private TextArea AnotacionTexA;
	
	@FXML
	private DatePicker FechaDP;
	
	@FXML
	private ChoiceBox<String> AsignaturaCHB;
	
	List<entrada> le=entradaDAO.buscarTodasEntradas();
	List<Asignatura> la=AsignaturaDAO.buscarTodasAsignaturas();
	@FXML
	public void initialize() {
		for(Asignatura as:la) {
			AsignaturaCHB.getItems().add(as.getNombre());
		}
	}
	
	@FXML
	private void guardadEntrada() throws IOException {
		
			String nombre=NombreTexF.getText();
			String informacion =AnotacionTexA.getText();
			LocalDate fecha=FechaDP.getValue();
			String nAs=AsignaturaCHB.getSelectionModel().getSelectedItem();
			int idAS=0;
			for(Asignatura as:la) {
					if(as.getNombre().equals(nAs)) {
						idAS=as.getId();
					}
			}
			entrada e=new entrada(fecha, nombre, informacion, idAS);
			entradaDAO eda=new entradaDAO(e);
			eda.guardar();
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
