package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METODOS_MUESTREO database table.
 * 
 */
@Entity
@Table(name="METODOS_MUESTREO")
@NamedQuery(name="MetodoMuestreo.findAll", query="SELECT m FROM MetodoMuestreo m")
public class MetodoMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="METODOS_MUESTREO_IDMETODO_GENERATOR", sequenceName="SEQ_ID_METODO_MUESTREO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="METODOS_MUESTREO_IDMETODO_GENERATOR")
	@Column(name="ID_METODO", unique=true, nullable=false, precision=38)
	private long idMetodo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="metodosMuestreo")
	private List<Actividad> actividades;

	public MetodoMuestreo() {
	}

	public long getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(long idMetodo) {
		this.idMetodo = idMetodo;
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
		actividade.setMetodosMuestreo(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setMetodosMuestreo(null);

		return actividade;
	}

}