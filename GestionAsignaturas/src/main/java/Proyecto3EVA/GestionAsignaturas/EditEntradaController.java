package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.AsignaturaDAO;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entradaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditEntradaController {
	@FXML
	private TextField NombreTexF;
    @FXML
    private MenuItem con;
	@FXML
	private TextArea AnotacionTexA;
	
	@FXML
	private ChoiceBox<Integer> EntradaCHB;
	
	List<entrada> len=entradaDAO.buscarTodasEntradas();
	
	@FXML
	public void initialize() {
		for(entrada en:len) {
			EntradaCHB.getItems().add(en.getCod());
		}
	}
	
	/**
	 * Busca en Lista de entradas Len
	 * Si cod coincide con cod seleccionado en EntradaCHB
	 * Sobreescribo los datos escritos en AnotacionTexA y NombreTexF
	 * Fecha se actualiza a la actual
	 * @throws IOException
	 */
	@FXML
	private void guardarEdicionEntrada() throws IOException {
		for(entrada e:len) {
			if(e.getCod()==EntradaCHB.getSelectionModel().getSelectedItem()) {
				e.setNombre(NombreTexF.getText());
				e.setInformacion(AnotacionTexA.getText());
				LocalDate fecha=LocalDate.now();
				e.setFecha(java.sql.Date.valueOf(fecha));
				e.setCod(e.getCod());
				e.setAsignatura(e.getAsignatura());
				entradaDAO eda=new entradaDAO(e);
				eda.guardarEditar();
				App.setRoot("secondary");
			}
		}
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
