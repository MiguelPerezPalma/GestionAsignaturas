package Proyecto3EVA.GestionAsignaturas.modelo.entrada;

import java.time.LocalDate;

import Proyecto3EVA.GestionAsignaturas.modelo.asignatura.Asignatura;

public class entrada {
	protected LocalDate fecha;
	protected String Nombre;
	protected int Cod;
	protected String Informacion;
	protected Asignatura asignatura;
	
	public entrada(LocalDate fecha, String nombre, int cod, String informacion, Asignatura asignatura) {
		this.fecha = fecha;
		Nombre = nombre;
		Cod = cod;
		Informacion = informacion;
		this.asignatura = asignatura;
	}
	
	public entrada() {
		this(null,"",-1,"",null);
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
}
