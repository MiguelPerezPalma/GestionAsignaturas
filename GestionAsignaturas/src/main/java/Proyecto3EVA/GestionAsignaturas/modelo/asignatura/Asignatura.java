package Proyecto3EVA.GestionAsignaturas.modelo.asignatura;

import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;

public class Asignatura {
	protected int Id;
	protected String Nombre;
	protected List<entrada> entradas;
	public Asignatura(int id, String nombre, List<entrada> entradas) {
		super();
		this.Id = id;
		this.Nombre = nombre;
		this.entradas = entradas;
	}
	
	public Asignatura(int id) {
		super();
		Id = id;
	}

	public Asignatura(int id, String nombre) {
		super();
		Id = id;
		Nombre = nombre;
	}
	public Asignatura(String nombre) {
		super();
		Nombre = nombre;
	}
	public Asignatura() {
		this(-1,"Defecto",null);
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public List<entrada> getEntradas() {
		return entradas;
	}
	public void setEntradas(List<entrada> entradas) {
		this.entradas = entradas;
	}

	@Override
	public String toString() {
		return "Asignatura [Id=" + Id + ", Nombre=" + Nombre + ", entradas=" + entradas + "]";
	}
	
}
