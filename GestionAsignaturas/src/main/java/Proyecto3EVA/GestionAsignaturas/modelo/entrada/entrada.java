package Proyecto3EVA.GestionAsignaturas.modelo.entrada;

import java.sql.Date;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;

public class entrada {
	protected Date fecha;
	protected String Nombre;
	protected int Cod;
	protected String Informacion;
	protected int asignatura_id;
	
	public entrada(Date fecha, String nombre, int cod, String informacion, int asignatura) {
		this.fecha = fecha;
		this.Nombre = nombre;
		this.Cod = cod;
		this.Informacion = informacion;
		this.asignatura_id=asignatura;
	}
	
	public entrada(Date fecha, String nombre, String informacion, int asignatura) {
		super();
		this.fecha = fecha;
		Nombre = nombre;
		Informacion = informacion;
		this.asignatura_id = asignatura;
	}

	public entrada() {
		this(null,"Defecto",-1,"Defecto",-1);
	}
	
	public entrada(int cod) {
		super();
		Cod = cod;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date f) {
		this.fecha = f;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public int getCod() {
		return Cod;
	}
	public void setCod(int cod) {
		Cod = cod;
	}
	public String getInformacion() {
		return Informacion;
	}
	public void setInformacion(String informacion) {
		Informacion = informacion;
	}
	public int getAsignatura() {
		return asignatura_id;
	}
	public void setAsignatura(int asignatura) {
		this.asignatura_id = asignatura;
	}

	@Override
	public String toString() {
		return "entrada [fecha=" + fecha + ", Nombre=" + Nombre + ", Cod=" + Cod + ", Informacion=" + Informacion
				+ ", asignatura_Nombre=" + asignatura_id + "]";
	}


	
}
