package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ZONAS database table.
 * 
 */
@Entity
@Table(name="ZONAS")
@NamedQuery(name="Zona.findAll", query="SELECT z FROM Zona z")
public class Zona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ZONAS_IDZONA_GENERATOR", sequenceName="SEQ_ID_ZONA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ZONAS_IDZONA_GENERATOR")
	@Column(name="ID_ZONA", unique=true, nullable=false, precision=38)
	private long idZona;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="zona")
	private List<Actividad> actividades;

	public Zona() {
	}

	public long getIdZona() {
		return this.idZona;
	}

	public void setIdZona(long idZona) {
		this.idZona = idZona;
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
		actividade.setZona(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setZona(null);

		return actividade;
	}

}