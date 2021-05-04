package Proyecto3EVA.GestionAsignaturas.modelo.asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;
import Proyecto3EVA.GestionAsignaturas.utils.Conexion;

public class AsignaturaDAO extends Asignatura{
	private final static String GETBYID = "SELECT Id,Nombre FROM Asignatura WHERE dni=";
	private final static String INSERTUPDATE="INSERT INTO Asignatura (Id,Nombre) ";
	private static final String DELETE="DELETE FROM Asignatura WHERE Cod=?";
	public AsignaturaDAO(int id, String nombre, List<entrada> entradas) {
		super(id, nombre, entradas);
	}
	public AsignaturaDAO() {
		super();
	}
	
	public AsignaturaDAO(Asignatura a) {
		this.Id=a.getId();
		this.Nombre=a.getNombre();
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
}
