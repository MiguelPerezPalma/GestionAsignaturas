package Proyecto3EVA.GestionAsignaturas.modelo.asignatura;

import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;

public class Asignatura {
	private int Id;
	private String Nombre;
	private List<entrada> entradas;
	public Asignatura(int id, String nombre, List<entrada> entradas) {
		super();
		Id = id;
		Nombre = nombre;
		this.entradas = entradas;
	}
	
	public Asignatura() {
		this(-1,"",null);
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
	
}
