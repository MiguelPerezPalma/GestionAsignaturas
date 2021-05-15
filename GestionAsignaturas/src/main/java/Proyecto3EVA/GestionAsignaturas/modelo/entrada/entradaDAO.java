package Proyecto3EVA.GestionAsignaturas.modelo.entrada;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.utils.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class entradaDAO extends entrada{
	private static final String GETBCOD="SELECT fecha,Cod,Nombre,informacion,id_Asignatura as Asignatura FROM entrada WHERE Cod=";
	private final static String INSERTUPDATE="INSERT INTO entrada (fecha,Cod,Nombre,informacion,id_Asignatura) ";
	private static final String DELETE="DELETE FROM entrada WHERE Cod=?";
	private final static String SELECTENTRADA = "SELECT COD,NOMBRE,INFORMACION FROM entrada ";
	public entradaDAO(LocalDate fecha, String nombre, int cod, String informacion, Asignatura asignatura) {
		super(fecha, nombre, cod, informacion, asignatura);
	}

	public entradaDAO() {
		super();
	}
	public entradaDAO(entrada e) {
		this.fecha=e.getFecha();
		this.Nombre=e.getNombre();
		this.Cod=e.getCod();
		this.Informacion=e.getInformacion();
		this.asignatura=e.getAsignatura();
	}
	
	public entradaDAO(int cod) {
		super();
		Connection con = Conexion.getConexion();
		// Stament
		if (con != null) {
			try {
				Statement st = con.createStatement();
				String q=GETBCOD+Cod;
				ResultSet rs =st.executeQuery(q);
				while(rs.next()) {
					
					this.Cod=rs.getInt("cod");
					this.Nombre=rs.getString("nombre");
					this.Informacion=rs.getString("informacion");
					
					
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int guardar() {
		// INSERT o UPDATE
		//INSERT -> si no existe OK
		//En caso de ERROR -> hago un update
		int rs=0;
		Connection con = Conexion.getConexion();
		
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(INSERTUPDATE);
				q.setInt(1, this.Cod);
				q.setString(2, this.Nombre);
				q.setString(3, this.Informacion);
				q.setInt(4, this.asignatura.getId());
				rs =q.executeUpdate();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public int eliminar() {
		int rs=0;
		Connection con = Conexion.getConexion();
		
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(DELETE);
				q.setInt(1, this.Cod);
				rs =q.executeUpdate();
				this.Cod=-1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static ObservableList<entrada> buscarTodasEntradas() {
		ObservableList<entrada> result = FXCollections.observableArrayList();
		Connection con = Conexion.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECTENTRADA);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					entrada a = new entrada();
					a.setCod(rs.getInt("Cod"));
					a.setNombre(rs.getString("Nombre"));
					a.setInformacion(rs.getString("Informacion"));
					System.out.println(a);
					result.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
