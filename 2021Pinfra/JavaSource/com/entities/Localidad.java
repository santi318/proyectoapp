package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOCALIDADES database table.
 * 
 */
@Entity
@Table(name="LOCALIDADES")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCALIDADES_IDLOCALIDAD_GENERATOR", sequenceName="SEQ_ID_LOCALIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCALIDADES_IDLOCALIDAD_GENERATOR")
	@Column(name="ID_LOCALIDAD", unique=true, nullable=false, precision=38)
	private long idLocalidad;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="localidade")
	private List<Actividad> actividades;

	public Localidad() {
	}

	public long getIdLocalidad() {
		return this.idLocalidad;
	}

	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
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
		actividade.setLocalidade(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setLocalidade(null);

		return actividade;
	}

}