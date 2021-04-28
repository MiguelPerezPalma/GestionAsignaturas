package Proyecto3EVA.GestionAsignaturas.modelo.asignatura;

import java.util.List;

import Proyecto3EVA.GestionAsignaturas.modelo.entrada.entrada;

public class AsignaturaDAO extends Asignatura{

	public AsignaturaDAO(int id, String nombre, List<entrada> entradas) {
		super(id, nombre, entradas);
	}
	

}
