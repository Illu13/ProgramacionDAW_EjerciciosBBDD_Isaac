package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipologiasexo database table.
 * 
 */
@Entity
@Table(name="tipologiasexo")
@NamedQuery(name="Tipologiasexo.findAll", query="SELECT t FROM Tipologiasexo t")
public class Tipologiasexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="tipologiasexo")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="tipologiasexo")
	private List<Profesor> profesors;

	public Tipologiasexo() {
	}
	
	public String toString() {
		return this.descripcion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setTipologiasexo(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setTipologiasexo(null);

		return estudiante;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setTipologiasexo(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setTipologiasexo(null);

		return profesor;
	}

}