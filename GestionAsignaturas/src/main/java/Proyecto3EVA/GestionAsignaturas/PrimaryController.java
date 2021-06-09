package Proyecto3EVA.GestionAsignaturas;

import java.io.IOException;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.AsignaturaDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class PrimaryController {
	private AsignaturaDAO a;
	private List<Asignatura> asignaturas=AsignaturaDAO.buscarTodasAsignaturas();
    @FXML
    private TableView<Asignatura> tableAsignaturas;
    
    @FXML
    private TableColumn<Asignatura, Integer> idcolumna;
    
    @FXML
    private TableColumn<Asignatura, String> nombrecolumna;
    
    @FXML
    private MenuItem con;
    @FXML
    public void closeApp() {
    	System.exit(0);
    }
    
	@FXML
	public void initialize() {
		
		idcolumna.setCellValueFactory(new PropertyValueFactory<Asignatura, Integer>("id"));
		configuratable();
		AsignaturaDAO a = new AsignaturaDAO();
    	List<Asignatura> todas=AsignaturaDAO.buscarTodasAsignaturas();
    	tableAsignaturas.setItems(FXCollections.observableList(todas));
	}
	
	private void configuratable() {
    	nombrecolumna.setCellValueFactory(cadenaAsignatura->{
    		SimpleStringProperty v=new SimpleStringProperty();
    		v.setValue(cadenaAsignatura.getValue().getNombre());
    		return v;
    	});
    }
	
	@FXML
	private void switchToAñadirAsignatura() throws IOException {
		App.setRoot("AddAsignatura");
	}
	@FXML
	private void borrarAsignatura() {
		int id=Integer.parseInt(idcolumna.getText());
		if(id>=0) {
			Asignatura as=new Asignatura(id);
			AsignaturaDAO a=new AsignaturaDAO(as);
			a.eliminar();
			asignaturas.remove(a);
			
			
		}
	}
	@FXML
	private void switchToEntradas() throws IOException {
		App.setRoot("secondary");
	}
}
