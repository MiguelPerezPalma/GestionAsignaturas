package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entradaDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class SecondaryController {
	private List<entrada> entradas=entradaDAO.buscarTodasEntradas();
    @FXML
    private TableView<entrada> tableEntradas;
    
    @FXML
    private TableColumn<entrada, Date> fechaColumna;
    
    @FXML
    private TableColumn<entrada, String> nombrecolumna;
    
    @FXML
    private TableColumn<entrada, Integer> codColumna;
    
    @FXML
    private TableColumn<entrada, String> asignaturacolumna;
    
    @FXML
    private Label informacionLabel;
    
    @FXML
    private Label codLabel;
    
    @FXML
    private MenuItem con;
    
    @FXML
    public void closeApp() {
    	System.exit(0);
    }
    
    @FXML
    protected void initialize() {
    	muestraInfo(null);
    	codColumna.setCellValueFactory(new PropertyValueFactory<entrada, Integer>("Cod"));
    	fechaColumna.setCellValueFactory(new PropertyValueFactory<entrada, Date>("fecha"));
    	configuratable();
    	List<entrada> todas=entradaDAO.buscarTodasEntradas();
    	tableEntradas.setItems(FXCollections.observableList(todas));
    	tableEntradas.getSelectionModel().selectedItemProperty().addListener((Observable,oldValue,newValue)->{
    		muestraInfo(newValue);
    	});
    }
	
    private void configuratable() {
    	nombrecolumna.setCellValueFactory(cadaentrada->{
    		SimpleStringProperty v=new SimpleStringProperty();
    		v.setValue(cadaentrada.getValue().getNombre());
    		return v;
    	});
    	asignaturacolumna.setCellValueFactory(cadaentrada->{
    		SimpleStringProperty v=new SimpleStringProperty();
    		v.setValue(Integer.toString(cadaentrada.getValue().getAsignatura()));
    		return v;
    	});
    }
	@FXML
	private void switchToAñadirEntrada() throws IOException {
		App.setRoot("AddEntrada");
	}
	@FXML
	private void switchToAsignatura() throws IOException {
		App.setRoot("primary");
	}
	
    private void muestraInfo(entrada e) {
    	if (e!=null) {
    		informacionLabel.setText(e.getInformacion());
    		codLabel.setText(Integer.toString(e.getCod()));
		}else {
			informacionLabel.setText("");
			codLabel.setText("");
		}
    }
    
	@FXML
	private void borrarEntradas() throws IOException {
		
		int cod=Integer.parseInt(codLabel.getText());
		if(cod>=-1) {
			entrada e=new entrada(cod);
			entradaDAO a=new entradaDAO(e);
			entradas.remove(a);
			a.eliminar();
			App.setRoot("secondary");
		}
	}
}