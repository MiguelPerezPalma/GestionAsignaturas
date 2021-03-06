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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddEntradaController {

	
	@FXML
	private TextField NombreTexF;
	
	@FXML
	private TextArea AnotacionTexA;
    @FXML
    private MenuItem con;
	@FXML
	private ChoiceBox<String> AsignaturaCHB;
	
	List<Asignatura> la=AsignaturaDAO.buscarTodasAsignaturas();
	@FXML
	public void initialize() {
		for(Asignatura as:la) {
			AsignaturaCHB.getItems().add(as.getNombre());
		}
	}
	/**
	 * Identifico el ID de la Asignatura seleccionada usando una lista de asignaturas LA
	 * Se incerta fecha actual
	 * Guardo los datos introducidos en NombreTexF, AnotacionTexA.
	 * Guardo los datos en una nueva entrada y cargo la entrada en una nueva entradaDAO
	 * entradaDAO se guarda en la Base de datos
	 * @throws IOException
	 */
	@FXML
	private void guardadEntrada() throws IOException {
		
			String nombre=NombreTexF.getText();
			String informacion =AnotacionTexA.getText();
			LocalDate fecha=LocalDate.now();
			Date d=java.sql.Date.valueOf(fecha);
			String nAs=AsignaturaCHB.getSelectionModel().getSelectedItem();
			int idAS=0;
			for(Asignatura as:la) {
					if(as.getNombre().equals(nAs)) {
						idAS=as.getId();
					}
			}
			entrada e=new entrada(d, nombre, informacion, idAS);
			entradaDAO eda=new entradaDAO(e);
			eda.guardar();
		App.setRoot("secondary");
	}
	/**
	 * Ruta a SecondaryController
	 * @throws IOException
	 */
	@FXML
	private void switchToEntrada() throws IOException {
		App.setRoot("secondary");;
	}
    @FXML
    public void closeApp() {
    	System.exit(0);
    }
}
