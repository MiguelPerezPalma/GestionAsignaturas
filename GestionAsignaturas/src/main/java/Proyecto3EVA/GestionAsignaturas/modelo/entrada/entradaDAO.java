package Proyecto3EVA.GestionAsignaturas.modelo.entrada;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;
import Proyecto3EVA.GestionAsignaturas.utils.Conexion;

public class entradaDAO extends entrada{
	private static final String GETBCOD="SELECT Cod,Nombre,informacion,id_Asignatura as Asignatura FROM entrada WHERE Cod=";
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
	
}
