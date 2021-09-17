package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTAMENTOS database table.
 * 
 */
@Entity
@Table(name="DEPARTAMENTOS")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTAMENTOS_IDDEPARTAMENTO_GENERATOR", sequenceName="SEQ_ID_DEPARTAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTAMENTOS_IDDEPARTAMENTO_GENERATOR")
	@Column(name="ID_DEPARTAMENTO", unique=true, nullable=false, precision=38)
	private long idDepartamento;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="departamento")
	private List<Actividad> actividades;

	public Departamento() {
	}

	public long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Actividad> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Actividad addActividade(Actividad actividade) {
		getActividades().add(actividade);
		actividade.setDepartamento(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setDepartamento(null);

		return actividade;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + " ";
	}

	
}