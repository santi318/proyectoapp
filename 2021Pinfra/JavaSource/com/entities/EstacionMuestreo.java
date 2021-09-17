package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTACIONES_MUESTREO database table.
 * 
 */
@Entity
@Table(name="ESTACIONES_MUESTREO")
@NamedQuery(name="EstacionMuestreo.findAll", query="SELECT e FROM EstacionMuestreo e")
public class EstacionMuestreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTACIONES_MUESTREO_IDESTACIONMUESTREO_GENERATOR", sequenceName="SEQ_ESTACION_MUESTREO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTACIONES_MUESTREO_IDESTACIONMUESTREO_GENERATOR")
	@Column(name="ID_ESTACION_MUESTREO", unique=true, nullable=false, precision=38)
	private long idEstacionMuestreo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="estacionesMuestreo")
	private List<Actividad> actividades;

	public EstacionMuestreo() {
	}

	public long getIdEstacionMuestreo() {
		return this.idEstacionMuestreo;
	}

	public void setIdEstacionMuestreo(long idEstacionMuestreo) {
		this.idEstacionMuestreo = idEstacionMuestreo;
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
		actividade.setEstacionesMuestreo(this);

		return actividade;
	}

	public Actividad removeActividade(Actividad actividade) {
		getActividades().remove(actividade);
		actividade.setEstacionesMuestreo(null);

		return actividade;
	}

}