package Proyecto3EVA.GestionAsignaturas.modelo.asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.utils.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AsignaturaDAO extends Asignatura{
	private final static String GETBYID = "SELECT Id,Nombre FROM asignatura WHERE dni=";
	private final static String INSERTUPDATE="INSERT INTO asignatura (Id,Nombre) ";
	private static final String DELETE="DELETE FROM asignatura WHERE Cod=?";
	private final static String SELECTASIGNATURAS = "SELECT * FROM asignatura ";
	public AsignaturaDAO() {
		super();
	}
	
	public AsignaturaDAO(Asignatura a) {
		this.Id=a.getId();
		this.Nombre=a.getNombre();
	}
	
	public AsignaturaDAO(int id, String Nombre) {
		super(id,Nombre);
	}
	public AsignaturaDAO(String Nombre) {
		super(Nombre);
	}
	public AsignaturaDAO(int id) {
		// getByID from mariaDB
		// Conexion
		super();
		Connection con = Conexion.getConexion();
		// Stament
		if (con != null) {
			try {
				Statement st = con.createStatement();
				String q=GETBYID+"'"+Id+"'";
				ResultSet rs =st.executeQuery(q);
				while(rs.next()) {
					this.Id=rs.getInt("Id");
					this.Nombre=rs.getString("Nombre");
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
				q.setInt(1, this.Id);
				q.setString(2, this.Nombre);
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
				q.setInt(1, this.Id);
				rs =q.executeUpdate();
				this.Id=-1;
				this.Nombre="";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
    public static List<entrada> selectAll(){
        return selectAll();
  }
	public static ObservableList<Asignatura> buscarTodasAsignaturas() {
		ObservableList<Asignatura> result = FXCollections.observableArrayList();
		Connection con = Conexion.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(SELECTASIGNATURAS);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					Asignatura a = new Asignatura();
					a.setId(rs.getInt("Id"));
					a.setNombre(rs.getString("Nombre"));
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
